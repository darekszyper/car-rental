package com.sda.carrental.repository;

import com.sda.carrental.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query("SELECT c FROM CarEntity c " +
            "LEFT JOIN c.reservations r " +
            "WHERE (:endDate < r.startDate " +
            "OR :startDate > r.endDate " +
            "OR (r.reservationId IS NULL)) " +
            "AND r.reservationStatus != 'CANCELLED'")
    List<CarEntity> findAvailableCarsByReservationDate(LocalDate startDate, LocalDate endDate);
}
