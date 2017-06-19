import Objects.Model;
import Objects.NewPostPayload;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by pomingpo on 2017/6/19.
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();


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
        });
    }


}

