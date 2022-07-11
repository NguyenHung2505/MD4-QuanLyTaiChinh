package com.example.case4_duphong.repository;


import com.example.case4_duphong.model.Wallet;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WalletRepository extends PagingAndSortingRepository<Wallet,Long> {

    Iterable<Wallet> findAllByNameContaining(String name);

}