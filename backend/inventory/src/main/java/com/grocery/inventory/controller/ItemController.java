package com.grocery.inventory.controller;

import com.grocery.inventory.model.Item;
import com.grocery.inventory.model.ItemGroup;
import com.grocery.inventory.service.ItemGroupService;
import com.grocery.inventory.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static com.grocery.inventory.Utils.CommonFunction.CORRELATION_ID;
import static com.grocery.inventory.Utils.CommonFunction.correlationId;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/items")
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);


    private final ItemService itemService;
    private final ItemGroupService itemGroupService;

    public ItemController(ItemService itemService,
                          ItemGroupService itemGroupService) {
        this.itemService = itemService;
        this.itemGroupService = itemGroupService;
    }

    @GetMapping("")
    @RolesAllowed({"ViewItem"})
    public ResponseEntity<List<Item>> getItems(
            @RequestParam(name = "groupId", required = false) String groupId,
            @RequestParam(name = "page", required = false, defaultValue = "-1") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
        try {
            MDC.put(CORRELATION_ID, correlationId());
            LOGGER.info("Item details get request started... groupId [{}] page [{}] size [{}]", groupId, page, size);
            List<Item> items = itemService.getItemsByGroupId(groupId, page, size);
            LOGGER.info("Item details get response item count [{}]", items.size());
            return ResponseEntity.ok(items);
        } finally {
            MDC.clear();
        }
    }

    @GetMapping("/{id}")
    @RolesAllowed({"ViewItem"})
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        try {
            MDC.put(CORRELATION_ID, correlationId());
            LOGGER.info("Get Item by id [{}] request started...", id);
            return ResponseEntity.ok(itemService.getById(id));
        } finally {
            MDC.clear();
        }
    }

    @PostMapping()
    @RolesAllowed({"AddItem"})
    public ResponseEntity<Boolean> save(@RequestBody Item item) {
        try {
            MDC.put(CORRELATION_ID, correlationId());
            LOGGER.info("Save Item [{}] request started...", item);
            itemService.save(item);
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } finally {
            MDC.clear();
        }
    }

    @GetMapping("/item-groups")
    @RolesAllowed({"ViewItem"})
    public ResponseEntity<List<ItemGroup>> getItemGroups(
            @RequestParam(name = "page", required = false, defaultValue = "-1") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "2") Integer size) {
        try {
            MDC.put(CORRELATION_ID, correlationId());
            LOGGER.info("Item groups get request started... page [{}] size [{}]", page, size);
            List<ItemGroup> items = itemGroupService.getAll(page, size);
            LOGGER.info("Item groups get response item count [{}]", items.size());
            return ResponseEntity.ok(items);
        } finally {
            MDC.clear();
        }
    }
}

