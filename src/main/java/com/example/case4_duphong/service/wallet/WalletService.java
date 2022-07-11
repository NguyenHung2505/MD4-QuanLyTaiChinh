package com.example.case4_duphong.service.wallet;


import com.example.case4_duphong.model.Transaction;
import com.example.case4_duphong.model.Wallet;
import com.example.case4_duphong.service.GeneralService;

public interface WalletService extends GeneralService<Wallet> {
    Iterable<Wallet> findAllByNameContaining(String name);
}
