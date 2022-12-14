package com.juice.juice.modules;

import com.juice.juice.enums.SmoothieSizes;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Smoothie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;
    private ArrayList<String> fruits;

    private SmoothieSizes smoothieSizes;

    private double price;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SmoothieSizes getSmoothieSizes() {
        return smoothieSizes;
    }

    public void setSmoothieSizes(SmoothieSizes smoothieSizes) {
        this.smoothieSizes = smoothieSizes;
    }

    public ArrayList<String> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<String> fruits) {
        this.fruits = fruits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
