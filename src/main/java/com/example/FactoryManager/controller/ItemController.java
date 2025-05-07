package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.ItemResponse;
import com.example.FactoryManager.dto.response.PageResponse;
import com.example.FactoryManager.entity.Item;
import com.example.FactoryManager.service.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Item Controller")
public class ItemController {
    @Autowired
    ItemService itemService;

     @GetMapping("/all")
     ApiResponse<PageResponse<ItemResponse>> getAllItems(
             @RequestParam(value = "page", defaultValue = "0") int page,
             @RequestParam(value = "size", defaultValue = "10") int size
     ) {
         log.info("Fetching all items");
         PageResponse<ItemResponse> itemResponses = itemService.getAllItems(page, size);
         return ApiResponse.<PageResponse<ItemResponse>>builder()
                 .code(200)
                 .message("Success")
                 .result(itemResponses)
                 .build();
     }
}
