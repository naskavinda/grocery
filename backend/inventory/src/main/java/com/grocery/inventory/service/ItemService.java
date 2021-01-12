package com.grocery.inventory.service;

import com.grocery.inventory.model.Item;
import com.grocery.inventory.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends CrudServiceImpl<Item, Integer> {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        super(itemRepository);
        this.itemRepository = itemRepository;
    }

    public void update(Item item) {
        this.save(item);
    }
}
