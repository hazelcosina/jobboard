package com.ota.jobboard.controller;

import com.ota.jobboard.entity.Position;
import com.ota.jobboard.enums.Status;
import com.ota.jobboard.model.dto.PositionDTO;
import com.ota.jobboard.service.IDataFacade;
import com.ota.jobboard.service.IPositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final IPositionService positionService;
    private final IDataFacade dataFacade;

    public PositionController(IPositionService boardService, IDataFacade dataFacade) {
        this.positionService = boardService;
        this.dataFacade = dataFacade;
    }

    @GetMapping()
    public ResponseEntity<List<PositionDTO>> getAll() {
        List<PositionDTO> positions = dataFacade.fetchPositions();
        return ResponseEntity.ok(positions);
    }

    @PostMapping()
    public ResponseEntity<Position> create(@RequestBody Position position) {
        return new ResponseEntity<Position>(positionService.save(position), HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity<Position> changeStatus(@RequestParam("positionId") Long positionId, @RequestParam("status") Status status) {
        return new ResponseEntity<Position>(positionService.updateStatus(positionId, status), HttpStatus.OK);
    }

}
