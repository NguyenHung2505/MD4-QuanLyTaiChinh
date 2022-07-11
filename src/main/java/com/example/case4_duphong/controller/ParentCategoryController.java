package com.example.case4_duphong.controller;

import com.example.case4_duphong.model.ParentCategory;
import com.example.case4_duphong.service.category.IParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/parent-categories")
public class ParentCategoryController {
    @Autowired
    IParentCategoryService parentCategoryService;

    @GetMapping
    public ResponseEntity<Iterable<ParentCategory>> showAllParentCategory(){
        return new ResponseEntity<>(parentCategoryService.findAll() , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ParentCategory>> findById(@PathVariable Long id){
        return new ResponseEntity(parentCategoryService.findById(id), HttpStatus.OK);
    }

}
