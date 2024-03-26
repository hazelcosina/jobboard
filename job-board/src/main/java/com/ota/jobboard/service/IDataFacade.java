package com.ota.jobboard.service;

import com.ota.jobboard.model.dto.PositionDTO;

import java.util.List;

public interface IDataFacade {
    List<PositionDTO> fetchPositions();
}
