package com.grocery.inventory.dto;

import java.util.List;

public class ItemColorDTO {

    private int id;
    private String color;
    private List<ItemSizeDTO> itemSizes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<ItemSizeDTO> getItemSizes() {
        return itemSizes;
    }

    public void setItemSizes(List<ItemSizeDTO> itemSizes) {
        this.itemSizes = itemSizes;
    }

    @Override
    public String toString() {
        return "ItemColorDTO{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", itemSizes=" + itemSizes +
                '}';
    }
}
