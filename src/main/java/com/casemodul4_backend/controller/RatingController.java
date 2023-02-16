package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Img;
import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.model.Rating;
import com.casemodul4_backend.service.ImgService;
import com.casemodul4_backend.service.ProductService;
import com.casemodul4_backend.service.RatingSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingSevice ratingSevice;

    @Autowired
    ImgService imgService;
//Hiển thị tất cả sản phẩm

//    @GetMapping
//    public List<Rating> showAllProduct() {
//        return ratingSevice.showByStatus("co");
//    }

    //    Thêm sản phẩm
    @PostMapping
    public void create(@RequestBody Rating rating) {
        ratingSevice.save(rating);
    }

    //    Hiển thị sản phẩm muốn sửa
    @GetMapping("/{id}")
    public Rating showEdit(@PathVariable int id) {
        return (Rating) ratingSevice.findById(id);
    }

    //    Sửa sản phẩm
    @PutMapping("/{id}")
    public void saveEdit(@RequestBody Rating rating) {
        ratingSevice.save(rating);

    }

    //    Xóa sản phẩm
//    @PutMapping("/setStatus/{id}")
//    public Rating setStatus(@PathVariable int id) {
//        ratingSevice.save(ratingSevice.s(id));
//        return productService.setStatus(id);
//    }


//    @GetMapping("/search/{text}")
//    public List<Product> findByNameLike(@PathVariable String text) {
//        return productService.findAllByNameLike(text);
//    }

//    @GetMapping("/check/{name}")
//    public ResponseEntity checkName(@PathVariable String name) {
//        if (productService.checkDuplicateName(name) != null) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity(HttpStatus.OK);
//    }

//    @GetMapping("/showByCategory/{name}")
//    public List<Product> showByNameCategory(@PathVariable String name) {
//        return productService.showProductByCategoryName(name);
//    }

    @GetMapping("/findByIdProduct/{id}")
    public List<Rating> findByIdProduct(@PathVariable int id){
        return
                ratingSevice.findByIdProduct(id);
    }
    @GetMapping("/getAvgPoint/{id}")
    public float getAvgPoint(@PathVariable int id){
        return ratingSevice.getAvgPoints(id);
    }
}
