package com.example.case4_duphong.service;

import java.util.Optional;

public interface GeneralService<A>{
    Iterable<A> findAll();

    Optional<A> findById(Long id);

    A save(A a);

    void remove(Long id);
}
