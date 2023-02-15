package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    ProductService productService;

    //Hiển thị tất cả sản phẩm
    @GetMapping
    public List<Product> showAllProduct() {
        return productService.findAll();
    }

    //    Thêm sản phẩm
    @PostMapping
    public void create(@RequestBody Product product) {
        productService.save(product);
    }

    //    Hiển thị sản phẩm muốn sửa
    @GetMapping("/{id}")
    public Product showEdit(@PathVariable int id) {
        return productService.findById(id);
    }

    //    Sửa sản phẩm
    @PutMapping("/{id}")
    public void saveEdit(@RequestBody Product product) {
        productService.save(product);

    }

    //    Xóa sản phẩm
    @PutMapping("/setStatus/{id}")
    public Product setStatus(@PathVariable int id) {
        productService.save(productService.setStatus(id));
        return productService.setStatus(id);
    }

    @GetMapping("/search/{text}")
    public List<Product> findByNameLike(@PathVariable String text) {
        return productService.findAllByNameLike(text);
    }

    @GetMapping("/check/{name}")
    public ResponseEntity checkName(@PathVariable String name) {
        if (productService.checkDuplicateName(name) != null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/showByCategory/{name}")
    public List<Product> showByNameCategory(@PathVariable String name) {
        return productService.showProductByCategoryName(name);
    }

}
