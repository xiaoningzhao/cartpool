package edu.sjsu.cmpe275.cartpool.cartpool.repositories;

import edu.sjsu.cmpe275.cartpool.cartpool.models.Product;
import edu.sjsu.cmpe275.cartpool.cartpool.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
