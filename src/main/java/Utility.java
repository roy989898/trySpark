import com.google.gson.Gson;

/**
 * Created by pomingpo on 2017/6/19.
 */
public class Utility {
    public static String dataToJson(Object data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }
}
