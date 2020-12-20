package com.dp.demo.controller;

import com.dp.demo.dto.UserDTO;
import com.dp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/login")
    public UserDTO login(@RequestBody UserDTO user)
    {
        return userService.loginUser(user.getUserName(),user.getUserPass());
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody UserDTO user)
    {
        userService.createUser(user.getUserName(), user.getUserPass());
    }




}
