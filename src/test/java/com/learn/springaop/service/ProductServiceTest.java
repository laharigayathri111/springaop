package com.learn.springaop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.learn.springaop.entity.Product;
import com.learn.springaop.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)

class ProductServiceTest {

	@Mock

	private ProductRepository productRepository;

	@InjectMocks

	private ProductServiceImpl productService;

	// ✅ UNIT TEST 1: save

	@Test

	void testSaveProduct() {

		Product product = new Product(1L, "Mobile", 15000);

		when(productRepository.save(product)).thenReturn(product);

		Product saved = productService.save(product);

		assertNotNull(saved);

		assertEquals("Mobile", saved.getName());

	}

	// ✅ UNIT TEST 2: get all

	@Test

	void testGetAllProducts() {

		List<Product> products = List.of(

				new Product(1L, "Laptop", 60000),

				new Product(2L, "Headset", 2000)

		);

		when(productRepository.findAll()).thenReturn(products);

		List<Product> result = productService.getAll();

		assertEquals(2, result.size());

	}

	// ✅ UNIT TEST 3: get by id

	@Test

	void testGetProductById() {

		Product product = new Product(1L, "Mouse", 500);

		when(productRepository.findById(1L)).thenReturn(Optional.of(product));

		Product result = productService.getById(1L);

		assertEquals("Mouse", result.getName());

	}

	// ✅ UNIT TEST 4: delete

	@Test

	void testDeleteProduct() {

		Long id = 1L;

		doNothing().when(productRepository).deleteById(id);

		productService.delete(id);

		verify(productRepository, times(1)).deleteById(id);

	}

}
