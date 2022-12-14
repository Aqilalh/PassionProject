package com.juice.juice.repoistory;

import com.juice.juice.modules.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Orders,Long> {
    Iterable<Orders> findOrdersByCustomer(Long customerId);
}
