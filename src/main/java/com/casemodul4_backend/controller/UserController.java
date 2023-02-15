package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Account;
import com.casemodul4_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    //Hiển thị tất cả user
    @GetMapping
    public List<Account> showAllUser() {
        return userService.findAll();
    }

    //    Thêm user
    @PostMapping
    public void create(@RequestBody Account account) {
        userService.save(account);
    }

    //    Hiển thị user muốn sửa
    @GetMapping("/{id}")
    public Account showEdit(@PathVariable int id) {
        return userService.findById(id).get();
    }

    //    Sửa user
    @PutMapping("/{id}")
    public void saveEdit(@RequestBody Account account) {
        userService.save(account);

    }

    //    Xóa user
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.delete(id);
    }

}
