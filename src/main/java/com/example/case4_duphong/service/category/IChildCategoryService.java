package com.example.case4_duphong.service.category;

import com.example.case4_duphong.model.ChildCategory;
import com.example.case4_duphong.model.ExpenseCategory;
import com.example.case4_duphong.model.ParentCategory;
import com.example.case4_duphong.service.GeneralService;

public interface IChildCategoryService extends GeneralService<ChildCategory> {
    Iterable<ExpenseCategory> showExpenseCategories();
    Iterable<ChildCategory> findAllByParentCategory(ParentCategory parentCategory);

}
