package com.gps.service.GPS.controllers;

import com.gps.service.GPS.exceptions.BusinessException;
import com.gps.service.GPS.models.User;
import com.gps.service.GPS.models.dto.UserLoginDTO;
import com.gps.service.GPS.models.dto.UserRegisterDTO;
import com.gps.service.GPS.models.security.CustomUserDetails;
import com.gps.service.GPS.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping(path = "/me")
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser());
    }

    @PostMapping(path = "/login")
    public ResponseEntity<User> loginUser(@RequestBody final UserLoginDTO userLoginDTO) throws BusinessException {
        return ResponseEntity.ok(userService.login(userLoginDTO));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<User> registerUser(@RequestBody final UserRegisterDTO userRegisterDTO) throws BusinessException {
        return ResponseEntity.ok(userService.register(userRegisterDTO));
    }
}
