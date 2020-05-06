package edu.sjsu.cmpe275.cartpool.cartpool.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="inventory")
public class Inventory {

    @EmbeddedId
    private InventoryId id;

    @Column(name="quantity")
    private Integer quantity;


}
