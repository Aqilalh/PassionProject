package com.juice.juice.service;

import com.juice.juice.modules.*;
import com.juice.juice.repoistory.CustomerRepo;
import com.juice.juice.repoistory.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerService customerService;


    public ResponseEntity<Iterable<Orders>> getAllOrders() {
        return new ResponseEntity<>(orderRepo.findAll(), HttpStatus.OK);
    }

    public void createOrder(Orders orders,Long customerId) {
        customerRepo.findById(customerId).map(customer -> {
            orders.setCustomer(customer);
            return orderRepo.save(orders);
        });


    }

    public ResponseEntity<?> getOrdersById(Long ordersId) {
        Optional<Orders> o = orderRepo.findById(ordersId);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    public Iterable<Orders> findOrdersByCustomerId(Long customerId){
        return orderRepo.findOrdersByCustomer(customerId);
    }

    public void updateOrder(Orders orders, Long customerId) {
        customerRepo.findById(customerId).map( customer-> {
            orders.setCustomer(customer);
            return orderRepo.save(orders);
        });
    }


    public void deleteOrders(Long ordersId) {
        orderRepo.deleteById(ordersId);
    }
}
