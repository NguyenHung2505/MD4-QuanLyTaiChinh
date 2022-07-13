package com.example.case4_duphong.service.category;

import com.example.case4_duphong.model.ChildCategory;
import com.example.case4_duphong.model.ExpenseCategory;
import com.example.case4_duphong.model.ParentCategory;
import com.example.case4_duphong.repository.ICategoryRepository;
import com.example.case4_duphong.repository.IChildCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ChildCategoryServiceImpl implements IChildCategoryService {

    @Autowired

     ICategoryRepository categoryRepository ;


    @Autowired
    IChildCategoryRepository childCategoryRepository;

    @Override
    public Iterable<ChildCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<ChildCategory> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public ChildCategory save(ChildCategory childCategory) {
        return categoryRepository.save(childCategory);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }


    @Override
   public Iterable<ExpenseCategory> showExpenseCategories(){
        return categoryRepository.showExpenseCategories();
    }

    @Override
    public Iterable<ChildCategory> findAllByParentCategory(ParentCategory parentCategory) {
        return childCategoryRepository.findAllByParentCategory(parentCategory);
    }

}
