package com.sda.carrental.repository;

import com.sda.carrental.model.CarEntity;
import com.sda.carrental.model.ReservationEntity;
import com.sda.carrental.model.enums.CarType;
import com.sda.carrental.model.enums.ReservationStatus;
import com.sda.carrental.model.enums.Transmission;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository underTestCar;

    @Autowired
    private ReservationRepository underTestReservation;

    @AfterEach
    void tearDown() {
        underTestReservation.deleteAll();
        underTestCar.deleteAll();
    }

    @Test
    void itShouldFindAvailableCarsByReservationDateAndReservationStatus() {
        // given
        CarEntity carA = new CarEntity("Ford", "Mustang", Transmission.AUTOMATIC,
                CarType.COUPE, "2018", new BigDecimal(75.99));

        CarEntity carB = new CarEntity("BMW", "X5", Transmission.MANUAL,
                CarType.SUV, "2019", new BigDecimal(95.75));

        CarEntity carC = new CarEntity("Toyota", "Camry", Transmission.AUTOMATIC,
                CarType.SEDAN, "2020", new BigDecimal(65.50));
        underTestCar.saveAll(List.of(carA, carB, carC));

        // it doesn't overlap desired date (carA should be included)
        ReservationEntity reservationA = new ReservationEntity(LocalDate.of(2024, 8, 1),
                LocalDate.of(2024, 8, 21), ReservationStatus.CONFIRMED, carA);

        // it overlaps desired date and confirmed (carB should be excluded)
        ReservationEntity reservationB = new ReservationEntity(LocalDate.of(2024, 8, 23),
                LocalDate.of(2024, 9, 1), ReservationStatus.CONFIRMED, carB);

        // it doesn't overlap desired date but carB also have previous reservation
        // which already excluded it from results (carB should be excluded)
        ReservationEntity reservationC = new ReservationEntity(LocalDate.of(2024, 8, 1),
                LocalDate.of(2024, 8, 21), ReservationStatus.CONFIRMED, carB);

        // it overlaps desired date but cancelled (carC should be included)
        ReservationEntity reservationD = new ReservationEntity(LocalDate.of(2024, 8, 23),
                LocalDate.of(2024, 9, 1), ReservationStatus.CANCELLED, carC);
        underTestReservation.saveAll(List.of(reservationA, reservationB, reservationC, reservationD));

        // when
        List<CarEntity> expected = underTestCar.findAvailableCarsByReservationDate(
                LocalDate.of(2024, 8, 22),
                LocalDate.of(2024, 8, 30));

        // then
        assertThat(expected).isEqualTo(List.of(carA, carC));
    }
}