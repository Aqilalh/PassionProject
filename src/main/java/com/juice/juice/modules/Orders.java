package com.juice.juice.modules;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crepe_id")
    private Crepe crepe;

    @ManyToOne
    @JoinColumn(name = "milk_shakes_id")
    private MilkShakes milkShakes;

    @ManyToOne
    @JoinColumn(name = "smoothie_id")
    private Smoothie smoothie;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Double total;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Smoothie getSmoothie() {
        return smoothie;
    }

    public void setSmoothie(Smoothie smoothie) {
        this.smoothie = smoothie;
    }

    public MilkShakes getMilkShakes() {
        return milkShakes;
    }

    public void setMilkShakes(MilkShakes milkShakes) {
        this.milkShakes = milkShakes;
    }

    public Crepe getCrepe() {
        return crepe;
    }

    public void setCrepe(Crepe crepe) {
        this.crepe = crepe;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
