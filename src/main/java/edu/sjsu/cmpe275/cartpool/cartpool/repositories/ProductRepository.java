package edu.sjsu.cmpe275.cartpool.cartpool.repositories;

import edu.sjsu.cmpe275.cartpool.cartpool.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllBy(Pageable page);
}
