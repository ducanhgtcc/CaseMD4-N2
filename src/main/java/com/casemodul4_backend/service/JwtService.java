package com.casemodul4_backend.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    // key để mã hóa token.
    private static final String SECRET_KEY = "1111111111111";
    // thời gian để token sống.
    private static final long EXPIRE_TIME = 86400000000L;

    // hàm tạo ra token
    public String createToken(Authentication authentication) {
        // lấy đối tượng đang đăng nhập (lấy ra user có sẵn của Security)
        User user = (User) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((user.getUsername()))    //Dữ liệu truyền vào trong token (username)
                .setIssuedAt(new Date())             //Ngày tạo
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME * 1000))  //Tuổi thọ của token
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)           //Kiểu mã hóa
                .compact();
    }

    // lấy username từ token (giải mã token lấy username)
    public String getUserNameFromJwtToken(String token) {
        String userName = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return userName;
    }
}
