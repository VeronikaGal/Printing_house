package com.galeeva.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEntity {

    Long id;
    String name;
    String phone_number;
    String address;
    Integer role;
    String email;
    String password;
}

