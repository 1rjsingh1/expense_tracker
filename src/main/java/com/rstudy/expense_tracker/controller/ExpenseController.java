package com.rstudy.expense_tracker.controller;

import com.rstudy.expense_tracker.exception.ResourceNotFoundException;
import com.rstudy.expense_tracker.model.Expense;
import com.rstudy.expense_tracker.model.User;
import com.rstudy.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/users/{id}/expenses")
public class ExpenseController {
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity<List<Expense>> getAll(@PathVariable("id") String id)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Employee Doesn't Exist:"+id
                ));
        List<Expense> targetList = new ArrayList<>(user.getExpenseMap().values());
        return ResponseEntity.ok(targetList);
    }
    @GetMapping("/{eid}")
    public ResponseEntity<Expense> getById(@PathVariable("id") String id,@PathVariable("eid") String eid)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Employee Doesn't Exist:"+id
                ));
        Map<String,Expense> expenseMap=user.getExpenseMap();
        return ResponseEntity.ok(expenseMap.get(eid));
    }
}
