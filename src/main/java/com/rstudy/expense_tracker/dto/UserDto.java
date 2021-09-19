package com.rstudy.expense_tracker.dto;

import com.rstudy.expense_tracker.model.Expense;
import com.rstudy.expense_tracker.model.Income;

import java.util.Map;

public class UserDto {
    public UserDto() {

    }

    private String firstName;
    private String lastName;
    private String email;
    private Long phone;

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

    public UserDto(String firstName, String lastName, String email, Long phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
