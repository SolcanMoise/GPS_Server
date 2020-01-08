package com.gps.service.GPS.services;

import com.gps.service.GPS.exceptions.BusinessException;
import com.gps.service.GPS.models.Position;
import com.gps.service.GPS.models.dto.PositionDTO;
import com.gps.service.GPS.models.dto.RequestDTO;

import java.util.List;

/**
 * @author solcanm
 * @version 1.0
 * @since 2020-01-06
 */
public interface PositionService {

    /**
     * Save a new position into Database
     *
     * @param positionDTO - the position to be saved.
     * @return the created position.
     * @throws BusinessException
     */
    Position addNewPosition(final PositionDTO positionDTO) throws BusinessException;

    /**
     * Get all existing positions from Database;
     *
     * @return
     */
    List<Position> getPositions();


    /**
     * Delete a position.
     *
     * @param requestDTO - the request data.
     */
    Long deletePositionById(RequestDTO requestDTO) throws BusinessException;

    /**
     * Update a position
     *
     * @param positionId  the id of the position to be updated.
     * @param positionDTO the new position data.
     * @return the position updated.
     */
    Position updatePositionById(Long positionId, PositionDTO positionDTO);

    /**
     * Retrieve a position.
     *
     * @param requestDTO request data.
     * @return the retrieved position.
     */
    Position retrievePositionById(RequestDTO requestDTO) throws BusinessException;
}
