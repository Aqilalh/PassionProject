package com.juice.juice.service;

import com.juice.juice.modules.Crepe;
import com.juice.juice.repoistory.CrepeRepo;
import com.juice.juice.repoistory.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrepeService {

    @Autowired
    private CrepeRepo crepeRepo;

    @Autowired
    private OrderRepo orderRepo;

    public ResponseEntity<Iterable<Crepe>> getAllCrepes(){
        return new ResponseEntity<>(crepeRepo.findAll(), HttpStatus.OK);
    }

    public void createCrepe(Crepe crepe, Long orderId) {
        orderRepo.findById(orderId).map(orders -> {
            crepe.setOrders(orders);
            return crepeRepo.save(crepe);
        });
    }

    public ResponseEntity<?> getCrepeById(Long crepeId) {
        Optional<Crepe> p = crepeRepo.findById(crepeId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    public Iterable<Crepe> findCrepeByOrderId(Long orderId){
        return crepeRepo.findCrepeByOrders(orderId);
}


    public void updateCrepe(Crepe crepe, Long orderId) {
        orderRepo.findById(orderId).map(orders -> {
            crepe.setOrders(orders);
            return crepeRepo.save(crepe);
        });

    }


    public void deleteCrepe(Long crepeId) {
        crepeRepo.deleteById(crepeId);
    }

}
