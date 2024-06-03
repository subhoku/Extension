package com.ext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ext.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
 
}
