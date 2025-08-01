package com.hcl.repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.hcl.model.Product;

@Repository
public class ProductRepository 
{
	private Session session;
	private Transaction transaction;
	
	public ProductRepository(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
		transaction=session.getTransaction();
	}
	public void saveRecord(Product product) 
	{
		transaction.begin();
		session.persist(product);
		transaction.commit();
	}

	public List<Product> getProductList() 
	{
		Query<Product> query=session.createQuery("from Product",Product.class);
		return query.list();
	}

	public Product getRecord(int pid) 
	{
		Product product=session.get(Product.class,pid);
		return product;
	}
	public void deleteRecord(Product product) 
	{
		transaction.begin();
		session.remove(product);
		transaction.commit();
	}
	public void updateRecord(Product productn, Product producto)
	{
		transaction.begin();
		producto.setName(productn.getName());
		producto.setBrand(productn.getBrand());
		producto.setPrice(productn.getPrice());
		transaction.commit();
	}
}
