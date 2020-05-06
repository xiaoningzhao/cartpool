package edu.sjsu.cmpe275.cartpool.cartpool.services;

import edu.sjsu.cmpe275.cartpool.cartpool.repositories.OrderDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{
    private final OrderDetailsRepository orderDetailsRepository;
}
