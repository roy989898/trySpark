import static spark.Spark.get;

/**
 * Created by pomingpo on 2017/6/19.
 */
public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
