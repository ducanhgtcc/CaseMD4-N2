package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Img;
import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.service.ImgService;
import com.casemodul4_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ImgService imgService;
//Hiển thị tất cả sản phẩm
    @GetMapping
    public List<Product> showAllProduct() {
        return productService.findAll();
    }
//    Thêm sản phẩm
    @PostMapping
    public void create (@RequestBody Product product){
         productService.save(product);
    }
//    Hiển thị sản phẩm muốn sửa
    @GetMapping("/{id}")
    public Product showEdit(@PathVariable int id){
        return productService.findById(id).get();
    }
//    Sửa sản phẩm
    @PutMapping("/{id}")
    public void saveEdit(@RequestBody Product product){
        productService.save(product);

    }
//    Xóa sản phẩm
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        productService.delete(id);
    }

    @GetMapping("/find_images/{id}")
    public List<Img> findByIdProduct(@PathVariable int id){
        return
        imgService.findByIdProduct(id);
    }


}
