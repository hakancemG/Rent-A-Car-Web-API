package com.hakan.rentacar.service.Customer;

import com.hakan.rentacar.repository.CustomerRepository;
import com.hakan.rentacar.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomerById(Long id){
        return customerRepository.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }
}
