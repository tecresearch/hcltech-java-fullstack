package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

//import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

public class ProductServiceTest {
	
	@InjectMocks
	private ProductService  productService;
	
	@Mock
	private ProductRepository productRespository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSaveProduct() {
		Product product = new Product();
		//mock the behaviour of save method
		when(productRespository.save(product)).thenReturn(product);
		
		Product savedProduct = productService.saveProduct(product);
		
		verify(productRespository, times(1)).save(product);
		assertEquals(product,savedProduct);
		
		
	}
	
	@Test
	public void testgetAllProducts() {
		
		when(productRespository.findAll()).thenReturn(Arrays.asList(new Product(), new Product()));
		
		List<Product> products= productService.getAllProducts();
		
		verify(productRespository,times(1)).findAll();
		assertEquals(2, products.size());
		
		
		
	}

}
