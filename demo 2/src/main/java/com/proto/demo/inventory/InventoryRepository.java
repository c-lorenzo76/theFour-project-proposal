package com.proto.demo.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CollinHarris
 */
public interface InventoryRepository extends JpaRepository<InventoryItem,Long>{
    
}
