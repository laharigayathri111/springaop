package com.learn.springaop.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.springaop.entity.Product;
import com.learn.springaop.service.ProductServiceImpl;

@WebMvcTest(ProductController.class)

class ProductControllerTest {

	@Autowired

	private MockMvc mockMvc;

	@MockBean

	private ProductServiceImpl productService;

	@Autowired

	private ObjectMapper objectMapper;

	// ✅ TEST 1: POST - save product

	@Test

	void testSaveProduct() throws Exception {

		Product product = new Product(null, "Mobile", 15000);

		Product savedProduct = new Product(1L, "Mobile", 15000);

		when(productService.save(any(Product.class))).thenReturn(savedProduct);

		mockMvc.perform(post("/products")

				.contentType(MediaType.APPLICATION_JSON)

				.content(objectMapper.writeValueAsString(product)))

				.andExpect(status().isCreated())

				.andExpect(jsonPath("$.name").value("Mobile"))

				.andExpect(jsonPath("$.price").value(15000));

	}

	// ✅ TEST 2: GET - get all products

	@Test

	void testGetAllProducts() throws Exception {

		List<Product> products = List.of(

				new Product(1L, "Laptop", 60000),

				new Product(2L, "Headset", 2000)

		);

		when(productService.getAll()).thenReturn(products);

		mockMvc.perform(get("/products"))

				.andExpect(status().isOk())

				.andExpect(jsonPath("$.size()").value(2));

	}

	// ✅ TEST 3: GET by ID

	@Test

	void testGetProductById() throws Exception {

		Product product = new Product(1L, "Mouse", 500);

		when(productService.getById(1L)).thenReturn(product);

		mockMvc.perform(get("/products/1"))

				.andExpect(status().isOk())

				.andExpect(jsonPath("$.name").value("Mouse"));

	}

	// ✅ TEST 4: DELETE product

	@Test

	void testDeleteProduct() throws Exception {

		doNothing().when(productService).delete(1L);

		mockMvc.perform(delete("/products/1"))

				.andExpect(status().isOk());

		verify(productService, times(1)).delete(1L);

	}

}
