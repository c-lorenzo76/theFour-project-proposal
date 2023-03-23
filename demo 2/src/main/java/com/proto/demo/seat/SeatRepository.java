package com.proto.demo.seat;

import com.proto.demo.menu.*;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CollinHarris
 */
public interface SeatRepository extends JpaRepository<Seat,Long>{
    
}
