package com.proto.demo.inventory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author CollinHarris
 */
@Service
public class InventoryService {
    @Autowired
    private InventoryRepository repo;

    public List<InventoryItem> getAllInventoryItems(){
        return repo.findAll(); 
    }
    
    public InventoryItem getInventoryItem(long InventoryItemId){
        return repo.getReferenceById(InventoryItemId);
    }
    public void deleteInventoryItem(long InventoryItemId){
        repo.deleteById(InventoryItemId);
    }
    public void saveInventoryItem(InventoryItem inventory){
        repo.save(inventory);
    }
}
