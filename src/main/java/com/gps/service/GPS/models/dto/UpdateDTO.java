package com.gps.service.GPS.models.dto;

/**
 * @author solcanm
 * @version 1.0
 * @since 2020-01-08
 */
public class UpdateDTO {

    private String positionId;
    private String updateReason;
    private PositionDTO positionDTO;

    public UpdateDTO() {
    }

    public UpdateDTO(String positionId, String updateReason, PositionDTO positionDTO) {
        this.positionId = positionId;
        this.updateReason = updateReason;
        this.positionDTO = positionDTO;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getUpdateReason() {
        return updateReason;
    }

    public void setUpdateReason(String updateReason) {
        this.updateReason = updateReason;
    }

    public PositionDTO getPositionDTO() {
        return positionDTO;
    }

    public void setPositionDTO(PositionDTO positionDTO) {
        this.positionDTO = positionDTO;
    }
}
