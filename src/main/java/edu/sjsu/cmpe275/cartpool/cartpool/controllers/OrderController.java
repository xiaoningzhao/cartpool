package edu.sjsu.cmpe275.cartpool.cartpool.controllers;

import edu.sjsu.cmpe275.cartpool.cartpool.models.Order;
import edu.sjsu.cmpe275.cartpool.cartpool.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    /**
     * Retrieve all orders
     * /api/order
     */
    @GetMapping("")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    /**
     * Retrieve orders by user
     * /api/order/user/{id}
     */
    @GetMapping("/user/{id}")
    public List<Order> getOrdersByUser(@PathVariable("id") @NotNull Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    /**
     * Retrieve available orders in a pool by user
     * /api/order/pickup/pool
     */
    @GetMapping("/pickup/pool")
    public List<Order> getPoolOrders(@RequestParam(value = "userId") @NotNull Long userId,
                                     @RequestParam(value = "poolId") @NotNull Long poolId) {
        return orderService.getPoolOrders(userId, poolId);
    }

    /**
     * Retrieve pickup orders by user
     * /api/order/pickup/user/{id}
     */
    @GetMapping("/pickup/user/{id}")
    public List<Order> getPickupOrdersByUser(@PathVariable("id") @NotNull Long userId) {
        return orderService.getPickupOrdersByUser(userId);
    }

    /**
     * Retrieve deliver orders by user
     * /api/order/deliver/user/{id}
     */
    @GetMapping("/deliver/user/{id}")
    public List<Order> getDeliverOrdersByUser(@PathVariable("id") @NotNull Long userId) {
        return orderService.getDeliverOrdersByUser(userId);
    }

    /**
     * Retrieve order by id
     * /api/order/{id}
     */
    @GetMapping("{id}")
    public Order getOrder(@PathVariable("id") @NotNull Long id) {
        return null;
    }

    /**
     * Add an order
     * /api/order/
     */
    @PostMapping("")
    public Order createOrder(@RequestBody Order order) {
        System.out.println(order);
        return orderService.createOrder(order);
    }

    /**
     * Update an order
     * /api/order/
     */
    @PutMapping("{id}")
    public Order updateOrder(@PathVariable("id") Long id) {
        return null;
    }

    /**
     * Set pick up user for an order
     * /api/order/pickup/pickupuser/{id}
     */
    @PutMapping("/pickup/pickupuser/{orderId}/{userId}")
    public Order setPickupUser(@PathVariable("orderId") Long orderId, @PathVariable("userId") Long userId) {
        return orderService.setPickupUser(orderId,userId);
    }

    /**
     * Set pick up user for an order batch
     * /api/order/pickup/pickupuser/batch
     */
    @Transactional
    @PutMapping("/pickup/pickupuser/batch/{userId}")
    public List<Order> setPickupUserBatch(@PathVariable("userId") Long userId,
                                    @RequestBody List<Long> orders) {
        List<Order> result = new ArrayList<>();
        for (Long order:orders) {
            result.add(orderService.setPickupUser(order,userId));
        }
        return result;
    }

    /**
     * Checkout an order
     * /api/order/checkout/{id}
     */
    @PutMapping("/checkout/{id}")
    public Order setOrderCheckout(@PathVariable("id") Long id) {
        return orderService.setOrderCheckout(id);
    }

    /**
     * Pickup an order
     * /api/order/pickup/{id}
     */
    @PutMapping("/pickup/{id}")
    public Order setOrderPickup(@PathVariable("id") Long id) {
        return orderService.setOrderPickup(id);
    }

    /**
     * Deliver an order
     * /api/order/deliver/{id}
     */
    @PutMapping("/deliver/{id}")
    public Order setOrderDeliver(@PathVariable("id") Long id) {
        return orderService.setOrderDeliver(id);
    }

    /**
     * Delete an order
     * /api/order/
     */
    @DeleteMapping("{id}")
    public Order deleteOrder(@PathVariable("id") Long id) {
        return null;
    }


}
