package com.rstudy.expense_tracker.controller;
import com.rstudy.expense_tracker.exception.ResourceNotFoundException;
import com.rstudy.expense_tracker.model.Income;
import com.rstudy.expense_tracker.model.User;
import com.rstudy.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/users/{id}/income")
public class IncomeController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Map<String, Income>> getAll (@PathVariable("id") String id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User doesnt exist" + id));
        Map<String,Income> incomeMap = user.getIncomeMap();
        List<Income> income = new ArrayList<Income>(incomeMap.values());
        return ResponseEntity.ok(income);
    }
}
