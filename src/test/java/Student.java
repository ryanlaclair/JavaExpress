import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class Student {

    private String name;
    private List<String> classes = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addClass(String className) {
        classes.add(className);
    }

    public String getClasses() {
        String classesString = "";

        for (String className : classes) {
            classesString += (className + "\n");
        }

        return classesString;
    }

}
