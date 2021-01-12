package com.grocery.inventory.dto;

public class ItemSizeDTO {

    private int id;
    private double price;
    private double size;
    private String unit;

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

    @Override
    public String toString() {
        return "ItemSizeDTO{" +
                "id=" + id +
                ", price=" + price +
                ", size=" + size +
                ", unit='" + unit + '\'' +
                '}';
    }
}
