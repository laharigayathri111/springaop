package com.learn.springaop.service;

import java.util.List;

import com.learn.springaop.entity.Product;

public interface ProductService {

	Product save(Product product);

	List<Product> getAll();

	Product getById(Long id);

	void delete(Long id);

}
