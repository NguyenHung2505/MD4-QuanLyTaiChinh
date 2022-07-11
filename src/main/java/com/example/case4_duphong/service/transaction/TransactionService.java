package com.example.case4_duphong.service.transaction;

import com.example.case4_duphong.model.Transaction;
import com.example.case4_duphong.service.GeneralService;

import java.time.LocalDateTime;

public interface TransactionService extends GeneralService<Transaction> {
    public Iterable<Transaction> findAllByByDate(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc);
}
