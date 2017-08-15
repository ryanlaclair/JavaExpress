import org.javaexpress.JavaExpress;
import org.javaexpress.http.HTTPStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class TestJavaExpress {

    public static void main(String[] args) throws Exception {
        Map<String, Student> studentList = new HashMap<>();

        JavaExpress app = new JavaExpress();

        app.get("/", (req, res) -> {
            res.send("Welcome to school");
        });

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

        app.post("/students", (req, res) -> {
            String studentName = req.body();
            studentList.put(studentName, new Student(studentName));

            res.send("Added student " + studentName);
        });

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

        app.post("/students/:name/classes", (req, res) -> {
           String name = req.params().get("name");
           if (studentList.containsKey(name)) {
               String className = req.body();
               studentList.get(name).addClass(className);

               res.send("Added class " + className + " to student " + name);
           }
        });

        app.listen(8999);
    }

}
