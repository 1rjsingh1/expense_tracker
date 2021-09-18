package com.rstudy.expense_tracker.model;

import com.rstudy.expense_tracker.dto.UserDto;
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
    private UserDto userDto;
    private boolean type;
    private String Category;

    public Income() {}

    public Income(String id, Long amount, String description, Date created_on, UserDto userDto, boolean type, String category) {
        Id = id;
        this.amount = amount;
        this.description = description;
        this.created_on = created_on;
        this.userDto = userDto;
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
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
