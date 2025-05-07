package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.response.ItemResponse;
import com.example.FactoryManager.dto.response.PageResponse;
import com.example.FactoryManager.dto.response.UserResponse;
import com.example.FactoryManager.entity.Item;
import com.example.FactoryManager.entity.User;
import com.example.FactoryManager.mapper.ItemMapper;
import com.example.FactoryManager.repository.ItemRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public PageResponse<ItemResponse> getAllItems(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Item> itemPage = itemRepository.findAll(pageable);

        List<ItemResponse> itemResponses = new ArrayList<>();
        for (Item item : itemPage.getContent()) {
            ItemResponse itemResponse = itemMapper.toItemResponse(item);
            itemResponses.add(itemResponse);
        }

        PageResponse<ItemResponse> response = PageResponse.<ItemResponse>builder()
                .content(itemResponses)
                .totalPages(itemPage.getTotalPages())
                .totalElements(itemPage.getTotalElements())
                .build();

        return response;
    }

}
