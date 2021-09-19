package com.rstudy.expense_tracker.controller;

import com.rstudy.expense_tracker.exception.ResourceNotFoundException;
import com.rstudy.expense_tracker.model.Category;
import com.rstudy.expense_tracker.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> getAll()
    {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<String> addCategory(@RequestBody Category category)
    {
        categoryRepository.save(category);
        return ResponseEntity.ok("Category Added");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id,@RequestBody Category category)

    {
        Category category1=categoryRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(
                        "Category Doesn't Exist:"+id
                ));

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.map(category,category1);
        category1.setId(id);
        categoryRepository.save(category1);
        return ResponseEntity.ok(category1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delCategory(@PathVariable("id") String id)
    {
        Category category1=categoryRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(
                        "Category Doesn't Exist:"+id
                ));
        categoryRepository.delete(category1);
        return ResponseEntity.ok("Category Deleted");
    }


}
