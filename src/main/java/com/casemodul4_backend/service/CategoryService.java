package com.casemodul4_backend.service;

import com.casemodul4_backend.model.Category;
import com.casemodul4_backend.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;


    public List<Category> findAll() {
        return (List<Category>) categoryRepo.findAll();
    }


    public Optional findById(int id) {
        return Optional.empty();
    }


    public void save(Object o) {

    }


    public void delete(int id) {

    }
}
