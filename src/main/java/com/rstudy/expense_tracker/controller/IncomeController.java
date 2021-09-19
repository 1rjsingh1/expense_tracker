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
import java.util.HashMap;
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

    @PostMapping
    public String addIncome (@PathVariable("id") String id,@RequestBody Income newIncome) {
        incomeRepository.save(newIncome);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User doesnt exist" + id));

        Map<String,Income> incomeMap = user.getIncomeMap();
        if(incomeMap == null) incomeMap=new HashMap<String, Income>();
        incomeMap.put(newIncome.getId(), newIncome);

        user.setIncomeMap(incomeMap);
        userRepository.save(user);
        return "Income added successfully";
    }

    @PutMapping("/{iid}")
    public ResponseEntity<Income> updateIncome(@PathVariable("id") String id,@PathVariable("iid") String iid,@RequestBody Income income)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "User Doesn't exist: "+id
                ));

        Map<String, Income> incomeMap = user.getIncomeMap();
        Income updatedIncome = incomeMap.get(iid);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(income, updatedIncome);

        updatedIncome.setId(iid);

        incomeMap.put(iid, updatedIncome);
        user.setIncomeMap(incomeMap);

        incomeRepository.save(updatedIncome);
        userRepository.save(user);

        return ResponseEntity.ok(updatedIncome);
    }

    @DeleteMapping("/{iid}")
    public ResponseEntity<String> deleteIncome(@PathVariable("id") String id, @PathVariable("iid") String iid)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Employee Doesn't exist: "+id
                ));

        Map<String, Income> incomeMap = user.getIncomeMap();
        Income deletedIncome = incomeMap.get(iid);

        incomeMap.remove(iid);
        user.setIncomeMap(incomeMap);

        incomeRepository.delete(deletedIncome);
        userRepository.save(user);
        return ResponseEntity.ok("Income Deleted");
    }
}
