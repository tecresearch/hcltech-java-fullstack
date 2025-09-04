package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {

		return productRepository.save(product);

	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();

	}
	
	  public  Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
		  
	  }
	  
	  public void deleteProduct(Long id) {
		  productRepository.deleteById(id);
		 
		  
		  
	  }
	  public List<Product> getProductsByName(String name) {
	        return productRepository.findByName(name);
	    }


}
