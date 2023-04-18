package com.proto.demo.order;

import com.proto.demo.order.Order.statustype;
import com.proto.demo.menu.MenuItem;
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
        return repo.findAll();
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
    public List<MenuItem> getOrderContents(long orderId){
        return repo.getReferenceById(orderId).getContents();
    }
    public statustype updateOrderStatus(long order){
        Order orderstat=repo.getReferenceById(order);
        switch(orderstat.getStatus()){
            case NOTSTARTED:
                orderstat.setStatus(Order.statustype.COOKING);
                return orderstat.getStatus();
                //break;
            case COOKING:
                orderstat.setStatus(Order.statustype.DONE);
                return orderstat.getStatus();
                //break;
            case DONE:
                orderstat.setStatus(Order.statustype.SERVED);
                return orderstat.getStatus();
                //break;
            default:
                return orderstat.getStatus();
        }
    }
    public String getOrderStatus(long orderId){
        return repo.getReferenceById(orderId).getStatus().status;
    }
}
