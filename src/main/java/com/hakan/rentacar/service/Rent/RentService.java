package com.hakan.rentacar.service.Rent;

import com.hakan.rentacar.entity.Rent;

import java.util.List;
import java.util.Optional;

public interface RentService {
    List<Rent> findAllRents();

    Optional<Rent> findRentById(Long id);

    Rent saveRent(Rent rent);

    void deleteRent(Long id);
}
