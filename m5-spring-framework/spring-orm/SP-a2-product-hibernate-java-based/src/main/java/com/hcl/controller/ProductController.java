package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hcl.model.Product;
import com.hcl.service.ProductService;

@Controller
public class ProductController 
{
	@Autowired
	private ProductService productService;

	@GetMapping("")
	public String getHomeView()
	{
		return "home";
	}
	@GetMapping("insert-form")
	public String getInsertFormView()
	{
		return "insert";
	}
	@PostMapping("save-record")
	public String saveProductRecord(Product product)
	{
		productService.saveProduct(product);
		return "save-success";
	}
	@GetMapping("product-list")
	public String getProductListView(Model model)
	{
		List<Product> productList=productService.getList();
		model.addAttribute("plist",productList);
		return "list";
	}
	@GetMapping("search-record")
	public String getSearchRecordView()
	{
		return "search";
	}
	@GetMapping("show-product")
	public String getProductRecord(int pid,Model model)
	{
		Product product=productService.getProduct(pid);
		if(product==null)
		{
			model.addAttribute("pid",pid);
			model.addAttribute("msg","Product record not found");
			return "search";	
		}
		model.addAttribute("product",product);
		return "show-record";
	}
	@GetMapping("delete-record")
	public String getDeleteRecordView()
	{
		return "delete";
	}
	@GetMapping("confirm-delete")
	public String getConfirmDeleteView(int pid,Model model)
	{
		Product product=productService.getProduct(pid);
		if(product==null)
		{
			model.addAttribute("pid",pid);
			model.addAttribute("msg","Product record does not exist");
			return "delete";	
		}
		model.addAttribute("product",product);
		return "confirm-delete";
	}
	@GetMapping("delete")
	public String deleteRecord(int pid)
	{
		productService.deleteProduct(pid);
		return "delete-success";
	}
	@GetMapping("update-record")
	public String getUpdateRecordView()
	{
		return "update";
	}
	@GetMapping("get-product")
	public String getProductForEdit(int pid,Model model)
	{
		Product product=productService.getProduct(pid);
		if(product==null)
		{
			model.addAttribute("pid",pid);
			model.addAttribute("msg","Product record does not exist");
			return "update";	
		}
		model.addAttribute("product",product);
		return "edit-record";
	}
	@PostMapping("update-product-record")
	public String updateProductRecord(Product product)
	{
		productService.updateProduct(product);
		return "update-success";
	}
}
