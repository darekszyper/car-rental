package com.sda.carrental.service;

import com.sda.carrental.dto.CarDto;
import com.sda.carrental.model.CarEntity;
import com.sda.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public CarDto findCarById(Long id) {
        return CarDto.from(carRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }


    public CarDto saveCar(CarDto car) {
        return CarDto.from(carRepository.save(CarEntity.toNewEntity(car)));
    }
}
