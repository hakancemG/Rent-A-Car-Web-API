package com.hakan.rentacar.repository;

import com.hakan.rentacar.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    //CRUD
}
