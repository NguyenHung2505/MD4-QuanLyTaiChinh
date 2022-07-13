package com.example.case4_duphong.repository;

import com.example.case4_duphong.model.MoneyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMoneyTypeRepository extends JpaRepository<MoneyType, Long> {
}
