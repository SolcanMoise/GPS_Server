package com.gps.service.GPS.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Class that encapsulate position fields.
 *
 * @author solcanm
 * @version 1.0
 * @since 2020-01-06
 */
@Entity
@Table(name = "POSITIONS")
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LONGITUDE", nullable = false, length = 100)
    private String longitude;

    @Column(name = "LATITUDE", nullable = false, length = 100)
    private String latitude;

    @Column(name = "DATE", nullable = false, length = 100)
    private Date date;

    public Position() {
    }

    public Position(Long id, String longitude, String latitude, Date date) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
