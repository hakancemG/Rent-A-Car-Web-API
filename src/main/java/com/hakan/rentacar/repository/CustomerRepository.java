package com.hakan.rentacar.repository;

import com.hakan.rentacar.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //CRUD
}
