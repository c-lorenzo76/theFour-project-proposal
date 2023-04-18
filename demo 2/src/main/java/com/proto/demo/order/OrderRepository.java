package com.proto.demo.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CollinHarris
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
