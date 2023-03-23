package com.proto.demo.order;

import com.proto.demo.menu.*;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CollinHarris
 */
public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
