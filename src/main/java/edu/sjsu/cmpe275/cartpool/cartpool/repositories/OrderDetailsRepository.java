package edu.sjsu.cmpe275.cartpool.cartpool.repositories;

import edu.sjsu.cmpe275.cartpool.cartpool.models.OrderDetails;
import edu.sjsu.cmpe275.cartpool.cartpool.models.OrderDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsId> {
}
