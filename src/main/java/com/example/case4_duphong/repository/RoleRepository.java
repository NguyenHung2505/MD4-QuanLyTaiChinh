package com.example.case4_duphong.repository;



import com.example.case4_duphong.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}