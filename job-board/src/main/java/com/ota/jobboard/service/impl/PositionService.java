package com.ota.jobboard.service.impl;

import com.ota.jobboard.entity.Position;
import com.ota.jobboard.enums.Status;
import com.ota.jobboard.repository.PositionRepository;
import com.ota.jobboard.service.IPositionService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PositionService implements IPositionService {

    private final PositionRepository positionRepository;
    private final NotificationService notificationService;

    public PositionService(PositionRepository positionRepository, NotificationService notificationService) {
        this.positionRepository = positionRepository;
        this.notificationService = notificationService;
    }

    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position save(Position position) {

        Position newPosition = positionRepository.save(position);
        List<Position> positions = positionRepository.findByPostedBy(newPosition.getPostedBy());

        long count = positions.stream().count();
        if (count == 1) {
            notifyModerator(newPosition);
        }
        return newPosition;
    }

    @Override
    public Position updateStatus(Long positionId, Status newStatus) {
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new EntityNotFoundException("Position not found with id: " + positionId));

        position.setStatus(newStatus);
        return positionRepository.save(position);
    }

    void notifyModerator(Position position) {

        String notificationForPostingApproval = NotificationFactory.buildNotificationContent(position);
        notificationService.sendEmail(
                    "expresstimmy@gmail.com",
                    "New Job Posting for Approval",
                    notificationForPostingApproval);

    }
}
