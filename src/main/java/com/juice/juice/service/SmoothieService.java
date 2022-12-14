package com.juice.juice.service;

import com.juice.juice.modules.MilkShakes;
import com.juice.juice.modules.Smoothie;
import com.juice.juice.repoistory.OrderRepo;
import com.juice.juice.repoistory.SmoothieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmoothieService {

    @Autowired
    private SmoothieRepo smoothieRepo;

    @Autowired
    private OrderRepo orderRepo;


    public ResponseEntity<Iterable<Smoothie>> getAllSmoothie(){
        return new ResponseEntity<>(smoothieRepo.findAll(), HttpStatus.OK);
    }

    public void createSmoothie(Smoothie smoothie, Long orderId) {
        orderRepo.findById(orderId).map( orders-> {
            smoothie.setOrders(orders);
            return smoothieRepo.save(smoothie);
        });
    }

    public ResponseEntity<?> getSmoothieById(Long smoothieId) {
        Optional<Smoothie> s = smoothieRepo.findById(smoothieId);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    public Iterable<Smoothie> findSmoothieByOrderId(Long orderId){
        return smoothieRepo.findSmoothieByOrders(orderId);
    }

    public void updateSmoothie(Smoothie smoothie, Long orderId) {
        orderRepo.findById(orderId).map(orders -> {
            smoothie.setOrders(orders);
            return smoothieRepo.save(smoothie);
        });

    }



    public void deleteSmoothie(Long smoothieId) {
        smoothieRepo.deleteById(smoothieId);
    }


}
