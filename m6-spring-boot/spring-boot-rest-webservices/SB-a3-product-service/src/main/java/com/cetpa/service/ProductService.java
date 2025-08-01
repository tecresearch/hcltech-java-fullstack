package com.cetpa.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.cetpa.model.Product;

public interface ProductService 
{
	void persistProduct(Product product);
	List<Product> getList();
	Page<Product> getListPagination();
	Page<Product> getListByPage(int pn);
	List<Product> getList(String name);
	List<Product> getListByPriceLess(int price);
	List<Product> getListByPriceBetween(int price1, int price2);
	Product getProduct(int pid);
	void updateProduct(Product product);
	void pupdateProduct(Product producto, Product productn);
	void pupdateProduct1(Product producto, Map<String, Object> updates);
	void deleteProductByBrand(String brand);
	List<Product> getListByBrand(String brand);
}
