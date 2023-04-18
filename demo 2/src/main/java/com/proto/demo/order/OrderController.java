package com.proto.demo.order;

import com.proto.demo.menu.MenuItem;
import com.proto.demo.order.Order.statustype;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author CollinHarris
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    @GetMapping("/all")
    public String getOrders(Model model) {
        model.addAttribute("orderList", orderService.getAllOrders());
        return "order/chef-view";
    }
    @GetMapping("/id={orderId}")
    public String getOrder(@PathVariable long orderId, Model model) {
        model.addAttribute("order", orderService.getOrder(orderId));
        return "redirect:/order/all";
    }
    @GetMapping("/delete/id={orderId}")
    public String deleteOrder(@PathVariable long orderId, Model model) {
        orderService.deleteOrder(orderId);
        return "redirect:/order/all";
    }
    @PostMapping("/create")
    public String createOrder(Order order) {

        orderService.saveOrder(order);
        return "redirect:/order/all";
    }
    @PostMapping("/update")
    public String upateOrder(Order order) {
        orderService.saveOrder(order);
        return "redirect:/order/all";
    }
    @GetMapping("/status")
    public String getStatuses(@PathVariable long orderId, Model model){
        model.addAttribute("statuses", orderService.getOrderStatus(orderId));
        //orderService.updateOrderStatus(orderId);
        return "redirect:/order/all";
    }
    @GetMapping("/new-order")
    public String newOrderForm(Model model) {
        return "redirect:/order/all";
    }
    @GetMapping("/update/id={orderId}")
    public String updateOrderForm(@PathVariable long orderId, Model model) {
        model.addAttribute("order", orderService.getOrder(orderId));
        return "order/update-stat";
    }
}

