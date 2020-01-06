package com.gps.service.GPS.exceptions;

/**
 * @author solcanm
 * @version 1.0
 * @since 2020-01-06
 */
public class BusinessException extends Exception {

    public Integer status;

    public BusinessException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
