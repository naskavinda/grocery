package com.grocery.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "item_size")
public class ItemSize {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double price;
    private double size;
    private String unit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private ItemColor itemColor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ItemColor getItemColor() {
        return itemColor;
    }

    public void setItemColor(ItemColor itemColor) {
        this.itemColor = itemColor;
    }
}
