package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

		Product savedProduct = productService.saveProduct(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);

	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> products = productService.getAllProducts();

		return ResponseEntity.ok(products);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
		Optional<Product> product = productService.getProductById(id);
		return ResponseEntity.ok(product);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

		Optional<Product> existingProduct = productService.getProductById(id);

		if (existingProduct.isPresent()) {
			product.setId(id);
			Product updatedProduct = productService.saveProduct(product);

			return ResponseEntity.ok(updatedProduct);
		} else
			return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id); 
		return ResponseEntity.noContent().build();
		
	}
	
	
	
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name) {
        List<Product> products = productService.getProductsByName(name);
        return ResponseEntity.ok(products);
    }

}
