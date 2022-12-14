package com.juice.juice.repoistory;

import com.juice.juice.modules.MilkShakes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilkShakeRepo extends CrudRepository<MilkShakes,Long> {
    Iterable<MilkShakes> findMilkShakesByOrders(Long orderId);
}
