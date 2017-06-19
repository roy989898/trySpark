import Objects.NewPostPayload;
import Objects.Sql20Model;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.sql2o.Sql2o;

import java.util.UUID;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by pomingpo on 2017/6/19.
 */
public class Main {
    private static final String DB_URL = "jdbc:sqlite:test.db";

    public static void main(String[] args) {

        Sql2o sql2o = connectToDatabase();

        Sql20Model model = new Sql20Model(sql2o);


        get("/hello", (req, res) -> {
            return "Hello";
        });

        // insert a post (using HTTP post method)
        post("/posts", (request, response) -> {
            try {
                Gson gson = new Gson();
                NewPostPayload creation = gson.fromJson(request.body(), NewPostPayload.class);
                if (!creation.isValid()) {
                    response.status(HTTP_BAD_REQUEST);
                    return "";
                }
                UUID id = model.createPost(creation.getTitle(), creation.getContent(), creation.getCategories());
                response.status(200);
                response.type("application/json");
                return id.toString();
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
        });
    }

    private static Sql2o connectToDatabase() {


        Sql2o sql2o = null;
        try {
//            Class.forName("org.sqlite.JDBC");

            sql2o = new Sql2o(DB_URL, null, null);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        return sql2o;

    }


}

