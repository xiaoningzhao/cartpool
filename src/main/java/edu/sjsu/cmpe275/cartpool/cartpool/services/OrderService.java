package edu.sjsu.cmpe275.cartpool.cartpool.services;

import edu.sjsu.cmpe275.cartpool.cartpool.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    Order getOrder(Long id);
    List<Order> getOrdersByUser(Long userId);
    Order createOrder(Order order);
    List<Order> getPoolOrders(Long userId, Long poolId);
    List<Order> getPickupOrdersByUser(Long userId);
    List<Order> getDeliverOrdersByUser(Long userId);
    Order setPickupUser(Long orderId, Long userId);
    Order setOrderCheckout(Long orderId);
    Order setOrderPickup(Long orderId);
    Order setOrderDeliver(Long orderId);
}
