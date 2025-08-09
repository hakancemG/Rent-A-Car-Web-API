package com.hakan.rentacar.service.Car;

import com.hakan.rentacar.repository.CarRepository;
import com.hakan.rentacar.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;

    // @Authowired. Tek constructor olduğu için yazmaya gerek yok.
    // Constructor injection.
    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAllCars(){
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findCarById(Long id){
        return carRepository.findById(id);
    }

    @Override
    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }
}
