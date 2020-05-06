package edu.sjsu.cmpe275.cartpool.cartpool.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long productId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="brand")
    private String brand;

    @Column(name="category")
    private String category;

    @Column(name="unit")
    private String unit;

    @Column(name="price")
    private Double price;
}
