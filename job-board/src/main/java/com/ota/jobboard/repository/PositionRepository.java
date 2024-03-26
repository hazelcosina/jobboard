package com.ota.jobboard.repository;

import com.ota.jobboard.entity.Position;
import com.ota.jobboard.entity.User;
import com.ota.jobboard.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findAll();
    List<Position> findByPostedBy(User user);

    @Modifying
    @Query("UPDATE Position p SET p.status = :newStatus WHERE p.id = :positionId")
    Position updateStatus(@Param("positionId") Long positionId, @Param("newStatus") Status newStatus);
}
