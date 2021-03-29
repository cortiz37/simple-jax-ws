package com.rs.model;

import java.util.Map;

public class Data {

    private int id;

    private Map<String, Object> content;

    public Data() {
    }

    public Data(int id, Map<String, Object> content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }
}
