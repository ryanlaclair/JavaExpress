import org.javaexpress.JavaExpress;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class TestJavaExpress {

    public static void main(String[] args) throws Exception {
        JavaExpress app = new JavaExpress();

        app.get("/", (req, res) -> {
            res.send("GET");
        });

        app.post("/dog", (req, res) -> {
            System.out.println(req.body());
            res.append("this", "dog");
            res.send("POST");
        });

        app.listen(8999);
    }

}
