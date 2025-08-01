package com.cetpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.model.Product;
import com.cetpa.service.ProductService;

@RestController
@RequestMapping("product-service")
public class ProductController 
{
	@Autowired private ProductService productService;
	
	@PostMapping("/product/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		productService.persistProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	/*@GetMapping("/product/list")
	public ResponseEntity <List<Product>> getProductList()
	{
		List<Product> productList= productService.getList();
		return ResponseEntity.ok(productList);
	}
	@GetMapping("/product/list")
	public ResponseEntity<List<Product>> getProductList()
	{
		List<Product> productList= productService.getListPagination().toList();
		return ResponseEntity.ok(productList);
	}*/
	@GetMapping("/product/list/{pn}")
	public ResponseEntity<List<Product>> getProductList(@PathVariable int pn)
	{
		List<Product> productList= productService.getListByPage(pn).toList();
		return ResponseEntity.ok(productList);
	}
	@GetMapping("/product/list/byname/{name}")
	public ResponseEntity <List<Product>> getProductListByName(@PathVariable String name)
	{
		List<Product> productList= productService.getList(name);
		return ResponseEntity.ok(productList);
	}
	@GetMapping("/product/list/price-lessthan")
	public ResponseEntity <List<Product>> getProductListByPriceLess(@RequestParam int price)
	{
		List<Product> productList= productService.getListByPriceLess(price);
		return ResponseEntity.ok(productList);
	}
	@GetMapping("/product/list/byprice-between")
	public ResponseEntity <List<Product>> getProductListByPriceBetween(@RequestParam int price1,@RequestParam int price2)
	{
		List<Product> productList= productService.getListByPriceBetween(price1,price2);
		return ResponseEntity.ok(productList);
	}
	@PutMapping("/product/update/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable int pid, @RequestBody Product product)
	{
		Product producto=productService.getProduct(pid);
		if(producto==null)
		{
			productService.persistProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(product);
		}
		product.setPid(pid);
		productService.updateProduct(product);
		return ResponseEntity.ok(product);
	}
	/*@PatchMapping("/product/pupdate/{pid}")
	public ResponseEntity<Product> pupdateProduct(@PathVariable int pid, @RequestBody Product productn)
	{
		Product producto=productService.getProduct(pid);
		if(producto==null)
		{
			return ResponseEntity.notFound().build();
		}
		productService.pupdateProduct(producto,productn);
		return ResponseEntity.ok(producto);
	}*/
	@PatchMapping("/product/pupdate/{pid}")
	public ResponseEntity<Product> pupdateProduct(@PathVariable int pid, @RequestBody Map<String, Object> updates)
	{
		Product producto=productService.getProduct(pid);
		if(producto==null)
		{
			return ResponseEntity.notFound().build();
		}
		productService.pupdateProduct1(producto,updates);
		return ResponseEntity.ok(producto);
	}
	@DeleteMapping("/product/delete-bybrand/{brand}")
	public ResponseEntity<List<Product>> deleteProductByBrand(@PathVariable String brand)
	{
		List<Product> productList= productService.getListByBrand(brand);	
		if(productList.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		productService.deleteProductByBrand(brand);
		return ResponseEntity.ok(productList);
	}
}
