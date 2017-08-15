import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a very simple student with a name and a list
 * of classes.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class Student {

    private String name;
    private List<String> classes = new ArrayList<>();

    /**
     * Create a new Student object.
     *
     * @param name the student name
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * Get the student name.
     *
     * @return the student name
     */
    public String getName() {
        return name;
    }

    /**
     * Add a class to the student class list.
     *
     * @param className the class name
     */
    public void addClass(String className) {
        classes.add(className);
    }

    /**
     * Get the student classes.
     *
     * @return the class list
     */
    public String getClasses() {
        String classesString = "";

        for (String className : classes) {
            classesString += (className + "\n");
        }

        return classesString;
    }

}
