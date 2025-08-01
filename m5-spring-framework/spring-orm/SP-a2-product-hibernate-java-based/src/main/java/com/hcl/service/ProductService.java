package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Product;
import com.hcl.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository productRepository;

	public void saveProduct(Product product) 
	{
		productRepository.saveRecord(product);
	}

	public List<Product> getList() 
	{
		List<Product> plist=productRepository.getProductList();
		return plist;
	}

	public Product getProduct(int pid) 
	{
		Product p=productRepository.getRecord(pid);
		return p;
	}

	public void deleteProduct(int pid) 
	{
		Product product=productRepository.getRecord(pid);
		productRepository.deleteRecord(product);
	}

	public void updateProduct(Product productn) 
	{
		Product producto=productRepository.getRecord(productn.getPid());
		productRepository.updateRecord(productn,producto);
	}
}
