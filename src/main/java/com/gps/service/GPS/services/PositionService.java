package com.gps.service.GPS.services;

import com.gps.service.GPS.exceptions.BusinessException;
import com.gps.service.GPS.models.Position;
import com.gps.service.GPS.models.dto.PositionDTO;
import com.gps.service.GPS.models.dto.RequestDTO;
import com.gps.service.GPS.models.dto.UpdateDTO;

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
     * @param userId      - the id of the user
     * @return the created position.
     * @throws BusinessException
     */
    Position addNewPosition(final PositionDTO positionDTO, final Long userId) throws BusinessException;

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
     * @param updateDTO data used for update.
     * @param userId    - the id of the user
     * @return the position updated.
     */
    Position updatePositionById(UpdateDTO updateDTO, Long userId) throws BusinessException;

    /**
     * Retrieve a position.
     *
     * @param requestDTO request data.
     * @return the retrieved position.
     */
    Position retrievePositionById(RequestDTO requestDTO) throws BusinessException;

    /**
     * Retrieve all User positions
     *
     * @param requestDTO - user data.
     * @return a list contains all user positions.
     */
    List<Position> retrieveUserPositions(RequestDTO requestDTO) throws BusinessException;
}
