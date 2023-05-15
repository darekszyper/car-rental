package com.sda.carrental.service;

import com.sda.carrental.dto.CarDto;
import com.sda.carrental.model.CarEntity;
import com.sda.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public void deleteCarById(Long id) {
        CarEntity car = carRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        carRepository.delete(car);
    }

    public List<CarDto> findAllCars() {
        return carRepository.findAll().stream().map(CarDto::from).collect(Collectors.toList());
    }
}
