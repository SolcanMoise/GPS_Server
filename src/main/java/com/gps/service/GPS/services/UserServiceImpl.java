package com.gps.service.GPS.services;

import com.gps.service.GPS.models.User;
import com.gps.service.GPS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author solcanm
 * @version 1.0
 * @since 2019-11-13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
}
