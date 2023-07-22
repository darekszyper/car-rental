package com.sda.carrental.service;

import com.sda.carrental.mapper.CarMapper;
import com.sda.carrental.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarMapper carMapper;
    @Mock
    private CarRepository carRepository;
    private CarService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CarService(carMapper, carRepository);
    }

    @Test
    void canFindAvailableCarsByDateWithPrice() {
        // when
        underTest.findAvailableCarsByDateWithPrice(
                LocalDate.of(2024, 8, 22),
                LocalDate.of(2024, 8, 30));

        // then
        ArgumentCaptor<LocalDate> startDateArgumentCaptor =
                ArgumentCaptor.forClass(LocalDate.class);
        ArgumentCaptor<LocalDate> endDateArgumentCaptor =
                ArgumentCaptor.forClass(LocalDate.class);

        verify(carRepository).findAvailableCarsByReservationDate(
                startDateArgumentCaptor.capture(), endDateArgumentCaptor.capture());

        LocalDate capturedStartDate = startDateArgumentCaptor.getValue();
        LocalDate capturedEndDate = endDateArgumentCaptor.getValue();

        assertThat(capturedStartDate).isEqualTo(LocalDate.of(2024, 8, 22));
        assertThat(capturedEndDate).isEqualTo(LocalDate.of(2024, 8, 30));
    }
}