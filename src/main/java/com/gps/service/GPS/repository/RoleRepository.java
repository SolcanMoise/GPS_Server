package com.gps.service.GPS.repository;

import com.gps.service.GPS.models.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @author solcanm
 * @version 1.0
 * @since 2020-01-06
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
