package com.example.case4_duphong.repository;


import com.example.case4_duphong.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
