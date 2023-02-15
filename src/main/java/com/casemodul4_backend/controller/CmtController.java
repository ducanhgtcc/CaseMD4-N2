package com.casemodul4_backend.controller;

import com.casemodul4_backend.dto.CommentDto;
import com.casemodul4_backend.model.Comment;
import com.casemodul4_backend.repository.CmtRepo;
import com.casemodul4_backend.service.CmtService;
import com.casemodul4_backend.service.ImgService;
import com.casemodul4_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Cmt")
public class CmtController {
    @Autowired
    CmtService cmtService;
    @Autowired
    ProductService productService;
    @Autowired
    ImgService imgService;
    @Autowired
    private CmtRepo cmtRepo;

    //Hiển thị tất cả cmt
    @GetMapping
    public List<Comment> showAllProduct() {
        return cmtService.findAll();
    }

    //    Thêm cmt
    @PostMapping
    public void create(@RequestBody Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setAccountId(comment.getId());
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        cmtService.save(comment);
    }

    //    Hiển thị cmt
    @GetMapping("/{id}")
    public CommentDto showEdit(@PathVariable int id, Comment comment) {
        cmtService.findById(id).get();
        CommentDto commentDto = new CommentDto();
        commentDto.setAccountId(comment.getId());
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        return commentDto;
    }

    //    Sửa sản phẩm
    @PutMapping("/{id}")
    public void saveEdit(@RequestBody CommentDto commentDto) {

        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setAccount(cmtService.getAccountById(commentDto.getAccountId()));
        comment.setContent(commentDto.getContent());
        cmtService.save(comment);
    }

    //    Xóa sản phẩm
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        cmtService.delete(id);
    }

    @GetMapping("/find_cmt/{id}")
    public List<Comment> findByIdProduct(@PathVariable Integer id) {
        return cmtService.findByIdProduct(id);
    }

}
