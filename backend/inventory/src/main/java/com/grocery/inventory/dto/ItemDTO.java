package com.grocery.inventory.dto;

import java.util.List;

public class ItemDTO {

    private int id;
    private String name;
    private String imagePath;
    private double rating;
    private int numberOfRating;
    private double minPrice;
    private double maxPrice;
    private List<ItemColorDTO> itemColors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberOfRating() {
        return numberOfRating;
    }

    public void setNumberOfRating(int numberOfRating) {
        this.numberOfRating = numberOfRating;
    }

    public List<ItemColorDTO> getItemColors() {
        return itemColors;
    }

    public void setItemColors(List<ItemColorDTO> itemColors) {
        this.itemColors = itemColors;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", rating=" + rating +
                ", numberOfRating=" + numberOfRating +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", itemColors=" + itemColors +
                '}';
    }
}
