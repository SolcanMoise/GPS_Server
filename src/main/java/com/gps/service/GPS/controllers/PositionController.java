package com.gps.service.GPS.controllers;

import com.gps.service.GPS.exceptions.BusinessException;
import com.gps.service.GPS.models.Position;
import com.gps.service.GPS.models.dto.PositionDTO;
import com.gps.service.GPS.models.dto.RequestDTO;
import com.gps.service.GPS.models.dto.UpdateDTO;
import com.gps.service.GPS.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    UserController userController;

    @PostMapping(path = "save")
    public ResponseEntity<Position> savePosition(@RequestBody final PositionDTO positionDTO) throws BusinessException {
        return ResponseEntity.ok(positionService.addNewPosition(positionDTO, getUserId()));
    }

    @GetMapping(path = "delete")
    public ResponseEntity<Long> deletePositionById(@RequestBody final RequestDTO requestDTO) throws BusinessException {
        return ResponseEntity.ok(positionService.deletePositionById(requestDTO));
    }

    @GetMapping(path = "update")
    public ResponseEntity<Position> updatePositionById(@RequestBody final UpdateDTO updateDTO) throws BusinessException {
        return ResponseEntity.ok(positionService.updatePositionById(updateDTO, getUserId()));
    }

    @GetMapping(path = "get")
    public ResponseEntity<Position> getPositionById(@RequestBody final RequestDTO requestDTO) throws BusinessException {
        return ResponseEntity.ok(positionService.retrievePositionById(requestDTO));
    }

    @GetMapping(path = "getAllUserPositions")
    public ResponseEntity<List<Position>> retrieveUserPositions(@RequestBody final RequestDTO requestDTO) throws BusinessException {
        return ResponseEntity.ok(positionService.retrieveUserPositions(requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<Position>> getPositions() {
        return ResponseEntity.ok(positionService.getPositions());
    }

    private Long getUserId() {
        return userController.getCurrentUser().getBody().getId();
    }
}
