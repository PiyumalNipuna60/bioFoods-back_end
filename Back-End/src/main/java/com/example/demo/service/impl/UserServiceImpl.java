package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;



    @Override
    public String add(UserDTO dto) {
        User customer = new User(
                dto.getUserName(),
                dto.getPassword()
        );

        User save = userRepo.save(customer);
        return save.getUserName();
    }


    @Override
    public List<UserDTO> getAll() {
        List<User> all = userRepo.findAll();
        List<UserDTO> allUser=new ArrayList<>();

        for (User dto:all) {
            UserDTO userDTO = new UserDTO(
                    dto.getUserName(),
                    dto.getPassword()
            );
            allUser.add(userDTO);
        }

        return allUser;
    }


    @Override
    public String update(UserDTO dt) {
        return null;
    }


    @Override
    public String delete(int cusId) {
        return null;
    }

    @Override
    public Optional<User> searchUser(UserDTO dto) {
        Optional<User> user = userRepo.findById(dto.getUserName());
        return user;

    }


}
