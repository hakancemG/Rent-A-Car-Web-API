package com.hakan.rentacar.mapper;

import com.hakan.rentacar.dto.Car.CarAdminDTO;
import com.hakan.rentacar.dto.Car.CarDTO;
import com.hakan.rentacar.entity.Car;

public class CarMapper {

    public static CarDTO toCarDTO(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        return CarDTO.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .modelYear(car.getModelYear())
                .color(car.getColor())
                .transmissionType(car.getTransmissionType())
                .fuelType(car.getFuelType())
                .dailyPrice(car.getDailyPrice())
                .vehicleType(car.getVehicleType())
                .status(car.getStatus())
                .kilometerAge(car.getKilometerAge())
                .build();
    }

    public static CarAdminDTO toCarAdminDTO(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        return CarAdminDTO.builder()
                .id(car.getId())
                .plateNumber(car.getPlateNumber())
                .brand(car.getBrand())
                .model(car.getModel())
                .modelYear(car.getModelYear())
                .color(car.getColor())
                .transmissionType(car.getTransmissionType())
                .fuelType(car.getFuelType())
                .dailyPrice(car.getDailyPrice())
                .vehicleType(car.getVehicleType())
                .status(car.getStatus())
                .kilometerAge(car.getKilometerAge())
                .imageUrl(car.getImageUrl())
                .build();
    }

    public static Car toCar(CarDTO carDTO) {
        if (carDTO == null) {
            throw new IllegalArgumentException("CarDTO cannot be null");
        }
        return Car.builder()
                .id(carDTO.getId())
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .modelYear(carDTO.getModelYear())
                .color(carDTO.getColor())
                .transmissionType(carDTO.getTransmissionType())
                .fuelType(carDTO.getFuelType())
                .dailyPrice(carDTO.getDailyPrice())
                .vehicleType(carDTO.getVehicleType())
                .status(carDTO.getStatus())
                .kilometerAge(carDTO.getKilometerAge())
                .build();
    }

    public static Car toCar(CarAdminDTO carAdminDTO) {
        if (carAdminDTO == null) {
            throw new IllegalArgumentException("CarAdminDTO cannot be null");
        }
        return Car.builder()
                .id(carAdminDTO.getId())
                .plateNumber(carAdminDTO.getPlateNumber())
                .brand(carAdminDTO.getBrand())
                .model(carAdminDTO.getModel())
                .modelYear(carAdminDTO.getModelYear())
                .color(carAdminDTO.getColor())
                .transmissionType(carAdminDTO.getTransmissionType())
                .fuelType(carAdminDTO.getFuelType())
                .dailyPrice(carAdminDTO.getDailyPrice())
                .vehicleType(carAdminDTO.getVehicleType())
                .status(carAdminDTO.getStatus())
                .kilometerAge(carAdminDTO.getKilometerAge())
                .imageUrl(carAdminDTO.getImageUrl())
                .build();
    }
}