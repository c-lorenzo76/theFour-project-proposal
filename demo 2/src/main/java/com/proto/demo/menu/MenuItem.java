package com.proto.demo.menu;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String[] ingredients;//ingredients in the item
    private int calories;//calories of the item
    private double cost;//cost of the item

    public MenuItem(String name,String[] ingredients,int calories,double cost){
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
        this.cost = cost;
    }
}