package com.gps.service.GPS.models.security;

import javax.persistence.*;

/**
 * @author solcanm
 * @version 1.0
 * @since 2019-11-13
 */
@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ROLE")
    private String role;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
