package com.hakan.rentacar.controller;

import com.hakan.rentacar.dto.Customer.CustomerAdminDTO;
import com.hakan.rentacar.dto.Customer.CustomerDTO;
import com.hakan.rentacar.entity.Customer;
import com.hakan.rentacar.mapper.CustomerMapper;
import com.hakan.rentacar.service.Customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    // RentACar çalışanı için bir GET isteği.
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> findAllCustomers() {
        try {
            List<CustomerDTO> customers = customerService.findAllCustomers()
                    .stream()
                    .map(CustomerMapper::toCustomerDTO)
                    .collect(Collectors.toList());

            if (customers.isEmpty()) {
                return ResponseEntity.noContent().build();  // 204 No Content
            }

            return ResponseEntity.ok(customers);  // 200 OK
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();  // 500 Error
        }
    }

    // RentACar admini için bir GET isteği.
    @GetMapping("/admin/customers")
    public ResponseEntity<List<CustomerAdminDTO>> findAllCustomersAdmin() {
        try {
            List<CustomerAdminDTO> customers = customerService.findAllCustomers()
                    .stream()
                    .map(CustomerMapper::toCustomerAdminDTO)
                    .collect(Collectors.toList());

            if (customers.isEmpty()) {
                return ResponseEntity.noContent().build();  // 204 No Content
            }

            return ResponseEntity.ok(customers);  // 200 OK
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();  // 500 Internal Server Error
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable Long id) {
        try {
            return customerService.findCustomerById(id)
                    .map(CustomerMapper::toCustomerDTO)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/admin/customer/{id}")
    public ResponseEntity<CustomerAdminDTO> findCustomerByIdAdmin(@PathVariable Long id) {
        try {
            return customerService.findCustomerById(id)
                    .map(CustomerMapper::toCustomerAdminDTO)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody @Valid CustomerAdminDTO customerAdminDTO) {
        try {
            Customer customer = CustomerMapper.toCustomer(customerAdminDTO);
            Customer savedCustomer = customerService.saveCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CustomerMapper.toCustomerDTO(savedCustomer));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }

}
