package com.gps.service.GPS.repository;

import com.gps.service.GPS.models.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author solcanm
 * @version 1.0
 * @since 2019-11-12
 */
@Repository
public interface LoginRepository extends CrudRepository<Login, String> {
}
