package com.rstudy.expense_tracker.controller;

import com.rstudy.expense_tracker.exception.ResourceNotFoundException;
import com.rstudy.expense_tracker.model.Expense;
import com.rstudy.expense_tracker.model.User;
import com.rstudy.expense_tracker.repository.ExpenseRepository;
import com.rstudy.expense_tracker.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/users/{id}/expenses")
@CrossOrigin(origins = "http://localhost:4200/")
public class ExpenseController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ExpenseRepository expenseRepository;



    @GetMapping
    public ResponseEntity<List<Expense>> getAll(@PathVariable("id") String id)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Employee Doesn't Exist:"+id
                ));
        Map<String,Expense> expenseMap=user.getExpenseMap();
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
    @PostMapping
    public ResponseEntity<String> addExpense(@PathVariable("id") String id,@RequestBody Expense expense)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Employee Doesn't Exist:"+id
                ));


        expenseRepository.save(expense);
        Map<String,Expense> expenseMap=user.getExpenseMap();
        if(expenseMap==null)
            expenseMap=new HashMap<String,Expense>();

        expenseMap.put(expense.getId(),expense);
        user.setExpenseMap(expenseMap);
        userRepository.save(user);
        return ResponseEntity.ok("Expense Added");
    }

    @PutMapping("/{eid}")
    public ResponseEntity<String> updateExpense(@PathVariable("id") String id,
                                                @PathVariable("eid") String eid,
                                                @RequestBody Expense expense)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Employee Doesn't Exist:"+id
                ));
        Map<String,Expense> expenseMap=user.getExpenseMap();
        Expense expense1=expenseMap.get(expense.getId());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(expense,expense1);
        expense1.setId(eid);
        expenseMap.put(expense1.getId(),expense1);
        user.setExpenseMap(expenseMap);
        userRepository.save(user);
        expenseRepository.save(expense);
        return ResponseEntity.ok("Expense Update");
    }

    @DeleteMapping("/{eid}")
    public ResponseEntity<String> delExpense(@PathVariable("id") String id,@PathVariable("eid") String eid)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Employee Doesn't Exist:"+id
                ));
        Map<String,Expense> expenseMap=user.getExpenseMap();
        expenseMap.remove(eid);
        user.setExpenseMap(expenseMap);
        Expense expense=expenseRepository.findById(eid)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Expense Doesn't Exist:"+eid
                ));
        expenseRepository.delete(expense);
        userRepository.save(user);
        return ResponseEntity.ok("Expense Deleted");

    }
}
