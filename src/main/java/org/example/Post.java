package org.example;

import java.net.http.HttpResponse;
import java.util.Objects;

public class Post {
    private long userID;
    private long id;
    private String title;
    private String body;

    public Post(JSONPlaceholder jsonPlaceholder) {
        this.jsonPlaceholder = jsonPlaceholder;
    }

    private JSONPlaceholder jsonPlaceholder;

    public Post() {

    }

    public Post getSinglePost(int id) {
        HttpResponse<String>response = jsonPlaceholder.getSinglePost(id);
        if(response.statusCode() == 200) {
            return JSONMapper.convertJSON(response.body());

        } else {
            throw new RuntimeException();
        }

    }

    public Post(long userID, long id, String title, String body) {
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getUserID() {
        return userID;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userID=" + userID +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return userID == post.userID && id == post.id && Objects.equals(title, post.title) && Objects.equals(body, post.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, id, title, body);
    }
}
