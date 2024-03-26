package com.ota.jobboard.service;

import com.ota.jobboard.model.dto.PositionDTO;
import com.ota.jobboard.entity.Position;
import com.ota.jobboard.model.workzag.JobDescription;
import com.ota.jobboard.model.workzag.JobPosition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface IPositionMapper {

    @Mapping(target = "description", expression = "java(toList(position.getDescription()))")
    PositionDTO positionToPositionDTO(Position position);

    @Mapping(target = "company", source = "subcompany")
    @Mapping(target = "description", expression = "java(descriptionToList(position.getJobDescriptions()))")
    PositionDTO workzagPositionToPositionDTO(JobPosition position);

    default List<String> toList(String array) {
        return array != null ? Arrays.asList(array) : null;
    }
    default List<String> descriptionToList(List<JobDescription> jobDescriptions) {
        return jobDescriptions != null ? jobDescriptions.stream()
                .map(JobDescription::getValue)
                .collect(Collectors.toList()): null;
    }
}
