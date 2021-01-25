package com.grocery.inventory.controller;

import com.grocery.inventory.model.Item;
import com.grocery.inventory.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
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
    public ResponseEntity<List<Item>> getItems() {
        List<Item> items = itemService.getAll();
        return ResponseEntity.ok(items);
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
