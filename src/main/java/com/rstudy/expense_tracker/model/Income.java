package com.rstudy.expense_tracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("income")
public class Income {
    @Id
    private String Id;
    private Long amount;
    private String description;
    private Date created_on;
    private boolean type;
    private String Category;

    public Income() {}

    public Income(Long amount, String description, Date created_on, boolean type, String category) {
        this.amount = amount;
        this.description = description;
        this.created_on = created_on;
        this.type = type;
        Category = category;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
