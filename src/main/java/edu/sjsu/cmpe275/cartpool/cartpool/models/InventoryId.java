package edu.sjsu.cmpe275.cartpool.cartpool.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class InventoryId implements Serializable {

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "product_id")
    private Long productId;
}
