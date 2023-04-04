package com.proto.demo.order;

import com.proto.demo.seat.Seat;
import com.proto.demo.menu.MenuItem;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@AllArgsConstructor
@Entity
@Table(name = "order")
@NoArgsConstructor
@Getter
@Setter



public class Order {
    public enum statustype{
        NOTSTARTED("Not Started"),
        COOKING("Cooking"),
        DONE("Done"),
        SERVED("Served");
        
        public final String status;
        
        private statustype(String status){
            this.status = status;
        }
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private long id;
    private String name;//last name of customer
    private statustype  status;//order status ex: taken,cooked,served,paid
    private double cost;//cost of the order
    private int party;//number of customers for this order
    private long counter;//time this order has been taking
    private long seat;//id of the seat the customer is at
    
    @OneToMany(mappedBy = "name")
    private  LinkedList<MenuItem>  contents;
    
    
    public Order(String name, double cost, int party, long counter, long seat ,LinkedList<MenuItem> contents){
        this.name = name;
        this.status = statustype.NOTSTARTED;
        this.cost = cost;
        this.party = party;
        this.counter = counter;
        this.seat = seat;
        this.contents = contents;
    }
}
