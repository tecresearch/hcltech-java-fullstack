package com.cetpa.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.cetpa.model.Product;
import com.cetpa.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired private ProductRepository productRepository;

	public void persistProduct(Product product) 
	{
		productRepository.save(product);
	}

	public List<Product> getList() 
	{
		Sort sort=Sort.by(Direction.ASC,"price");
		List<Product> productList=productRepository.findAll(sort);
		return productList;
	}
	public Page<Product> getListPagination() 
	{
		Pageable page=PageRequest.of(0, 5);
		Page<Product> productList=productRepository.findAll(page);
		return productList;
	}

	public Page<Product> getListByPage(int pn) 
	{
		Pageable page=PageRequest.of(pn-1,3);
		Page<Product> productList=productRepository.findAll(page);
		return productList;
	}

	public List<Product> getList(String name) 
	{
		return productRepository.findByName(name);
	}

	public List<Product> getListByPriceLess(int price) 
	{
		return productRepository.findByPriceLessThan(price);
	}

	public List<Product> getListByPriceBetween(int price1, int price2) 
	{
		return productRepository.findByPriceBetween(price1,price2);
	}

	public Product getProduct(int pid) 
	{
		return productRepository.findById(pid).orElse(null);
	}

	public void updateProduct(Product product) 
	{
		productRepository.save(product);
	}

	public void pupdateProduct(Product producto, Product productn) 
	{
		String name=productn.getName();
		if(name!=null)
			producto.setName(name);
		String brand=productn.getBrand();
		if(brand!=null)
			producto.setBrand(brand);
		int price=productn.getPrice();
		if(price!=0)
			producto.setPrice(price);
		productRepository.save(producto);
	}

	public void pupdateProduct1(Product product, Map<String, Object> updates) 
	{
		updates.forEach((key, value) -> 
		{
            Field field = ReflectionUtils.findField(Product.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, product, value);
            }
        });
		productRepository.save(product);
	}

	public void deleteProductByBrand(String brand) 
	{
		productRepository.deleteByBrand(brand);
	}

	public List<Product> getListByBrand(String brand) 
	{
		return productRepository.findByBrand(brand);
	}
}
