package com.casemodul4_backend.service;

import java.util.Optional;

public interface InterfaceGeneral<T> {

    Iterable<T> findAll();

    Optional<T> findById(int id);

    void save(T t);

    void delete(int id);

}
