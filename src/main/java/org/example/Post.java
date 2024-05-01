package org.example;

public class Post {
    private int userID;
    private int id;
    private String title;
    private String body;

    public Post(int userID, int id, String title, String body) {
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
