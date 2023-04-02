package com.varfolomeev.movierating.controller;

import com.varfolomeev.movierating.entity.User;
import com.varfolomeev.movierating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/greetings")
    public String getUserGreeting(){
        return "greetings!";
    }

    @PostMapping("/add")
    public ResponseEntity<User>addUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
