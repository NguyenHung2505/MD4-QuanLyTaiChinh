package com.example.case4_duphong.controller;


import com.example.case4_duphong.model.ChildCategory;
import com.example.case4_duphong.service.category.IChildCategoryService;
import com.example.case4_duphong.service.category.IParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/child-categories")
public class ChildCategoryController {
    @Autowired
    IChildCategoryService childCategoryService;

    @Autowired
    IParentCategoryService parentCategoryService;

    @GetMapping
    public ResponseEntity<Iterable<ChildCategory>> showAllChildCategory(){
        return new ResponseEntity<>(childCategoryService.findAll() , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ChildCategory>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(childCategoryService.findById(id), HttpStatus.OK);
    }

//    @GetMapping("/category-by-user")
//    public ResponseEntity showUserCategory() {
//        return new ResponseEntity(childCategoryService.showExpenseCategories(), HttpStatus.OK);
//    }

    @PostMapping()
    public ResponseEntity<Optional<ChildCategory>> save(@RequestBody ChildCategory childCategory) {
        return new ResponseEntity(childCategoryService.save(childCategory), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<ChildCategory>> update(@PathVariable Long id, @RequestBody ChildCategory childCategory) {
        Optional<ChildCategory> categoryOptional = childCategoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        childCategory.setId(categoryOptional.get().getId());
        return new ResponseEntity(childCategoryService.save(childCategory), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChildCategory> delete(@PathVariable Long id) {
        Optional<ChildCategory> productOptional = childCategoryService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        childCategoryService.remove(id);
        return new ResponseEntity<>(productOptional.get(), HttpStatus.NO_CONTENT);
    }


//    @GetMapping("/getChildCategory/{id}")
//    public ResponseEntity<Iterable<ChildCategory>> getChildCategoryByParentCategory(@PathVariable("id") Long id) {
//        Optional<ParentCategory> parentCategory1 = parentCategoryService.findById(id);
//        if (!parentCategory1.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        Iterable<ChildCategory> childCategories = childCategoryService.findAllByParentCategory(parentCategory1.get());
//        return new ResponseEntity<>(childCategories, HttpStatus.OK);
//
//    }

}
