package edu.sjsu.cmpe275.cartpool.cartpool.services;

import edu.sjsu.cmpe275.cartpool.cartpool.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService{
    private final InventoryRepository inventoryRepository;
}
