package com.gps.service.GPS.controllers;

import com.gps.service.GPS.exceptions.BusinessException;
import com.gps.service.GPS.models.Position;
import com.gps.service.GPS.models.dto.PositionDTO;
import com.gps.service.GPS.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author solcanm
 * @version 1.0
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping(path = "save")
    public ResponseEntity<Position> savePosition(@RequestBody final PositionDTO positionDTO) throws BusinessException {
        return ResponseEntity.ok(positionService.addNewPosition(positionDTO));
    }

    @GetMapping(path = "delete")
    public void deletePositionById(@RequestBody final Long positionId) throws BusinessException {
        positionService.deletePositionById(positionId);
    }

    @GetMapping(path = "update")
    public ResponseEntity<Position> updatePositionById(@RequestParam final Long positionId, @RequestParam final PositionDTO positionDTO) throws BusinessException {
        return ResponseEntity.ok(positionService.updatePositionById(positionId, positionDTO));
    }

    @GetMapping(path = "get")
    public ResponseEntity<Position> getPositionById(@RequestBody final Long positionId) throws BusinessException {
        Optional<Position> response = positionService.retrievePositionById(positionId);
        return ResponseEntity.ok(response.orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Position>> getPositions() {
        return ResponseEntity.ok(positionService.getPositions());
    }
}
