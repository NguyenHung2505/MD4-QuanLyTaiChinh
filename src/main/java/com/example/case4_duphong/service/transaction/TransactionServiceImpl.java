package com.example.case4_duphong.service.transaction;

import com.example.case4_duphong.model.ChildCategory;
import com.example.case4_duphong.model.Transaction;
import com.example.case4_duphong.repository.IChildCategoryRepository;
import com.example.case4_duphong.repository.TransactionRepository;
import com.example.case4_duphong.repository.WalletRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    IChildCategoryRepository childCategoryRepository;

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction save(Transaction transaction) {
        var result = transactionRepository.save(transaction);

        if (result == null) return null; // lưu thất bại
        var childCategoryId = result.getChildCategory().getId();
        var newchilCategory = childCategoryRepository.findById(childCategoryId).get();
        var chilCategoryName = newchilCategory.getName();

        var viId = result.getWallet().getId();
        var vi = walletRepository.findById(viId).get();
        var soTienTruocDo = vi.getMoneyAmount();
        var soTienTrongGiaoDich = result.getMoneyAmount();

        if (chilCategoryName.equals("khoan thu")) {
            var soTienSauKhiThemVao = soTienTruocDo + soTienTrongGiaoDich;
            vi.setMoneyAmount((soTienSauKhiThemVao));
        } else {
            var soTienSauKhiChiRa = soTienTruocDo - soTienTrongGiaoDich;
            vi.setMoneyAmount((soTienSauKhiChiRa));
        }
        walletRepository.save(vi);
        return result;
    }


    @Override
    public void remove(Long id) {
        transactionRepository.deleteById(id);
    }


    @Override
    public Iterable<Transaction> findAllByByDate(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc) {
        List<Transaction> data = new ArrayList<Transaction>();

        // lấy hết transaction hiện có
        var transactions = findAll();

        // kiểm điều kiện. để lấy transaction thõa mãn
        for(Transaction item : transactions){
               var createAt = item.getCreatAt();
               var soSanhVoiNgayBatDau = createAt.compareTo(ngayBatDau);
               var soSanhVoiNgayKetThuc = createAt.compareTo(ngayKetThuc);
               if(soSanhVoiNgayBatDau <= 0 && soSanhVoiNgayKetThuc >=0 ){
                    data.add(item);
               }
        }
        return data;
    }






}
