package com.example.ordering.infracstructure.persistence.repository;


import com.example.ordering.infracstructure.persistence.entity.CartEntity;
import com.example.ordering.models.cart.CartId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaCartRepository extends JpaRepository<CartEntity, CartId> {
}
