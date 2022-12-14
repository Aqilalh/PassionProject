package com.juice.juice.controller;

import com.juice.juice.modules.Crepe;
import com.juice.juice.modules.Smoothie;
import com.juice.juice.service.SmoothieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SmoothieController {

    @Autowired
    private SmoothieService smoothieService;


    @GetMapping("/smoothie")
    public ResponseEntity<Iterable<Smoothie>> getAllSmoothie() {
        return smoothieService.getAllSmoothie();
    }

    @PostMapping("/smoothie/{orderId}/smoothie")
    public void createSmoothie(@PathVariable(value = "orderId") Long orderId, @RequestBody Smoothie smoothie) {
        smoothieService.createSmoothie(smoothie, orderId);
    }

    @GetMapping("/smoothie/{id}/smoothie")
    public ResponseEntity<?> getSmoothieById(@PathVariable Long id) {
        return smoothieService.getSmoothieById(id);
    }

    @PutMapping("/smoothie/{orderId}/smoothie")
    public void updateSmoothie(@RequestBody Smoothie smoothie, @PathVariable(value = "orderId") Long orderId) {
        smoothieService.updateSmoothie(smoothie, orderId);
    }

    @GetMapping("/smoothie/{orderId}/smoothie")
    public Iterable<Smoothie> findSmoothieByOrderId(Long orderId){
        return smoothieService.findSmoothieByOrderId(orderId);
    }


    @DeleteMapping("/smoothie/{id}")
    public void deleteSmoothie(@PathVariable Long id) {
        smoothieService.deleteSmoothie(id);
    }
}
