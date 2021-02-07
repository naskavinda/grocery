package com.grocery.inventory.service;

import com.grocery.inventory.model.Item;
import com.grocery.inventory.repository.ItemRepository;
import com.grocery.inventory.repository.specification.ItemSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class ItemService extends CrudServiceImpl<Item, Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        super(itemRepository);
        this.itemRepository = itemRepository;
    }

    public void update(Item item) {
        this.save(item);
    }

    public List<Item> getItemsByGroupId(String groupId, Integer page, Integer size) {
        if (groupId == null) {
            return super.getAll(page, size);
        } else if (page >= 0) {
            return itemRepository.findAll(where(ItemSpecification.filterByGroupCode(groupId)), PageRequest.of(page, size)).getContent();
        } else {
            return itemRepository.findAll(where(ItemSpecification.filterByGroupCode(groupId)));
        }
    }
}
