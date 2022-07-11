package com.example.case4_duphong.controller;

import com.example.case4_duphong.model.Wallet;
import com.example.case4_duphong.service.wallet.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/wallets")
public class WalletController {
    @Autowired
    WalletServiceImpl walletServiceImpl;

    // hiển thị cả danh sách
    @GetMapping
    public ResponseEntity<Iterable<Wallet>> findAllHouse() {
        List<Wallet> wallets = (List<Wallet>) walletServiceImpl.findAll();
        if (wallets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }
    //   hiển thị theo id
    @GetMapping("/{id}")
    public ResponseEntity<Wallet> findWalletById(@PathVariable Long id) {
        Optional<Wallet> walletOptional = walletServiceImpl.findById(id);
        if (!walletOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(walletOptional.get(), HttpStatus.OK);
    }
    // tạo mới
    @PostMapping
    public ResponseEntity<Wallet> saveWallet(@RequestBody Wallet wallet) {
        walletServiceImpl.save(wallet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // chỉnh sửa

    @PutMapping("/{id}")
    public ResponseEntity<Wallet> update(@RequestBody Wallet wallet, @PathVariable Long id) {
        Optional<Wallet> walletOptional = walletServiceImpl.findById(id);
        if (!walletOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        wallet.setId(walletOptional.get().getId());

        walletServiceImpl.save(wallet);
        return new ResponseEntity<>(wallet,HttpStatus.OK);
    }

    // Xóa

    @DeleteMapping("/{id}")
    public ResponseEntity<Wallet> deleteWallet(@PathVariable Long id) {
        Optional<Wallet> walletOptional = walletServiceImpl.findById(id);
        if (!walletOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        walletServiceImpl.remove(id);
        return new ResponseEntity<>(walletOptional.get(), HttpStatus.NO_CONTENT);
    }


    @GetMapping("/findByName/{name}")
    public ResponseEntity<Iterable<Wallet>> findByWalletName(@PathVariable String name){
        return new ResponseEntity<>(walletServiceImpl.findAllByNameContaining(name), HttpStatus.OK);
    }

}
