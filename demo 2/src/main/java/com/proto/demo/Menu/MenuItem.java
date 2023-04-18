package com.proto.demo.menu;

import com.proto.demo.order.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@AllArgsConstructor
@Entity
@Table(name = "menu")
@NoArgsConstructor
@Getter
@Setter
public class MenuItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;//name of menu item
    //private LinkedList<String> ingredients;//ingredients in the item
    private int calories;//calories of the item
    private double cost;//cost of the item 
    
    @ManyToMany//(mappedBy = "contents")
    private  List<Order>  orders;

    public MenuItem(String name,int calories,double cost){
        this.name = name;
        //this.ingredients = ingredients;
        this.calories = calories;
        this.cost = cost;
    }
    @Override
    public String toString(){
        return name;
    }
}