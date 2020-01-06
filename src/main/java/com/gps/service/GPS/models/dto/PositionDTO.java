package com.gps.service.GPS.models.dto;

import java.util.Date;

/**
 * @author solcanm
 * @version 1.0
 * @since 2020-01-06
 */
public class PositionDTO {

    private String longitude;
    private String latitude;
    private Date date;

    public PositionDTO() {
    }

    public PositionDTO(String longitude, String latitude, Date date) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
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
