package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id

    String userName;
    String password;
}
