package com.proto.demo.menu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author CollinHarris
 */
@Service
public class MenuService {
    
    @Autowired
    private MenuRepository repo;

    public List<MenuItem> getAllMenuItems(){
        return repo.findAll(); 
    }
    
    public MenuItem getMenuItem(long MenuItemId){
        return repo.getReferenceById(MenuItemId);
    }
    public void deleteMenuItem(long MenuItemId){
        repo.deleteById(MenuItemId);
    }
    public void saveMenuItem(MenuItem menu){
        repo.save(menu);
    }
}
