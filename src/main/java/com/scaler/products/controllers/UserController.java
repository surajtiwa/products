package com.scaler.products.controllers;


import com.scaler.products.dtos.CreateUserDto;
import com.scaler.products.models.User;
import com.scaler.products.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/users")
public class UserController {
    UserController(UserService userService) {
        this.userService = userService;
    }

    UserService userService;

    @PostMapping("")
    public User createUser(@RequestBody CreateUserDto userDto) {
            return  userService.createUser(userDto);
    }
}
