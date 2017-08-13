import org.javaexpress.JavaExpress;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class TestJavaExpress {

    public static void main(String[] args) throws Exception {
        JavaExpress app = new JavaExpress();

        app.get("/dogs/:id", (req, res) -> {
            System.out.println(req.params().get("id"));
            res.send("GET");
        });

        app.get("/dogs/:id/:name", (req, res) -> {
            System.out.println(req.params().get("id"));
            System.out.println(req.params().get("name"));
            res.send("GET");
        });

        app.post("/dog", (req, res) -> {
            System.out.println(req.body());
            res.send("POST");
        });

        app.listen(8999);
    }

}
