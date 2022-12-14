package com.juice.juice.service;

import com.juice.juice.modules.Crepe;
import com.juice.juice.modules.MilkShakes;
import com.juice.juice.repoistory.MilkShakeRepo;
import com.juice.juice.repoistory.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MilkShakeService {

    @Autowired
    private MilkShakeRepo milkShakeRepo;

    @Autowired
    private OrderRepo orderRepo;

    public ResponseEntity<Iterable<MilkShakes>> getAllMilkShakes(){
        return new ResponseEntity<>(milkShakeRepo.findAll(), HttpStatus.OK);
    }

    public void createMilkShakes(MilkShakes milkShakes, Long orderId) {
       orderRepo.findById(orderId).map( orders-> {
            milkShakes.setOrders(orders);
            return milkShakeRepo.save(milkShakes);
        });
    }

    public ResponseEntity<?> getMilkShakeById(Long milkShakeId) {
        Optional<MilkShakes> p = milkShakeRepo.findById(milkShakeId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    public Iterable<MilkShakes> findMilkShakesByOrderId(Long orderId){
        return milkShakeRepo.findMilkShakesByOrders(orderId);
    }

    public void updateMilkShakes(MilkShakes milkShakes, Long orderId) {
        orderRepo.findById(orderId).map(orders -> {
            milkShakes.setOrders(orders);
            return milkShakeRepo.save(milkShakes);
        });

    }



    public void deleteMilkShakes(Long milkShakesId) {
        milkShakeRepo.deleteById(milkShakesId);
    }

}
