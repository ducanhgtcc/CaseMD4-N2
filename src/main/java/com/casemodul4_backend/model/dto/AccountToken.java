package com.casemodul4_backend.model.dto;

import com.casemodul4_backend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
//Class này chứa token và thông tin đi cùng token để hiển thị bên frontEnd (hứng dữ liệu và truyền dữ liệu đi)

public class AccountToken {
    private String username;
    private String avatar;
    private String address;
    private String phone;
    private String token;

    private List<Role> roles;
}
