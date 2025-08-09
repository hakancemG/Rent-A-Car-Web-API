package com.hakan.rentacar.controller;

import com.hakan.rentacar.dto.Car.CarAdminDTO;
import com.hakan.rentacar.dto.Car.CarDTO;
import com.hakan.rentacar.entity.Car;
import com.hakan.rentacar.mapper.CarMapper;
import com.hakan.rentacar.service.Car.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*") // frontend için.
public class CarController {

    private CarService carService;

    // @Authowired opsiyoneldir, çünkü sadece bir constructor var.
    // Constructor injection.
    public CarController(CarService carService){
        this.carService = carService;
    }

    // RentACar çalışanı için GET isteği.
    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> findAllCars() {
        try {
            List<CarDTO> cars = carService.findAllCars()
                    .stream()
                    .map(CarMapper::toCarDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(cars);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();  // HTTP 500 on error
        }
    }

    // RentACar admini için GET isteği.
    @GetMapping("/admin/cars")
    public ResponseEntity<List<CarAdminDTO>> findAllCarsAdmin() {
        try {
            List<CarAdminDTO> cars = carService.findAllCars()
                    .stream()
                    .map(CarMapper::toCarAdminDTO)
                    .collect(Collectors.toList());

            return cars.isEmpty()
                    ? ResponseEntity.noContent().build()
                    : ResponseEntity.ok(cars);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();  // HTTP 500 on error
        }
    }

    // RentACar admini için GET (by id) isteği.
    @GetMapping("/admin/cars/{id}")
    public ResponseEntity<CarAdminDTO> findCarByIdAdmin(@PathVariable Long id) {
        try {
            return carService.findCarById(id)
                    .map(CarMapper::toCarAdminDTO)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // RentACar çalışanı için GET (by id) isteği.
    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDTO> findCarById(@PathVariable Long id) {
        try {
            return carService.findCarById(id)
                    .map(CarMapper::toCarDTO)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Kayıt alırken, CarAdminDTO olarak alıp Car Entity'sine çevirip veritabanına kaydediyoruz.
    // return ederken de CarDTO'lu halini dönüyoruz.
    @PostMapping("/car")
    public ResponseEntity<CarDTO> saveCar(@RequestBody @Valid CarAdminDTO carAdminDTO) {
        try {
            Car car = CarMapper.toCar(carAdminDTO);
            Car savedCar = carService.saveCar(car);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CarMapper.toCarDTO(savedCar));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }
}
