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
		return "home.jsp";
	}
	@GetMapping("insert-form")
	public String getInsertFormView()
	{
		return "insert.jsp";
	}
	@PostMapping("save-record")
	public String saveProductRecord(Product product)
	{
		productService.saveProduct(product);
		return "save-success.jsp";
	}
	@GetMapping("product-list")
	public String getProductListView(Model model)
	{
		List<Product> productList=productService.getList();
		model.addAttribute("plist",productList);
		return "list.jsp";
	}
	@GetMapping("search-record")
	public String getSearchRecordView()
	{
		return "search.jsp";
	}
	@GetMapping("show-product")
	public String getProductRecord(int pid,Model model)
	{
		Product product=productService.getProduct(pid);
		if(product==null)
		{
			model.addAttribute("pid",pid);
			model.addAttribute("msg","Product record not found");
			return "search.jsp";	
		}
		model.addAttribute("product",product);
		return "show-record.jsp";
	}
	@GetMapping("delete-record")
	public String getDeleteRecordView()
	{
		return "delete.jsp";
	}
	@GetMapping("confirm-delete")
	public String getConfirmDeleteView(int pid,Model model)
	{
		Product product=productService.getProduct(pid);
		if(product==null)
		{
			model.addAttribute("pid",pid);
			model.addAttribute("msg","Product record does not exist");
			return "delete.jsp";	
		}
		model.addAttribute("product",product);
		return "confirm-delete.jsp";
	}
	@GetMapping("delete")
	public String deleteRecord(int pid)
	{
		productService.deleteProduct(pid);
		return "delete-success.jsp";
	}
	@GetMapping("update-record")
	public String getUpdateRecordView()
	{
		return "update.jsp";
	}
	@GetMapping("get-product")
	public String getProductForEdit(int pid,Model model)
	{
		Product product=productService.getProduct(pid);
		if(product==null)
		{
			model.addAttribute("pid",pid);
			model.addAttribute("msg","Product record does not exist");
			return "update.jsp";	
		}
		model.addAttribute("product",product);
		return "edit-record.jsp";
	}
	@PostMapping("update-product-record")
	public String updateProductRecord(Product product)
	{
		productService.updateProduct(product);
		return "update-success.jsp";
	}
}
