package com.juice.juice.repoistory;

import com.juice.juice.modules.Crepe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrepeRepo extends CrudRepository<Crepe,Long> {


    Iterable<Crepe> findCrepeByOrders(Long orderId);
}
