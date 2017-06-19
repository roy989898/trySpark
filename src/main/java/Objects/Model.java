package Objects;

import java.util.List;
import java.util.UUID;

/**
 * Created by pomingpo on 2017/6/19.
 */
// In a real application you may want to use a DB, for this example we just store the posts in memory
public interface Model {
    UUID createPost(String title, String content, List categories);

    UUID createComment(UUID post, String author, String content);

    List getAllPosts();

    List getAllCommentsOn(UUID post);

    boolean existPost(UUID post);

}
