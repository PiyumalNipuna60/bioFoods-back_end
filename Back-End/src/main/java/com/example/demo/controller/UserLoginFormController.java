package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserLoginFormController {


    @Autowired
    private UserService userService;


    @PostMapping(path = "/save")
    private String saveUser(@RequestBody UserDTO dto) {
        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
        String encodePwd = crypt.encode(dto.getPassword());
        dto.setPassword(encodePwd);
        String add = userService.add(dto);
        return add;
    }

    @PostMapping(path = "/search")
    private String searchUser(@RequestBody UserDTO dto) {
        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
        Optional<User> user = userService.searchUser(dto);
        String isTrue="false";
        if (user.isPresent()){
            User dbUser = user.get();
            if (crypt.matches(dto.getPassword(),dbUser.getPassword())){
                isTrue="true";
            }
        }
        return isTrue;
    }
}
