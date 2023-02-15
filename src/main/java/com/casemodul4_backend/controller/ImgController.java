package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Img;
import com.casemodul4_backend.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImgController {
    @Autowired
    ImgService imgService;

    //Hiển thị tất cả ảnh
    @GetMapping
    public List<Img> showAllImage() {
        return imgService.findAll();
    }

    //    Thêm ảnh
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
