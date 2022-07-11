package com.example.case4_duphong.service;


import com.example.case4_duphong.model.user.Role;

public interface RoleService {
    Iterable<Role> findAll();


    void save(Role role);

    Role findByName(String name);
}