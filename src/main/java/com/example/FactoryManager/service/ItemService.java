package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.response.ItemResponse;
import com.example.FactoryManager.dto.response.UserResponse;
import com.example.FactoryManager.entity.Item;
import com.example.FactoryManager.entity.User;
import com.example.FactoryManager.mapper.ItemMapper;
import com.example.FactoryManager.repository.ItemRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ItemService {
    ItemRepository itemRepository;

    ItemMapper itemMapper;

    public List<ItemResponse> getAllItems() {
        List<ItemResponse> itemResponses = new ArrayList<>();

        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            ItemResponse itemResponse = itemMapper.toItemResponse(item);
            itemResponses.add(itemResponse);
        }
        return itemResponses;
    }

}
