package com.rstudy.expense_tracker.model;

import com.rstudy.expense_tracker.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document("expense")
public class Expense {
    @Id
    private String Id;

    private Long amount;
    private String description;
    private Date expense_date;
    private boolean type;// Recurring- Non-Recurring
    private String Category;
    private int interval; // Reminder Interval
    private boolean status; // Expense completed

    public Expense()
    {

    }
    public Expense(Long amount, String description, Date expense_date, boolean type, String category, int interval, boolean status) {
        this.amount = amount;
        this.description = description;
        this.expense_date = expense_date;
        this.type = type;
        Category = category;
        this.interval = interval;
        this.status = status;
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

    public Date getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(Date expense_date) {
        this.expense_date = expense_date;
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

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
