package com.proto.demo.menu;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CollinHarris
 */
public interface MenuRepository extends JpaRepository<MenuItem,Long>{
    
}
