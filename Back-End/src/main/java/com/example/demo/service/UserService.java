package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String add(UserDTO dto);

    List<UserDTO> getAll();

    String update(UserDTO dt);

    String delete(int cusId);

    Optional<User> searchUser(UserDTO dto);
}
