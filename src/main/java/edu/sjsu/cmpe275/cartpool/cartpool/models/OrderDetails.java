package edu.sjsu.cmpe275.cartpool.cartpool.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="order_details")
@IdClass(OrderDetailsId.class)
public class OrderDetails {

    @Id
    private Long orderId;

    @Id
    private Long productId;

//    @EmbeddedId
//    OrderDetailsId id;

    //@Id
//    @MapsId("orderId")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    //@Id
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="tax_fee")
    private Double taxFee;

    @Column(name="price")
    private Double price;
}
