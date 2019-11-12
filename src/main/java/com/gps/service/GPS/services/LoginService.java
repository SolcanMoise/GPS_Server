package com.gps.service.GPS.services;

import com.gps.service.GPS.models.Login;
import com.gps.service.GPS.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Service that handle login operation
 *
 * @author solcanm
 * @version 1.0
 * @since 2019-11-12
 */
@Component
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public List<Login> getAll() {
        return (List<Login>) loginRepository.findAll();
    }

}
