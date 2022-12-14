package com.juice.juice.service;

import com.juice.juice.modules.Customer;
import com.juice.juice.repoistory.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Iterable<Customer> allCustomer = customerRepo.findAll();
        return new ResponseEntity<>(customerRepo.findAll(), HttpStatus.OK);
    }

    public void createCustomer( Customer customer){
        customerRepo.save(customer);
    }


    public ResponseEntity<?> updateCustomer(Customer customer, Long customerId) {
        customerRepo.save(customer);

        return new ResponseEntity<> (HttpStatus.OK);
    }


    public void deleteCustomer(Long customerId) {
        customerRepo.deleteById(customerId);
    }



    public Optional<Customer> getCustomerById(Long customerId) {

        return customerRepo.findById(customerId);
    }




}
