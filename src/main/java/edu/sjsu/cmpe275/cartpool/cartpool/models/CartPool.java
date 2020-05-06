package edu.sjsu.cmpe275.cartpool.cartpool.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="cart_pool")
public class CartPool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="pool_id")
    private String poolId;

    @Column(name="name")
    private String name;

    @Column(name="neighborhood")
    private String neighborhood;

    @Column(name="description")
    private String description;

    @Column(name="zip")
    private String zip;

    @Column(name="leader")
    private Long leader;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="creation_time")
    private LocalDateTime creationTime = LocalDateTime.now();


}
