package com.example.case4_duphong.repository;


import com.example.case4_duphong.model.ChildCategory;
import com.example.case4_duphong.model.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<ChildCategory,Long> {
    @Query
            (value = "select c.name, sum(t.money_amount) as 'total' from child_category c join transactions t on c.id = t.child_category_id and c.parent_category_id = 1 group by  c.id", nativeQuery = true)
    Iterable<ExpenseCategory> showExpenseCategories();
}
