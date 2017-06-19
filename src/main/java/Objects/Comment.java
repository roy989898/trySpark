package Objects;

import java.util.Date;
import java.util.UUID;

/**
 * Created by pomingpo on 2017/6/19.
 */
public class Comment {
    private UUID comment_uuid;
    private UUID post_uuid;
    private String author;
    private String content;
    private boolean approved;
    private Date submission_date;

    public UUID getComment_uuid() {
        return comment_uuid;
    }

    public void setComment_uuid(UUID comment_uuid) {
        this.comment_uuid = comment_uuid;
    }

    public UUID getPost_uuid() {
        return post_uuid;
    }

    public void setPost_uuid(UUID post_uuid) {
        this.post_uuid = post_uuid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Date getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(Date submission_date) {
        this.submission_date = submission_date;
    }
}
