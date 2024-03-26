package com.ota.jobboard.service;

import com.ota.jobboard.entity.Position;
import com.ota.jobboard.enums.Status;

import java.util.List;

public interface IBoardService {

    List<Position> getAll();
    Position save(Position position);
    Position updateStatus(Long positionId, Status newStatus);
}
