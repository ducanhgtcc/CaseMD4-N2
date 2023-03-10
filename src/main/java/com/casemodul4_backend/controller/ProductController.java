package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Img;
import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.service.ImgService;
import com.casemodul4_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/admin")
    public List<Product> showAllProduct() {
        return productService.findAll();
    }

    @GetMapping("/user")
    public List<Product> showByStatus() {
        return productService.showByStatus("co");
    }

    //    Thêm sản phẩm
    @PostMapping("/admin")
    public void create(@RequestBody Product product) {
        productService.save(product);
    }

    //    Hiển thị sản phẩm muốn sửa
    @GetMapping("/admin/{id}")
    public Product showEdit(@PathVariable int id) {
        return productService.findById(id);
    }
    @GetMapping("/user/{id}")
    public Product showEdit1(@PathVariable int id) {
        return productService.findById(id);
    }

    //    Sửa sản phẩm
    @PutMapping("/admin/{id}")
    public void saveEdit(@RequestBody Product product) {
        productService.save(product);

    }

    //    Xóa sản phẩm
    @PutMapping("/admin/setStatus/{id}")
    public Product setStatus(@PathVariable int id) {
        productService.save(productService.setStatus(id));
        return productService.setStatus(id);
    }


    @GetMapping("/admin/search/{text}")
    public List<Product> findByNameLike(@PathVariable String text) {
        return productService.findAllByNameLike(text);
    }

    @GetMapping("/admin/check/{name}")
    public ResponseEntity checkName(@PathVariable String name) {
        if (productService.checkDuplicateName(name) != null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/admin/showByCategoryId/{id}")
    public List<Product> showByCategoryId(@PathVariable int id) {
        return productService.showProductByCategory_Id(id);
    }

    @GetMapping("/find_images/{id}")
    public List<Img> findByIdProduct(@PathVariable int id){
        return imgService.findByIdProduct(id);
    }
//    @GetMapping("/showByStatus")
//    public List<Product> showByStatus() {
//        return productService.showByStatus("co");
//    }

}
