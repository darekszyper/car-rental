package com.sda.carrental.service;

import com.sda.carrental.dto.request.CarRequest;
import com.sda.carrental.dto.response.CarResponse;
import com.sda.carrental.mapper.CarMapper;
import com.sda.carrental.model.CarEntity;
import com.sda.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarMapper carMapper;

    private final CarRepository carRepository;

    public CarResponse findCarById(Long id) {
        return carMapper.responseFrom(carRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }

    public CarResponse saveCar(CarRequest car) {
        return carMapper.responseFrom(carRepository.save(carMapper.toNewEntity(car)));
    }

    public void deleteCarById(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }
    }

    public List<CarResponse> findAllCars() {
        return carRepository.findAll().stream().map(carMapper::responseFrom).collect(Collectors.toList());
    }

    public CarResponse updateCar(Long id, CarRequest car) {
        CarEntity updatedCar = carRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        updatedCar.setMake(car.getMake());
        updatedCar.setModel(car.getModel());
        updatedCar.setTransmission(car.getTransmission());
        updatedCar.setCarType(car.getCarType());
        updatedCar.setProductionYear(car.getProductionYear());
        updatedCar.setPricePerDay(car.getPricePerDay());

        CarEntity savedCar = carRepository.save(updatedCar);

        return carMapper.responseFrom(savedCar);
    }
}
