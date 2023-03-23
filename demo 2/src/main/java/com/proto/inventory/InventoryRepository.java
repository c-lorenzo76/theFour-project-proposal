package com.proto.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CollinHarris
 */
public interface InventoryRepository extends JpaRepository<Inventory,Long>{
    
}
