package com.gps.service.GPS.services;

import com.gps.service.GPS.exceptions.BusinessException;
import com.gps.service.GPS.models.User;
import com.gps.service.GPS.models.dto.UserLoginDTO;
import com.gps.service.GPS.models.dto.UserRegisterDTO;

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

    /**
     * Login into application.
     *
     * @param userLoginDTO - user information.
     * @return the created {@link User}.
     * @throws BusinessException
     */
    User login(final UserLoginDTO userLoginDTO) throws BusinessException;

    /**
     * Register into application.
     *
     * @param userRegisterDTO - user information.
     * @return the created {@link User}.
     * @throws BusinessException
     */
    User register(final UserRegisterDTO userRegisterDTO) throws BusinessException;
}
