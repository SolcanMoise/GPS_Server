package com.gps.service.GPS.services;

import com.gps.service.GPS.models.User;

import java.util.List;

/**
 * @author solcanm
 * @version 1.0
 * @since 2019-11-13
 */
public interface UserService {

    /**
     * Get all existing users from database
     *
     * @return list of {@link User}
     */
    List<User> getUsers();
}
