package Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pomingpo on 2017/6/19.
 */
// In a real application you may want to use a DB, for this example we just store the posts in memory
public class Model {
    private int nextId = 1;
    private Map posts = new HashMap<>();


    public int createPost(String title, String content, List categories) {
        int id = nextId++;
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setCategories(categories);
        posts.put(id, post);
        return id;
    }

    public List getAllPosts() {
        List<Post> postList = new ArrayList<>(posts.values());
        return postList;
    }
}
