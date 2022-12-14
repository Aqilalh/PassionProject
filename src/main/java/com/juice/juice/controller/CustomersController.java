package com.juice.juice.controller;

import com.juice.juice.modules.Customer;
import com.juice.juice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomersController {
    @Autowired
   private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @DeleteMapping("/customer/{customerId}")
    public void deleteCategory(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        return customerService.updateCustomer(customer,customerId);
    }

    @GetMapping("/customer/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

}
