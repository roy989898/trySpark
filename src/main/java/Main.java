import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.get;

/**
 * Created by pomingpo on 2017/6/19.
 */
public class Main {
    private static final String DB_URL = "jdbc:sqlite:test.db";

    public static void main(String[] args) {

        Connection connection = connectToDatabase();


        get("/hello", (req, res) -> {
            return "Hello";
        });

        /*// insert a post (using HTTP post method)
        post("/posts", (request, response) -> {
            try {
                Gson gson = new Gson();
                NewPostPayload creation = gson.fromJson(request.body(), NewPostPayload.class);
                if (!creation.isValid()) {
                    response.status(HTTP_BAD_REQUEST);
                    return "";
                }
                int id = model.createPost(creation.getTitle(), creation.getContent(), creation.getCategories());
                response.status(200);
                response.type("application/json");
                return id;
            } catch (JsonSyntaxException jpe) {
                response.status(HTTP_BAD_REQUEST);
                return "";
            }
        });

        // get all post (using HTTP get method)
        get("/posts", (request, response) -> {
            response.status(200);
            response.type("application/json");
            String returnString = Utility.dataToJson(model.getAllPosts());
            return returnString;
        });*/
    }

    private static org.sql2o.Connection connectToDatabase() {


        org.sql2o.Connection connection = null;
        try {
//            Class.forName("org.sqlite.JDBC");

            Sql2o sql2o = new Sql2o(DB_URL,null,null);
            connection = sql2o.open();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        return connection;

    }


}

