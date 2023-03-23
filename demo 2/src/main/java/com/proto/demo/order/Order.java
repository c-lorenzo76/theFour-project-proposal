package com.proto.demo.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Entity
@Table(name = "order")
@NoArgsConstructor
@Getter
@Setter
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private long id;
    private String name;//last name of customer
    private String status;//order status ex: taken,cooked,served,paid
    private double cost;//cost of the order
    private int party;//number of customers for this order
    private long counter;//time this order has been taking
    private long seatid;//id of the seat the customer is at
    
    public Order(String name, String status, double cost, int party, long counter, long seatid){
        this.name = name;
        this.status = status;
        this.cost = cost;
        this.party = party;
        this.counter = counter;
        this.seatid = seatid;
    }
}
