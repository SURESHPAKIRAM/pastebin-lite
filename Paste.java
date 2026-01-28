package com.example.pastebinlite.model;

import java.io.Serializable;

public class Paste implements Serializable {
    private String id;
    private String content;
    private Long created_at;
    private Integer ttl_seconds; 
    private Integer max_views;   
    private Integer views;       

    public Paste() {}

    public Paste(String id, String content, Long created_at, Integer ttl_seconds, Integer max_views) {
        this.id = id;
        this.content = content;
        this.created_at = created_at;
        this.ttl_seconds = ttl_seconds;
        this.max_views = max_views;
        this.views = 0;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Long getCreated_at() { return created_at; }
    public void setCreated_at(Long created_at) { this.created_at = created_at; }
    public Integer getTtl_seconds() { return ttl_seconds; }
    public void setTtl_seconds(Integer ttl_seconds) { this.ttl_seconds = ttl_seconds; }
    public Integer getMax_views() { return max_views; }
    public void setMax_views(Integer max_views) { this.max_views = max_views; }
    public Integer getViews() { return views; }
    public void setViews(Integer views) { this.views = views; }
}