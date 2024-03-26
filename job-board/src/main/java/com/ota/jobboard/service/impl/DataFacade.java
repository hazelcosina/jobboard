package com.ota.jobboard.service.impl;

import com.ota.jobboard.model.dto.PositionDTO;
import com.ota.jobboard.model.workzag.JobPosition;
import com.ota.jobboard.model.workzag.WorkzagJobs;
import com.ota.jobboard.service.IDataFacade;
import com.ota.jobboard.service.IPositionMapper;
import com.ota.jobboard.service.IPositionService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataFacade implements IDataFacade {

    private final IPositionService positionService;
    private final WebClient webClient;
    private final IPositionMapper positionMapper;

    public DataFacade(IPositionMapper positionMapper, WebClient webClient, IPositionService positionService) {
        this.positionMapper = positionMapper;
        this.webClient = webClient;
        this.positionService = positionService;
    }

    @Override
    public List<PositionDTO> fetchPositions() {
        WorkzagJobs workzagJobs = webClient.get()
                .retrieve()
                .bodyToMono(WorkzagJobs.class).block();
        List<JobPosition> positions = workzagJobs.getPositions();

        //From External API
        List<PositionDTO> positionsFromWorkzag = positions.stream()
                .map(positionMapper::workzagPositionToPositionDTO)
                .collect(Collectors.toList());

        //From DB
        List<PositionDTO> positionsFromDb = positionService.getAll().stream()
                .map(positionMapper::positionToPositionDTO)
                .collect(Collectors.toList());

        List<PositionDTO> allPositions = new ArrayList<>();
        allPositions.addAll(positionsFromDb);
        allPositions.addAll(positionsFromWorkzag);

        return allPositions;
    }
}
