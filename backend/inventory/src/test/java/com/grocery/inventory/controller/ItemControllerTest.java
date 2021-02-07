package com.grocery.inventory.controller;

import com.grocery.inventory.model.Item;
import com.grocery.inventory.service.ItemGroupService;
import com.grocery.inventory.service.ItemService;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(ItemController.class)
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource("classpath:application.yml")
@WithMockUser(username = "user")
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @MockBean
    private ItemGroupService itemGroupService;

    @Test
    void should_Return200Status_WhenUserHavePermission() throws Exception {
        this.mockMvc
                .perform(get("/api/items"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void should_ReturnItems_WhenItemExist() throws Exception {
        Item item = new Item();
        item.setId(1);
        item.setName("item 1");
        item.setMinPrice(100);
        item.setMaxPrice(1000);
        Item item2 = new Item();
        item2.setId(2);
        item2.setName("item 2");
        item2.setMinPrice(200);
        item2.setMaxPrice(600);
        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        Mockito.when(itemService.getItemsByGroupId(null, -1, 5)).thenReturn(items);
        this.mockMvc
                .perform(get("/api/items"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("item 1"));
    }

    @Test
    void should_ReturnItem_WhenItemExist() throws Exception {
        Item item = new Item();
        item.setId(1);
        item.setName("item 1");
        item.setMinPrice(100);
        item.setMaxPrice(1000);
        Mockito.when(itemService.getById(1)).thenReturn(item);
        this.mockMvc
                .perform(get("/api/items/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("item 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.maxPrice").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rating").value(0));
    }

    @Test
    void should_ReturnTrue_WhenItemSavedSuccessfully() throws Exception {
        Item item = new Item();
        item.setId(1);
        item.setName("item 1");
        item.setMinPrice(100);
        item.setMaxPrice(1000);
        this.mockMvc
                .perform(post("/api/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"item 1\",\"imagePath\":null,\"rating\":0.0,\"numberOfRating\":0,\"minPrice\":100.0,\"maxPrice\":1000.0,\"itemGroup\":null,\"itemColors\":null}")
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(true));
    }

}