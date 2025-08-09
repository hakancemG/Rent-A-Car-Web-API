package com.hakan.rentacar.mapper;

import com.hakan.rentacar.dto.Customer.CustomerAdminDTO;
import com.hakan.rentacar.dto.Customer.CustomerDTO;
import com.hakan.rentacar.entity.Customer;

public class CustomerMapper {

    // Customer entity'sinden CustomerDTO'ya çeviri
    public static CustomerDTO toCustomerDTO(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }

    // Customer entity'sinden CustomerAdminDTO'ya çeviri
    public static CustomerAdminDTO toCustomerAdminDTO(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        return CustomerAdminDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .tckn(customer.getTckn())
                .build();
    }

    // CustomerDTO'dan Customer entity'sine çeviri
    public static Customer toCustomer(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            throw new IllegalArgumentException("CustomerDTO cannot be null");
        }
        return Customer.builder()
                .id(customerDTO.getId())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .build();
    }

    // CustomerAdminDTO'dan Customer entity'sine çeviri
    public static Customer toCustomer(CustomerAdminDTO customerAdminDTO) {
        if (customerAdminDTO == null) {
            throw new IllegalArgumentException("CustomerAdminDTO cannot be null");
        }
        return Customer.builder()
                .id(customerAdminDTO.getId())
                .firstName(customerAdminDTO.getFirstName())
                .lastName(customerAdminDTO.getLastName())
                .email(customerAdminDTO.getEmail())
                .phone(customerAdminDTO.getPhone())
                .tckn(customerAdminDTO.getTckn())
                .build();
    }
}