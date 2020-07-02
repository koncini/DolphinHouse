package com.dolphinhouse.dolphinhouse.models.services;

import com.dolphinhouse.dolphinhouse.models.domain.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
