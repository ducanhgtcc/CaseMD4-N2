package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Img;
import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.service.ImgService;
import com.casemodul4_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImgController {
    @Autowired
    ImgService imgService;
    @Autowired
    ProductService productService;

    //Hiển thị tất cả ảnh
    @GetMapping("/admin")
    public List<Img> showAllImage() {
        return imgService.findAll();
    }

    //    Thêm ảnh
    @PostMapping("/admin/upImg")
    public String upImg(@RequestParam MultipartFile fileImg) {
        String nameImg = fileImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileImg.getBytes(), new File("D:\\CodeGym\\Modul4\\caseModule4N2\\CaseMD4-N2-FE\\images\\" + nameImg));
            return "/CaseMD4-N2-FE/images/" + nameImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/admin")
    public void create(@RequestBody Img img) {
        imgService.save(img);
    }

    //    Hiển thị ảnh muốn sửa
    @GetMapping("/admin/{id}")
    public Img showEdit(@PathVariable int id) {
        return imgService.findById(id).get();
    }

    //    Sửa ảnh
    @PutMapping("/admin/{id}")
    public void saveEdit(@RequestBody Img img) {
        imgService.save(img);

    }

    //    Xóa ảnh
    @DeleteMapping("/admin/{id}")
    public void deleteById(@PathVariable int id) {
        imgService.delete(id);
    }


    @GetMapping("/admin/search/{id}")
    public List<Img> findImgByProduct_Name(@PathVariable int id) {
        return imgService.findImgByProduct_Name(id);

//Hiển thị ảnh theo ID product


    }
}
