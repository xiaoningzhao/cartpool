package edu.sjsu.cmpe275.cartpool.cartpool.models;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class OrderDetailsId implements Serializable {

    @Column(name="order_id")
    private Long orderId;

    @Column(name="product_id")
    private Long productId;
}
