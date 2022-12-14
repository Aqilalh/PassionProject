package com.juice.juice.controller;

import com.juice.juice.modules.Crepe;
import com.juice.juice.modules.MilkShakes;
import com.juice.juice.service.MilkShakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MilkShakeController {

    @Autowired
    private MilkShakeService milkShakeService;

    @GetMapping("/milkShake")
    public ResponseEntity<Iterable<MilkShakes>> getAllMilkShakes() {
        return milkShakeService.getAllMilkShakes();
    }

    @PostMapping("/milkShake/{orderId}/milkShake")
    public void createMilkShake(@PathVariable(value = "orderId") Long orderId, @RequestBody MilkShakes milkShakes) {
        milkShakeService.createMilkShakes(milkShakes, orderId);
    }

    @GetMapping("/milkShake/{id}/milkShake")
    public ResponseEntity<?> getMilkShakeById(@PathVariable Long id) {
        return milkShakeService.getMilkShakeById(id);
    }

    @PutMapping("/milkShake/{orderId}/milkShake")
    public void updateMilkShake(@RequestBody MilkShakes milkShakes, @PathVariable(value = "orderId") Long orderId) {
        milkShakeService.updateMilkShakes(milkShakes, orderId);
    }

    @GetMapping("/milkShake/{orderId}/milkShake")
    public Iterable<MilkShakes> findMilkSHakeByOrderId(Long orderId){
        return milkShakeService.findMilkShakesByOrderId(orderId);
    }


    @DeleteMapping("/milk/{id}")
    public void deleteMilkShake(@PathVariable Long id) {
        milkShakeService.deleteMilkShakes(id);
    }
}
