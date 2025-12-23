package com.learn.springaop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springaop.entity.Product;
import com.learn.springaop.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(

		name = "Product API",

		description = "CRUD operations for managing products"

)

@RestController

@RequestMapping("/products")

public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {

		this.productService = productService;

	}

	// ✅ CREATE PRODUCT

	@Operation(summary = "Create a new product")

	@PostMapping

	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

		Product savedProduct = productService.save(product);

		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

	}

	// ✅ GET ALL PRODUCTS

	@Operation(summary = "Get all products")

	@GetMapping

	public ResponseEntity<List<Product>> getAllProducts() {

		return ResponseEntity.ok(productService.getAll());

	}

	// ✅ GET PRODUCT BY ID

	@Operation(summary = "Get product by ID")

	@GetMapping("/{id}")

	public ResponseEntity<Product> getProductById(@PathVariable Long id) {

		return ResponseEntity.ok(productService.getById(id));

	}

	// ✅ DELETE PRODUCT

	@Operation(summary = "Delete product by ID")

	@DeleteMapping("/{id}")

	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

		productService.delete(id);

		return ResponseEntity.ok("Product deleted successfully");

	}

}
