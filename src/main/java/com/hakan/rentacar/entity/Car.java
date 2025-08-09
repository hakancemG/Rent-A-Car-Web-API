package com.hakan.rentacar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plateNumber;

    private String brand;

    private String model;

    private int modelYear;

    private String color;

    private String transmissionType;

    private String fuelType;

    private BigDecimal dailyPrice;

    private String vehicleType;

    private String status;

    private int kilometerAge;

    private String imageUrl;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Rent> rents = new ArrayList<>();
}
