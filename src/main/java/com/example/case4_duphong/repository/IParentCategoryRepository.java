package com.example.case4_duphong.repository;

import com.example.case4_duphong.model.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParentCategoryRepository extends JpaRepository<ParentCategory,Long> {
}
