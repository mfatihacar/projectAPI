package com.sky.dto.articles.response;

import java.util.List;

public class ArticleResponse {

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getSensitive() {
        return sensitive;
    }

    public List<String> getTopics() {
        return topics;
    }

    public Image getImage() {
        return image;
    }

    public int getPriority() {
        return priority;
    }

    private String id;
    private String createdAt;
    private String title;
    private Boolean sensitive;
    private List<String> topics = null;
    private Image image;
    private int priority;
}
