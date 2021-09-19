package com.rstudy.expense_tracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("category")
public class Category {
    @Id
    public String id;
    public String cat;
    public Category()
    {

    }
    public Category(String id, String cat) {
        this.id = id;
        this.cat = cat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
