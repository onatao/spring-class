package com.devnatao.rest.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devnatao.rest.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID>{
}
