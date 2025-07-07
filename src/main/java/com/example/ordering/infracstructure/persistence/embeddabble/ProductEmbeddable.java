package com.example.ordering.infracstructure.persistence.embeddabble;

import com.example.ordering.models.cart.Product;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductEmbeddable {
    private String name;

    public String toDomain() {
        return name;
    }

    public static ProductEmbeddable from(Product product) {
        ProductEmbeddable embeddable = new ProductEmbeddable();
        embeddable.name = product.item();
        return embeddable;
    }
}
