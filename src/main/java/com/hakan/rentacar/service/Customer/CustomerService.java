package com.hakan.rentacar.service.Customer;

import com.hakan.rentacar.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAllCustomers();

    Optional<Customer> findCustomerById(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomerById(Long id);
}
