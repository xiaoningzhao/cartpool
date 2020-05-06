package edu.sjsu.cmpe275.cartpool.cartpool.repositories;

import edu.sjsu.cmpe275.cartpool.cartpool.models.CartPool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartPoolRepository extends JpaRepository<CartPool, Long> {
    boolean existsByPoolId(String poolId);
}
