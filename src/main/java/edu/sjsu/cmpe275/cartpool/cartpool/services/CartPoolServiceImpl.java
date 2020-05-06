package edu.sjsu.cmpe275.cartpool.cartpool.services;

import edu.sjsu.cmpe275.cartpool.cartpool.exceptions.ConflictException;
import edu.sjsu.cmpe275.cartpool.cartpool.exceptions.NotFoundException;
import edu.sjsu.cmpe275.cartpool.cartpool.models.CartPool;
import edu.sjsu.cmpe275.cartpool.cartpool.repositories.CartPoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CartPoolServiceImpl implements CartPoolService {
    private final CartPoolRepository cartPoolRepository;
    private final UserService userService;

    @Override
    public List<CartPool> getCartPools() {
        return cartPoolRepository.findAll();
    }

    @Override
    public CartPool getCartPool(Long id) {
        if(cartPoolRepository.findById(id).isPresent()){
            return cartPoolRepository.findById(id).get();
        }else {
            throw new NotFoundException("Cannot find cart pool");
        }
    }

    @Transactional
    @Override
    public CartPool createCartPool(CartPool cartPool) {
        if(cartPoolRepository.existsByPoolId(cartPool.getPoolId())){
            throw new ConflictException("Pool ID already exist");
        }else{
            CartPool newCartPool = cartPoolRepository.save(cartPool);

            userService.joinCartPool(newCartPool.getLeader(), newCartPool.getId());

            return newCartPool;
        }
    }
}
