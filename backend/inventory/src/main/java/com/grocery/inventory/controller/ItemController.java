package com.grocery.inventory.controller;

import com.grocery.inventory.dto.ItemColorDTO;
import com.grocery.inventory.dto.ItemDTO;
import com.grocery.inventory.dto.ItemSizeDTO;
import com.grocery.inventory.model.Item;
import com.grocery.inventory.model.ItemColor;
import com.grocery.inventory.model.ItemSize;
import com.grocery.inventory.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    @RolesAllowed({"ViewItem"})
    public ResponseEntity<List<ItemDTO>> getItems() {
        List<Item> items = itemService.getAll();
        List<ItemDTO> results = mapToItemDTO(items);
        return ResponseEntity.ok(results);
    }

    private List<ItemDTO> mapToItemDTO(List<Item> items) {
        List<ItemDTO> result = new ArrayList<>();
        for (Item item : items) {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setName(item.getName());
            itemDTO.setImagePath(item.getImagePath());
            itemDTO.setRating(item.getRating());
            itemDTO.setNumberOfRating(item.getNumberOfRating());
            List<ItemColorDTO> itemColors = new ArrayList<>();
            for (ItemColor itemColor : item.getItemColors()) {
                ItemColorDTO itemColorDTO = new ItemColorDTO();
                itemColorDTO.setId(itemColor.getId());
                itemColorDTO.setColor(itemColor.getColor());
                List<ItemSizeDTO> itemSizes = new ArrayList<>();
                for (ItemSize itemSize : itemColor.getItemSizes()) {
                    ItemSizeDTO itemSizeDTO = new ItemSizeDTO();
                    itemSizeDTO.setId(itemSize.getId());
                    itemSizeDTO.setSize(itemSize.getSize());
                    itemSizeDTO.setPrice(itemSize.getPrice());
                    itemSizeDTO.setUnit(itemSize.getUnit());
                    itemSizes.add(itemSizeDTO);
                }
                itemColorDTO.setItemSizes(itemSizes);
                itemColors.add(itemColorDTO);
            }
            itemDTO.setItemColors(itemColors);
            result.add(itemDTO);
        }
        return result;
    }

    @GetMapping("/{id}")
    @RolesAllowed({"ViewItem"})
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        return ResponseEntity.ok(itemService.getById(id));
    }

    @PostMapping()
    @RolesAllowed({"AddItem"})
    public ResponseEntity<Boolean> save(@RequestBody Item item) {
        itemService.save(item);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
}
