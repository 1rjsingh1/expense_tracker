package com.rstudy.expense_tracker.dto;

import com.rstudy.expense_tracker.model.Expense;
import com.rstudy.expense_tracker.model.Income;

import java.util.Map;

public class UserDto {
    public UserDto(){

    }
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private Map<String, Expense> expenseMap;
    private Map<String, Income> incomeMap;

    public UserDto(String id, String firstName, String lastName, String email, Long phone, Map<String, Expense> expenseMap, Map<String, Income> incomeMap) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
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

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhone() {
        return phone;
    }
}
