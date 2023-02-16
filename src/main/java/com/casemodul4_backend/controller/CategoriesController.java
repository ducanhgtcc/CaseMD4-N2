package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Category;
import com.casemodul4_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    CategoryService catagoryService;
    @GetMapping("/admin")
    public List<Category> showAllCategory() {
        return catagoryService.findAll();
    }

    @PostMapping("/admin")
    public void createCategory(@RequestBody Category category) {
         catagoryService.save(category);
    }

    @GetMapping("/admin/{id}")
    public void showEdit(@PathVariable int id) {
        catagoryService.findById(id);
    }

    @PutMapping("/admin/{id}")
    public void editCategory(@RequestBody Category category) {
        catagoryService.save(category);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteCategory(@PathVariable int id) {
        catagoryService.delete(id);
    }

    @GetMapping("/admin/checkname/{name}")
    public ResponseEntity checkName(@PathVariable String name) {
        if (catagoryService.checkDuplicateName(name) != null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

@GetMapping("/admin/search/{name}")
    public List<Category> findByNameLike(@PathVariable String name) {
        return catagoryService.findByNameLike(name);
}
}
