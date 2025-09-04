package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

//import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.controller.ProductController;
import com.example.entity.Product;
import com.example.service.ProductService;

public class ProductControllerTest {
	
	@InjectMocks
	private ProductController productController;
	
	@Mock
	private ProductService productService;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(productController).build();	
		
	}
	
	@Test
	public void testgetAllProducts() throws Exception {
		when(productService.getAllProducts()).thenReturn(Arrays.asList(new Product(),new Product()));
		
		mockMvc.perform(get("/products"))
		       .andExpect(status().isOk())
		       .andExpect(jsonPath("$.length()").value(2));
		    
	
	}
	
	@Test
	public void testgetProductById() throws Exception{
		
		Long productId=1L;
		
		when(productService.getProductById(productId)).thenReturn(Optional.of(new Product()));
		
		mockMvc.perform(get("/products/{id}",productId ))
		.andExpect(status().isOk());
		
		
	}
	

}
