package com.proto.inventory;

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
@Table(name = "inventory")
@NoArgsConstructor
@Getter
@Setter
public class InventoryItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;//name of item
    private int ammount;//ammount of item in stock
    private double price;//price to buy each item 
    
    public InventoryItem(String name,int ammount, double price){
        this.name = name;
        this.ammount = ammount;
        this.price = price;
    }
}
