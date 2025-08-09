package com.hakan.rentacar.mapper;

import com.hakan.rentacar.dto.Rent.RentAdminDTO;
import com.hakan.rentacar.dto.Rent.RentDTO;
import com.hakan.rentacar.entity.Car;
import com.hakan.rentacar.entity.Customer;
import com.hakan.rentacar.entity.Rent;

public class RentMapper {

    // Entity'den RentDTO'ya çeviri.
    public static RentDTO toRentDTO(Rent rent){
        if (rent == null) {
            throw new IllegalArgumentException("Rent cannot be null");
        }
        return RentDTO.builder()
                .id(rent.getId())
                .status(rent.getStatus())
                .customerId(rent.getCustomer().getId())
                .carId(rent.getCar().getId())
                .build();
    }

    // Entity'den RentAdminDTO'ya çeviri.
    public static RentAdminDTO toRentAdminDTO(Rent rent){
        if (rent == null) {
            throw new IllegalArgumentException("Rent cannot be null");
        }
        return RentAdminDTO.builder()
                .id(rent.getId())
                .startDate(rent.getStartDate())
                .endDate(rent.getEndDate())
                .status(rent.getStatus())
                .totalPrice(rent.getTotalPrice())
                .carId(rent.getCar().getId())
                .customerId(rent.getCustomer().getId())
                .build();
    }

    // RentDTO'dan Entity'ye çeviri.
    public static Rent toRent(RentDTO rentDTO, Customer customer, Car car){
        if (rentDTO == null || customer == null || car == null) {
            throw new IllegalArgumentException("RentDTO, Customer, or Car cannot be null");
        }
        return Rent.builder()
                .id(rentDTO.getId())
                .status(rentDTO.getStatus())
                .customer(customer)
                .car(car)
                .build();
    }

    // RentAdminDTO'dan Entity'ye çeviri (car ve customer ID'leri ile)
    public static Rent toRent(RentAdminDTO rentAdminDTO, Car car, Customer customer){
        if (rentAdminDTO == null || car == null || customer == null) {
            throw new IllegalArgumentException("RentAdminDTO, Car, or Customer cannot be null");
        }
        return Rent.builder()
                .id(rentAdminDTO.getId())
                .startDate(rentAdminDTO.getStartDate())
                .endDate(rentAdminDTO.getEndDate())
                .status(rentAdminDTO.getStatus())
                .totalPrice(rentAdminDTO.getTotalPrice())
                .customer(customer)
                .car(car)
                .build();
    }
}
