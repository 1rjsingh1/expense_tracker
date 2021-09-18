package com.rstudy.expense_tracker.controller;

import com.rstudy.expense_tracker.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/income")
public class IncomeController {
    @Autowired
    IncomeRepository incomeRepository;
}
