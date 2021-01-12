package com.grocery.inventory.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item_color")
public class ItemColor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String color;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Item item;

    @OneToMany(mappedBy = "itemColor", fetch = FetchType.LAZY)
    private List<ItemSize> itemSizes;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<ItemSize> getItemSizes() {
        return itemSizes;
    }

    public void setItemSizes(List<ItemSize> itemSizes) {
        this.itemSizes = itemSizes;
    }

//    @Override
//    public String toString() {
//        return "ItemColor{" +
//                "id='" + id + '\'' +
//                ", color='" + color + '\'' +
//                ", item=" + item +
//                '}';
//    }
}
