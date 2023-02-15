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


    public Optional<Category> findById(int id) {
        return categoryRepo.findById(id);
    }


    public void save(Category category) {
        categoryRepo.save(category);

    }


    public void delete(int id) {
        categoryRepo.deleteById(id);
    }

    public Category checkDuplicateName(String name) {
      return categoryRepo.checkDuplicateName(name);
    }

    public List<Category> findByNameLike(String name) {
        return categoryRepo.findByNameLike(name);
    }
}
