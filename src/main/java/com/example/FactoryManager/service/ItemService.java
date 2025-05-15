package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.request.ItemFilterRequest;
import com.example.FactoryManager.dto.response.ItemResponse;
import com.example.FactoryManager.dto.response.PageResponse;
import com.example.FactoryManager.entity.File;
import com.example.FactoryManager.entity.Item;
import com.example.FactoryManager.mapper.ItemMapper;
import com.example.FactoryManager.repository.ItemRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ItemService {
    ItemRepository itemRepository;

    ItemMapper itemMapper;

    @PersistenceContext
    EntityManager entityManager;

    @PreAuthorize("hasAuthority('GET_ALL_ITEM')")
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

    @PreAuthorize("hasAuthority('FILTER_ITEM')")
    public PageResponse<ItemResponse> filterItems(ItemFilterRequest request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);
        Root<Item> root = cq.from(Item.class);

        List<Predicate> predicates = new ArrayList<>();
        Map<String, String> filters = request.getFilters();

        Join<Item, File> fileJoin = null;

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (value == null || value.isEmpty()) continue;

            switch (key) {
                case "fileName":
                    if (fileJoin == null) {
                        fileJoin = root.join("file", JoinType.LEFT);
                    }
                    predicates.add(cb.equal(fileJoin.get("fileName"), value));
                    break;

                case "jobId":
                    predicates.add(cb.equal(root.get(key), UUID.fromString(value)));
                    break;

                case "readyQty":
                case "deliveredQty":
                    predicates.add(cb.equal(root.get(key), Integer.parseInt(value)));
                    break;

                default:
                    predicates.add(cb.equal(root.get(key), value));
            }
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));
        List<Item> items = entityManager.createQuery(cq).getResultList();
        
        return PageResponse.<ItemResponse>builder()
                .content(items.stream()
                        .map(itemMapper::toItemResponse)
                        .collect(Collectors.toList()))
                .totalPages(1)
                .totalElements(items.size())
                .build();
    }
}
