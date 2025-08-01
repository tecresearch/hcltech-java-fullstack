package com.hcl.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.hcl.model.Product;

@Repository
public class ProductRepository 
{
	private List<Product> productList=new ArrayList<Product>();

	public void saveRecord(Product product) 
	{
		productList.add(product);
	}

	public List<Product> getProductList() 
	{
		return productList;
	}

	public Product getRecord(int pid) 
	{
		for(Product p:productList)
		{
			if(p.getPid()==pid)
				return p;
		}
		return null;
	}

	public void deleteRecord(Product product) 
	{
		productList.remove(product);
	}
}
