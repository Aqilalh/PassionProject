package com.juice.juice.modules;

import com.juice.juice.enums.MilkShakesSizes;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class MilkShakes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders order;
    private MilkShakesSizes milkShakesSizes;

    private ArrayList<String> toppings;

    private String iceCream;

    private double price;

    public Orders getOrders() {
        return order;
    }

    public void setOrders(Orders orders) {
        this.order = orders;
    }

    public MilkShakesSizes getMilkShakesSizes() {
        return milkShakesSizes;
    }

    public void setMilkShakesSizes(MilkShakesSizes milkShakesSizes) {
        this.milkShakesSizes = milkShakesSizes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public String getIceCream() {
        return iceCream;
    }

    public void setIceCream(String iceCream) {
        this.iceCream = iceCream;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
