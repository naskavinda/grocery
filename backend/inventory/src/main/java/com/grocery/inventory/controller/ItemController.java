package com.grocery.inventory.controller;

import com.grocery.inventory.model.Item;
import com.grocery.inventory.model.ItemGroup;
import com.grocery.inventory.service.ItemGroupService;
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
    private final ItemGroupService itemGroupService;

    public ItemController(ItemService itemService,
                          ItemGroupService itemGroupService) {
        this.itemService = itemService;
        this.itemGroupService = itemGroupService;
    }

    @GetMapping("")
    @RolesAllowed({"ViewItem"})
    public ResponseEntity<List<Item>> getItems(@RequestParam(name = "groupId", required = false) String groupId) {
        List<Item> items = itemService.getItemsByGroupId(groupId);
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

    @GetMapping("/item-groups")
    @RolesAllowed({"ViewItem"})
    public ResponseEntity<List<ItemGroup>> getItemGroups() {
        List<ItemGroup> items = itemGroupService.getAll();
        return ResponseEntity.ok(items);
    }
}
