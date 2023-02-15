package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Account;
import com.casemodul4_backend.model.dto.AccountToken;
import com.casemodul4_backend.service.AccountService;
import com.casemodul4_backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AccountService accountService;

    //Thực hiện gửi username, password lên và trả về token
    @PostMapping
    public AccountToken login(@RequestBody Account account) {


        //Tạo ra một đối tượng xác thực (cần truyền username, password vào), khi chạy 2 dòng này thì nó sẽ tự động chạy hàm loadUserByUsername trong AccountService
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        //Truyền đối tượng đang xác thực
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Sau khi xác thực thành công thì tạo ra token với tham số là đối tượng authentication đã xác thực thành công
        String token = jwtService.createToken(authentication);


        //Trả về một đối tượng account1 của class Account bằng hàm tìm kiếm theo username
        Account account1 = accountService.findAccountByUsername(account.getUsername());

        //Tạo một đối tượng của class AccountToken chứa token vừa tạo ra cùng thông tin theo cùng token để hiển thị
        AccountToken accountToken = new AccountToken(account1.getId(),account1.getUsername(), account1.getAvatar(), account1.getAddress(), account1.getPhone(),token, account1.getRoles());
        return accountToken;

    }
}
