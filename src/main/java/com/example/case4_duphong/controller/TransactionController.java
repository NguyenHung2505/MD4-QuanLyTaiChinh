package com.example.case4_duphong.controller;


import com.example.case4_duphong.model.Transaction;
import com.example.case4_duphong.service.transaction.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionServiceImpl transactionService;

    @GetMapping
    public ResponseEntity<Transaction> findAllTransaction() {
        return new ResponseEntity(transactionService.findAll(), HttpStatus.OK);
    }

    @PostMapping
//    @valid de duyet qua validate
    public ResponseEntity<Transaction> add(@RequestBody Transaction transaction) {
        transaction.setCreatAt(LocalDateTime.now());
        transactionService.save(transaction);
        return new ResponseEntity(transactionService, HttpStatus.OK);
    }


    @GetMapping ("/{id}")
    public ResponseEntity<Transaction> findById( @PathVariable Long id) {
        return new ResponseEntity(transactionService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")           //Chỉnh sửa theo id
    public ResponseEntity updateTransaction(@RequestBody Transaction transaction, @PathVariable Long id) {
        Optional<Transaction> transactionOptional = transactionService.findById(id);
        if (!transactionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        transaction.setId(transactionOptional.get().getId());
        transactionService.save(transaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")     // xoa
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable Long id) {
        Optional<Transaction> transactionOptional = transactionService.findById(id);
        if (!transactionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        transactionService.remove(id);
        return new ResponseEntity<>(transactionOptional.get(), HttpStatus.NO_CONTENT);
    }





//    @GetMapping("/search-name")
//    public ResponseEntity<Iterable<Transaction>> findAllByNameContaining(String name) {
//        return new ResponseEntity<>(transactionService.findAllByNameContaining(name), HttpStatus.OK);
//    }


}