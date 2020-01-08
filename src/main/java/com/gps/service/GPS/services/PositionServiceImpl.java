package com.gps.service.GPS.services;

import com.gps.service.GPS.exceptions.BusinessException;
import com.gps.service.GPS.models.Position;
import com.gps.service.GPS.models.dto.PositionDTO;
import com.gps.service.GPS.models.dto.RequestDTO;
import com.gps.service.GPS.models.dto.UpdateDTO;
import com.gps.service.GPS.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author solcanm
 * @version 1.0
 * @since 2020-01-06
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Position addNewPosition(PositionDTO positionDTO) throws BusinessException {

        if (Objects.isNull(positionDTO)) {
            throw new BusinessException(401, "Body null!");
        }

        if (Objects.isNull(positionDTO.getLongitude())) {
            throw new BusinessException(400, "Longitude cannot be null!");
        }

        if (Objects.isNull(positionDTO.getLatitude())) {
            throw new BusinessException(400, "Latitude cannot be null!");
        }

        if (Objects.isNull(positionDTO.getDate())) {
            throw new BusinessException(400, "Date cannot be null");
        }

        Position basicPosition = createPosition(positionDTO);

        return positionRepository.save(basicPosition);
    }

    @Override
    public List<Position> getPositions() {
        return (List<Position>) positionRepository.findAll();
    }

    @Override
    public Long deletePositionById(RequestDTO requestDTO) throws BusinessException {

        if (Objects.isNull(requestDTO)) {
            throw new BusinessException(401, "Body null");
        }

        try {
            Long positionId = Long.valueOf(requestDTO.getData());
            positionRepository.deleteById(positionId);
            return positionId;
        } catch (Exception e) {
            throw new BusinessException(400, "Invalid positionId");
        }
    }

    @Override
    public Position updatePositionById(UpdateDTO updateDTO) throws BusinessException {

        if (Objects.isNull(updateDTO)) {
            throw new BusinessException(401, "Body null");
        }

        if (Objects.isNull(updateDTO.getPositionId())) {
            throw new BusinessException(400, "PositionId must not be null");
        }

        if (Objects.isNull(updateDTO.getUpdateReason())) {
            throw new BusinessException(400, "UpdateReason must not be null");
        }

        if (Objects.isNull(updateDTO.getPositionDTO())) {
            throw new BusinessException(400, "Position data must not be null");
        }

        try {
            Long positionId = Long.valueOf(updateDTO.getPositionId());
            boolean isPositionFind = positionRepository.existsById(positionId);
            if (isPositionFind) {
                Position position = createPosition(updateDTO.getPositionDTO());
                position.setId(positionId);
                positionRepository.save(position); // work as update(because of positionId)
                return position;
            } else {
                throw new BusinessException(400, "Position not found in database!");
            }
        } catch (Exception e) {
            throw new BusinessException(400, "Error when trying to update position!");
        }

    }

    @Override
    public Position retrievePositionById(RequestDTO requestDTO) throws BusinessException {
        if (Objects.isNull(requestDTO)) {
            throw new BusinessException(401, "Body null");
        }

        try {
            Long positionId = Long.valueOf(requestDTO.getData());
            return positionRepository.findById(positionId).orElse(null);
        } catch (Exception e) {
            throw new BusinessException(400, "Invalid positionId");
        }
    }

    private Position createPosition(PositionDTO positionDTO) {
        Position position = new Position();
        position.setLongitude(positionDTO.getLongitude());
        position.setLatitude(positionDTO.getLatitude());
        position.setDate(new Date(positionDTO.getDate().getTime()));

        return position;
    }

}
