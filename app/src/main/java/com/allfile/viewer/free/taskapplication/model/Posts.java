package com.allfile.viewer.free.taskapplication.model;

import com.google.gson.annotations.SerializedName;

public class Posts {

    @SerializedName("userId")
    private Integer userId;
    @SerializedName("id")
    private Integer id;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public Posts(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}