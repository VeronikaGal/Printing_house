package com.galeeva.project.service;

import com.galeeva.project.dao.UserDao;

import com.galeeva.project.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final UserDao userDao = UserDao.getInstance();

    private UserService() {
    }

    public List<UserDto> findAll() {
        return userDao.findAll().stream()
                .map(user -> UserDto.builder()
                        .id(user.getId())
                        .description(
                                """
                                        %s - %s - %s - %s
                                        """.formatted(user.getName(), user.getPhone_number(),
                                        user.getAddress(), user.getEmail()))
                        .build()
                )
                .collect(Collectors.toList());
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
