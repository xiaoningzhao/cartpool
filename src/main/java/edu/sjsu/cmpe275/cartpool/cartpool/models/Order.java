package edu.sjsu.cmpe275.cartpool.cartpool.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="pool_id")
    private Long poolId;

    @Column(name="store_id")
    private Long storeId;

    @JsonIgnoreProperties({"order"})
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private List<OrderDetails> orderDetails;

    @Column(name="amount")
    private Double amount;

    @Column(name="status")
    private String status;

    @Column(name="pickup_method")
    private String pickupMethod;

    @Column(name="pickup_user")
    private Long pickupUser;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="zip")
    private String zip;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="creation_time")
    private LocalDateTime creationTime = LocalDateTime.now();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="checkout_time")
    private LocalDateTime checkoutTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="due_time")
    private LocalDateTime dueTime = creationTime.plusDays(2);

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="pickup_time")
    private LocalDateTime pickupTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="delivered_time")
    private LocalDateTime deliveredTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="update_time")
    private LocalDateTime updateTime;
}
