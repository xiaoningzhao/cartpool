package edu.sjsu.cmpe275.cartpool.cartpool.services;

import edu.sjsu.cmpe275.cartpool.cartpool.exceptions.NotFoundException;
import edu.sjsu.cmpe275.cartpool.cartpool.models.Product;
import edu.sjsu.cmpe275.cartpool.cartpool.models.Store;
import edu.sjsu.cmpe275.cartpool.cartpool.repositories.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    @Override
    public List<Store> getStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store getStore(Long id) {
        if(storeRepository.findById(id).isPresent()) {
            return storeRepository.findById(id).get();
        }else{
            throw new NotFoundException("Cannot find store.");
        }
    }

    @Override
    public List<Product> getProducts(Long id) {
        Store store = getStore(id);
        List<Product> products = store.getProducts();
        return products;
    }
}
