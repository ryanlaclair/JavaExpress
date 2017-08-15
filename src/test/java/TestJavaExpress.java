import org.javaexpress.JavaExpress;
import org.javaexpress.http.HTTPStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a class to test the JavaExpress framework. It creates a server
 * that simulates a school with Students. Server routes are defined in the
 * main method.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class TestJavaExpress {

    /**
     * The program entry point. Create a JavaExpress server, set up routes,
     * and start the server listening on port 8999.
     *
     * @param args the command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Map<String, Student> studentList = new HashMap<>();

        // create the JavaExpress application
        JavaExpress app = new JavaExpress();

        // welcome the client to school
        app.get("/", (req, res) -> {
            res.send("Welcome to school");
        });

        // get the list of students
        app.get("/students", (req, res) -> {
            if (studentList.isEmpty()) {
                res.status(HTTPStatus.NOT_FOUND);
                res.send(HTTPStatus.NOT_FOUND.toString());
            }
            else {
                String students = "";

                for (Map.Entry<String, Student> entry : studentList.entrySet()) {
                    students += (entry.getValue().getName() + "\n");
                }

                res.send(students);
            }
        });

        // add a student to the list
        app.post("/students", (req, res) -> {
            String studentName = req.body();
            studentList.put(studentName, new Student(studentName));

            res.send("Added student " + studentName);
        });

        // get the list of classes for a student
        app.get("/students/:name/classes", (req, res) -> {
            String name = req.params().get(("name"));
            if (studentList.containsKey(name)) {
                String classes = studentList.get(name).getClasses();
                res.send(name + " classes:\n" + classes);
            }
            else {
                res.redirect(HTTPStatus.NOT_FOUND, "/");
            }
        });

        // add a class to a student
        app.post("/students/:name/classes", (req, res) -> {
           String name = req.params().get("name");
           if (studentList.containsKey(name)) {
               String className = req.body();
               studentList.get(name).addClass(className);

               res.send("Added class " + className + " to student " + name);
           }
        });

        // start the server listening on port 8999
        app.listen(8999);
    }

}
