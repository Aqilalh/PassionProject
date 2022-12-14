package com.juice.juice.modules;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Crepe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;
    private ArrayList<String> fillings;

    private ArrayList<String> toppings;

    private double price;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public ArrayList<String> getFillings() {
        return fillings;
    }

    public void setFillings(ArrayList<String> fillings) {
        this.fillings = fillings;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
