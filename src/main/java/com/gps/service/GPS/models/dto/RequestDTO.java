package com.gps.service.GPS.models.dto;

/**
 * @author solcanm
 * @version 1.0
 * @since 2020-01-08
 */
public class RequestDTO {

    private String data;

    public RequestDTO() {
    }

    public RequestDTO(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
