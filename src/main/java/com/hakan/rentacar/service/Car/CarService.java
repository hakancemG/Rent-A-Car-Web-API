package com.hakan.rentacar.service.Car;

import com.hakan.rentacar.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> findAllCars();

    Optional<Car> findCarById(Long id);

    Car saveCar(Car car);

    void deleteCar(Long id);
}
