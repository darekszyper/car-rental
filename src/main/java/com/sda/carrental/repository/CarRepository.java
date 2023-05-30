package com.sda.carrental.repository;

import com.sda.carrental.model.CarEntity;
import com.sda.carrental.model.enums.CarType;
import com.sda.carrental.model.enums.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query("SELECT c FROM CarEntity c WHERE (:make IS NULL OR c.make = :make) " +
            "AND (:model IS NULL OR c.model = :model) " +
            "AND (:transmission IS NULL OR c.transmission = :transmission) " +
            "AND (:carType IS NULL OR c.carType = :carType) " +
            "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR " +
            "(:minPrice IS NULL AND c.pricePerDay <= :maxPrice) OR " +
            "(:maxPrice IS NULL AND c.pricePerDay >= :minPrice) OR " +
            "(c.pricePerDay BETWEEN :minPrice AND :maxPrice))")
    List<CarEntity> searchCars(@Param("make") String make,
                               @Param("model") String model,
                               @Param("transmission") Transmission transmission,
                               @Param("carType") CarType carType,
                               @Param("minPrice") BigDecimal minPrice,
                               @Param("maxPrice") BigDecimal maxPrice);

    @Query("SELECT c FROM CarEntity c " +
            "WHERE c.carId NOT IN (" +
            "   SELECT r.car.carId FROM ReservationEntity r " +
            "   WHERE (:endDate >= r.startDate AND :startDate <= r.endDate) " +
            "   AND r.reservationStatus != 'CANCELLED'" +
            ")")
    List<CarEntity> findAvailableCarsByReservationDate(LocalDate startDate, LocalDate endDate);

}


