package com.grocery.inventory.model;


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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", rating=" + rating +
                ", numberOfRating=" + numberOfRating +
                ", itemColors=" + itemColors +
                '}';
    }
}
