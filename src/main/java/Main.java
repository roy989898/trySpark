import Objects.Model;
import Objects.NewPostPayload;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
                ObjectMapper mapper = new ObjectMapper();
                NewPostPayload creation = mapper.readValue(request.body(), NewPostPayload.class);
                if (!creation.isValid()) {
                    response.status(HTTP_BAD_REQUEST);
                    return "";
                }
                int id = model.createPost(creation.getTitle(), creation.getContent(), creation.getCategories());
                response.status(200);
                response.type("application/json");
                return id;
            } catch (JsonParseException jpe) {
                response.status(HTTP_BAD_REQUEST);
                return "";
            }
        });


    }
}
