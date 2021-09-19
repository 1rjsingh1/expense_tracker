package com.rstudy.expense_tracker.controller;
import com.rstudy.expense_tracker.exception.ResourceNotFoundException;
import com.rstudy.expense_tracker.model.Income;
import com.rstudy.expense_tracker.model.User;
import com.rstudy.expense_tracker.repository.IncomeRepository;
import com.rstudy.expense_tracker.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/users/{id}/income")
public class IncomeController {
    public IncomeController(){}

    @Autowired
    UserRepository userRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @GetMapping
    public ResponseEntity<List<Income>> getAll (@PathVariable("id") String id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User doesnt exist" + id));
        Map<String,Income> incomeMap = user.getIncomeMap();
        List<Income> incomeList = new ArrayList<Income>(incomeMap.values());
        return ResponseEntity.ok(incomeList);
    }
    @GetMapping("/{iid}")
    public ResponseEntity<Income> getIncomeById(@PathVariable("id") String id,@PathVariable("iid") String iid) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User doesnt exist" + id));
        Map<String,Income> incomeMap = user.getIncomeMap();
        Income income = incomeMap.get(iid);
        return ResponseEntity.ok(income);
    }

    @PostMapping()
    public String addIncome (@PathVariable("id") String id,@RequestBody Income income) {
        Income newIncome = new Income();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(newIncome, income);
        incomeRepository.save(newIncome);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User doesnt exist" + id));

        Map<String,Income> incomeMap = user.getIncomeMap();
        incomeMap.put(newIncome.getId(), newIncome);

        user.setIncomeMap(incomeMap);
        return "Income added successfully";
    }
}
