package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Img;
import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/images")
public class ImgController {
    @Autowired
    ImgService imgService;

    //Hiển thị tất cả ảnh
    @GetMapping
    public List<Img> showAllImage() {
        return imgService.findAll();
    }

    //    Thêm ảnh
    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile fileImg) {
        String nameImg = fileImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileImg.getBytes(), new File("D:\\CodeGym\\Modul4\\caseModule4nhom2\\FE\\Ban_Noi_That_FE\\Ban_Noi_That_FE\\images\\" + nameImg));
            return "/Ban_Noi_That_FE/images/"+nameImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public void create(@RequestBody Img img) {
        imgService.save(img);
    }

    //    Hiển thị ảnh muốn sửa
    @GetMapping("/{id}")
    public Img showEdit(@PathVariable int id) {
        return imgService.findById(id).get();
    }

    //    Sửa ảnh
    @PutMapping("/{id}")
    public void saveEdit(@RequestBody Img img) {
        imgService.save(img);

    }

    //    Xóa ảnh
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        imgService.delete(id);
    }


}
