package com.grocery.inventory.service;

import com.grocery.inventory.model.Item;
import com.grocery.inventory.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Item> getItemsByGroupId(String groupId) {
        if (groupId == null) {
            return super.getAll();
        } else {
            return itemRepository.findItemsByItemGroupGroupCode(groupId);
        }
    }
}
