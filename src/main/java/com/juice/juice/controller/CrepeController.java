package com.juice.juice.controller;

import com.juice.juice.modules.Crepe;
import com.juice.juice.service.CrepeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrepeController {

    @Autowired
    private CrepeService crepeService;

    @GetMapping("/crepe")
    public ResponseEntity<Iterable<Crepe>> getAllCrepe() {
        return crepeService.getAllCrepes();
    }

    @PostMapping("/crepe/{orderId}/crepe")
    public void createCrepe(@PathVariable(value = "orderId") Long orderId, @RequestBody Crepe crepe) {
        crepeService.createCrepe(crepe, orderId);
    }

    @GetMapping("/crepe/{id}/crepe")
    public ResponseEntity<?> getCrepeById(@PathVariable Long id) {
        return crepeService.getCrepeById(id);
    }

    @PutMapping("/crepe/{orderId}/crepe")
    public void updateCrepe(@RequestBody Crepe crepe, @PathVariable(value = "orderId") Long orderId) {
        crepeService.updateCrepe(crepe, orderId);
    }

    @GetMapping("/crepe/{orderId}/crepe")
    public Iterable<Crepe> findCrepeByOrderId(Long orderId){
        return crepeService.findCrepeByOrderId(orderId);
    }


    @DeleteMapping("/crepe/{id}")
    public void deleteCrepe(@PathVariable Long id) {
        crepeService.deleteCrepe(id);
    }
}
