package com.grocery.inventory.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String imagePath;
    private double rating;
    private int numberOfRating;
    private double minPrice;
    private double maxPrice;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private ItemGroup itemGroup;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<ItemColor> itemColors;

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

    public List<ItemColor> getItemColors() {
        return itemColors;
    }

    public void setItemColors(List<ItemColor> itemColors) {
        this.itemColors = itemColors;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(ItemGroup itemGroups) {
        this.itemGroup = itemGroups;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", rating=" + rating +
                ", numberOfRating=" + numberOfRating +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", itemGroups=" + itemGroup +
                '}';
    }
}
