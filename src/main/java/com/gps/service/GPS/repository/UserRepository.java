package com.gps.service.GPS.repository;

import com.gps.service.GPS.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author solcanm
 * @version 1.0
 * @since 2019-11-12
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String username);
}
