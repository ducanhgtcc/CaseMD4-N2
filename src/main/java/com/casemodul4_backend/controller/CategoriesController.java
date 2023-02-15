package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Category;
import com.casemodul4_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/categories")
public class CategoriesController {
    @Autowired
    CategoryService catagoryService;
    @GetMapping

    public List<Category> showAllCategory() {
        return catagoryService.findAll();
    }
}
