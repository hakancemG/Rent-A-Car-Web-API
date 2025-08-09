package com.hakan.rentacar.controller;

import com.hakan.rentacar.dto.Rent.RentAdminDTO;
import com.hakan.rentacar.dto.Rent.RentDTO;
import com.hakan.rentacar.entity.Car;
import com.hakan.rentacar.entity.Customer;
import com.hakan.rentacar.entity.Rent;
import com.hakan.rentacar.mapper.RentMapper;
import com.hakan.rentacar.service.Car.CarService;
import com.hakan.rentacar.service.Customer.CustomerService;
import com.hakan.rentacar.service.Rent.RentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RentController {

    private RentService rentService;
    private final CarService carService;
    private final CustomerService customerService;

    public RentController(RentService rentService, CarService carService, CustomerService customerService){
        this.rentService = rentService;
        this.carService = carService;
        this.customerService = customerService;
    }

    // RentACar çalışanı için bir GET isteği.
    @GetMapping("/rents")
    public ResponseEntity<List<RentDTO>> findAllRents() {
        try {
            List<RentDTO> rents = rentService.findAllRents()
                    .stream()
                    .map(RentMapper::toRentDTO)
                    .collect(Collectors.toList());

            if (rents.isEmpty()) {
                return ResponseEntity.noContent().build();  // 204 No Content
            }

            return ResponseEntity.ok(rents);  // 200 OK
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();  // 500 Internal Server Error
        }
    }

    // RentACar admini için bir GET isteği.
    @GetMapping("/admin/rents")
    public ResponseEntity<List<RentAdminDTO>> findAllRentsAdmin() {
        try {
            List<RentAdminDTO> rents = rentService.findAllRents()
                    .stream()
                    .map(RentMapper::toRentAdminDTO)
                    .collect(Collectors.toList());

            if (rents.isEmpty()) {
                return ResponseEntity.noContent().build();  // HTTP 204
            }

            return ResponseEntity.ok(rents);  // HTTP 200
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();  // HTTP 500
        }
    }

    // RentACar çalışanı için id ile bir GET isteği.
    @GetMapping("/rent/{id}")
    public ResponseEntity<RentDTO> findRentById(@PathVariable Long id) {
        try {
            return rentService.findRentById(id)
                    .map(RentMapper::toRentDTO)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // RentACar admini için id ile bir GET isteği.
    @GetMapping("/admin/rent/{id}")
    public ResponseEntity<RentAdminDTO> findRentByIdAdmin(@PathVariable Long id) {
        try {
            return rentService.findRentById(id)
                    .map(RentMapper::toRentAdminDTO)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/rent")
    public ResponseEntity<RentAdminDTO> createRent(@RequestBody @Valid RentAdminDTO rentAdminDTO) {
        try {
            // Car ve Customer'ı ID'lerine göre bul
            Optional<Car> carOptional = carService.findCarById(rentAdminDTO.getCarId());
            Optional<Customer> customerOptional = customerService.findCustomerById(rentAdminDTO.getCustomerId());

            if (carOptional.isEmpty() || customerOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            // DTO'dan Entity'ye dönüştür
            Rent rent = RentMapper.toRent(rentAdminDTO, carOptional.get(), customerOptional.get());

            // Kaydet
            Rent savedRent = rentService.saveRent(rent);

            // Entity'den DTO'ya dönüştür ve döndür
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(RentMapper.toRentAdminDTO(savedRent));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/rent/{id}")
    public void deleteRent(@PathVariable Long id){
        rentService.deleteRent(id);
    }

}
