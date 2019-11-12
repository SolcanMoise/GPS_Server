package com.gps.service.GPS.controllers;

import com.gps.service.GPS.models.Login;
import com.gps.service.GPS.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for handling login operation.
 *
 * @author solcanm
 * @version 1.0
 * @since 2019-11-12
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login", consumes = "application/json")
    public String loginInfo(@RequestBody Login loginInfo) {
        return loginInfo.toString();
    }

    @GetMapping(value = "/login")
    public List<Login> getAll() {
        return loginService.getAll();
    }
}
