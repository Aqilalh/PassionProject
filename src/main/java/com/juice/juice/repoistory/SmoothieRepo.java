package com.juice.juice.repoistory;

import com.juice.juice.modules.Smoothie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmoothieRepo extends CrudRepository<Smoothie,Long> {
    Iterable<Smoothie> findSmoothieByOrders(Long orderId);
}
