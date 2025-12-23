package com.learn.springaop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.springaop.entity.Product;
import com.learn.springaop.repository.ProductRepository;

@Service

public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {

		this.productRepository = productRepository;

	}

	@Override

	public Product save(Product product) {

		return productRepository.save(product);

	}

	@Override

	public List<Product> getAll() {

		return productRepository.findAll();

	}

	@Override

	public Product getById(Long id) {

		return productRepository.findById(id)

				.orElseThrow(() -> new RuntimeException("Product not found"));

	}

	@Override

	public void delete(Long id) {

		productRepository.deleteById(id);

	}

}
