package com.example.ordering.adapters.out;

import com.example.ordering.infracstructure.persistence.entity.CartEntity;
import com.example.ordering.infracstructure.persistence.repository.JpaCartRepository;
import com.example.ordering.models.Cart;
import com.example.ordering.models.cart.CartId;
import com.example.ordering.port.out.CartPersistencePort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaCartAdapter implements CartPersistencePort {

    private final JpaCartRepository repo;

    public JpaCartAdapter(JpaCartRepository jpaCartRepository) {
        this.repo = jpaCartRepository;
    }

    @Override
    public Optional<Cart> findById(CartId cartId) {
        return repo.findById(cartId)
                .map(entity -> new Cart(
                        new CartId(entity.getId()),
                        entity.getProducts(),
                        entity.getStatus(),
                        entity.getShippingAddress(),
                        entity.getTotalPrice()
                ));
    }

    @Override
    public void save(Cart cart) {
        CartEntity entity = new CartEntity(
                cart.id().id(),
                cart.products(),
                cart.status(),
                cart.shippingAddress(),
                cart.totalPrice()
        );
        repo.save(entity);
    }

    @Override
    public void delete(CartId cartId) {
        repo.deleteById(cartId);
    }
}
