package com.grocery.inventory.repository.specification;

import com.grocery.inventory.model.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecification {

    private ItemSpecification() {
    }

    public static Specification<Item> filterByGroupCode(String groupCode) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("itemGroup").get("groupCode"), groupCode);
    }
}