package com.proto.demo.order;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CollinHarris
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repo;

    public List<Order> getAllOrders(){
        return repo.findAll();//question how would i get a specifi order 
    }
    
    public Order getOrder(long orderId){
        return repo.getReferenceById(orderId);
    }
    public void deleteOrder(long orderId){
        repo.deleteById(orderId);
    }
    public void saveOrder(Order order){
        repo.save(order);
    }
}
