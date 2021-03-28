package com.sky.dto.articles.Request;

import com.sky.dto.articles.response.Image;

import java.util.List;


public class ArticleRequest {

    private String id;
    private String createdAt;
    private String title;
    private boolean sensitive;
    private List<String> topics = null;
    private Image image;
    private int priority;

    public static ArticleRequest newInstance(String id, String createdAt, String title, boolean sensitive, List<String> topics, Image image, int priority) {
        ArticleRequest articleRequest = new ArticleRequest();
        articleRequest.setId(id);
        articleRequest.setCreatedAt(createdAt);
        articleRequest.setTitle(title);
        articleRequest.setSensitive(sensitive);
        articleRequest.setImage(image);
        articleRequest.setPriority(priority);
        return articleRequest;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSensitive(Boolean sensitive) {
        this.sensitive = sensitive;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
