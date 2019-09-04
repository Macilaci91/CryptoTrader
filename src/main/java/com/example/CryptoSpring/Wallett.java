package com.example.CryptoSpring;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Wallett {
    @Id
    String name;
    float quantity;
    float bought;

    public Wallett(){}

    public Wallett(String name, float quantity, float bought){
        this.name = name;
        this.quantity = quantity;
        this.bought = bought;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public double getBought() {
        return bought;
    }

    public void setBought(float bought) {
        this.bought = bought;
    }

    @Override
    public String toString() {
        return "Wallett{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", boughtValue=" + bought +
                '}';
    }
}
