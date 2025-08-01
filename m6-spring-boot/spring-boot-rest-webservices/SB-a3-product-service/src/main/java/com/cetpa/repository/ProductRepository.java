package com.cetpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.cetpa.model.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product,Integer> 
{
	List<Product> findByName(String name);
	List<Product> findByPriceLessThan(int price);
	List<Product> findByPriceBetween(int price1, int price2);
	
	@Transactional
	@Modifying
	void deleteByBrand(String brand);
	List<Product> findByBrand(String brand);
}
