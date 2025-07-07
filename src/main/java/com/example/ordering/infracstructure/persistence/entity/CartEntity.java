package com.example.ordering.infracstructure.persistence.entity;

import com.example.ordering.infracstructure.persistence.embeddabble.ProductEmbeddable;
import com.example.ordering.models.cart.Address;
import com.example.ordering.models.cart.CartStatus;
import com.example.ordering.models.cart.Product;
import com.example.ordering.models.cart.Price;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carts")
public class CartEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @ElementCollection
    @CollectionTable(name = "cart_products", joinColumns = @JoinColumn(name = "cart_id"))
    private List<ProductEmbeddable> products;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CartStatus status;

    @Embedded
    private Address shippingAddress;

    @Embedded
    private Price totalPrice;

    protected CartEntity() {
    }

    public CartEntity(Long id, List<Product> products, CartStatus status, Address shippingAddress, Price totalPrice) {
        this.id = id;
        this.products = products.stream()
                .map(ProductEmbeddable::from)
                .toList();
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products.stream()
                .map(p -> new Product(p.toDomain()))
                .toList();
    }

    public void setProducts(List<Product> products) {
        this.products = products.stream()
                .map(ProductEmbeddable::from)
                .toList();
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Price totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity cartEntity = (CartEntity) o;
        return Objects.equals(id, cartEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
