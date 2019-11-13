package com.gps.service.GPS.controllers;

import com.gps.service.GPS.models.User;
import com.gps.service.GPS.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class for handling request.
 *
 * @author solcanm
 * @version 1.0
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public String loginInfo(@RequestBody User userInfo) {
        return userInfo.toString();
    }
}
