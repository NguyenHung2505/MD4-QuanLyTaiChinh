package com.example.case4_duphong.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Wallet wallet;

    @ManyToOne
    private ChildCategory childCategory;

    @Column(nullable = false)
    private double moneyAmount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creatAt;

    private String note;

    public Transaction() {
    }

    public Transaction(Long id, Wallet wallet, ChildCategory childCategory, double moneyAmount, LocalDateTime creatAt, String note) {
        this.id = id;
        this.wallet = wallet;
        this.childCategory = childCategory;
        this.moneyAmount = moneyAmount;
        this.creatAt = creatAt;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public ChildCategory getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(ChildCategory childCategory) {
        this.childCategory = childCategory;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public LocalDateTime getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDateTime creatAt) {
        this.creatAt = creatAt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
