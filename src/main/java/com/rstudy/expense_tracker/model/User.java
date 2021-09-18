package com.rstudy.expense_tracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document("Users")
public class User {
    public User()
    {

    }
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private String password;
    private Map<String,Expense> expenseMap;
    private Map<String,Income> incomeMap;

    public User(String id, String firstName, String lastName, String email, Long phone, String password, Map<String, Expense> expenseMap, Map<String, Income> incomeMap) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.expenseMap = expenseMap;
        this.incomeMap = incomeMap;
    }

    public Map<String, Expense> getExpenseMap() {
        return expenseMap;
    }

    public void setExpenseMap(Map<String, Expense> expenseMap) {
        this.expenseMap = expenseMap;
    }

    public Map<String, Income> getIncomeMap() {
        return incomeMap;
    }

    public void setIncomeMap(Map<String, Income> incomeMap) {
        this.incomeMap = incomeMap;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
