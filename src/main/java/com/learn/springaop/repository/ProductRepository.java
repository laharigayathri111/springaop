package com.learn.springaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.springaop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
