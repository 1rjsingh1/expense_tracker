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


}
