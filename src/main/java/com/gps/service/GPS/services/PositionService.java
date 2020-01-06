package com.gps.service.GPS.services;

import com.gps.service.GPS.exceptions.BusinessException;
import com.gps.service.GPS.models.Position;
import com.gps.service.GPS.models.dto.PositionDTO;

import java.util.List;
import java.util.Optional;

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
     * @param positionId - the id of the position to be deleted.
     */
    void deletePositionById(Long positionId);

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
     * @param positionId the id of the position to be retrieved.
     * @return the retrieved position.
     */
    Optional<Position> retrievePositionById(Long positionId);
}
