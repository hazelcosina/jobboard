package com.ota.jobboard.controller;

import com.ota.jobboard.entity.Position;
import com.ota.jobboard.enums.Status;
import com.ota.jobboard.service.IBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final IBoardService boardService;

    public PositionController(IBoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping()
    public ResponseEntity<List<Position>> getAll() {
        List<Position> positions = boardService.getAll();
        return ResponseEntity.ok(positions);
    }

    @PostMapping()
    public ResponseEntity<Position> create(@RequestBody Position position) {
        return new ResponseEntity<Position>(boardService.save(position), HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity<Position> changeStatus(@RequestParam("positionId") Long positionId, @RequestParam("status") Status status) {
        try {
            return new ResponseEntity<Position>(boardService.updateStatus(positionId, status), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
