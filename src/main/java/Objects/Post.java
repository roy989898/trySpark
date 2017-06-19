package Objects;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by pomingpo on 2017/6/19.
 */

class Post {
    private UUID post_uuid;
    private String title;
    private String content;
    private Date publishing_date;
    private List categories;

    public UUID getPost_uuid() {
        return post_uuid;
    }

    public void setPost_uuid(UUID post_uuid) {
        this.post_uuid = post_uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishing_date() {
        return publishing_date;
    }

    public void setPublishing_date(Date publishing_date) {
        this.publishing_date = publishing_date;
    }

    public List getCategories() {
        return categories;
    }

    public void setCategories(List categories) {
        this.categories = categories;
    }
}