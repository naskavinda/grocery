package com.grocery.inventory.service;

import com.grocery.inventory.model.ItemGroup;
import com.grocery.inventory.repository.ItemGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemGroupService extends CrudServiceImpl<ItemGroup, Integer> {

    public ItemGroupService(ItemGroupRepository itemGroupRepository) {
        super(itemGroupRepository);
    }
}
