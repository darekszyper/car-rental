package com.sda.carrental.service;

import com.sda.carrental.dto.request.CarRequest;
import com.sda.carrental.dto.response.CarResponse;
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

    public CarResponse findCarById(Long id) {
        return CarResponse.from(carRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }

    public CarResponse saveCar(CarRequest car) {
        return CarResponse.from(carRepository.save(CarEntity.toNewEntity(car)));
    }

    public void deleteCarById(Long id) {
        CarEntity car = carRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        carRepository.delete(car);
    }

    public List<CarResponse> findAllCars() {
        return carRepository.findAll().stream().map(CarResponse::from).collect(Collectors.toList());
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

        return CarResponse.from(savedCar);
    }
}
