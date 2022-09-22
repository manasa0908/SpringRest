package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;



@RestController
@RequestMapping("api")
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@GetMapping("/getProduct/{pid}")
	public Product getProduct(@PathVariable int pid)
	{
		Product p = productservice.getProduct(pid);
		return p;
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProducts()
	{
		List<Product> lp = productservice.getProducts();
		return  lp;
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product p)
	{
		Product p1 = productservice.addProduct(p);
		return p1;
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> lp)
	{
		List<Product> lp1 = productservice.addProducts(lp);
		return lp1;
	}
	
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product p)
	{
		Product p1 = productservice.updateProduct(p);
		return p1;
	}
	
	@DeleteMapping("/deleteproduct")
	public String deleteProduct(@RequestBody Product p)
	{
		String str = productservice.deleteProduct(p);
		return str;
	}
	
	@DeleteMapping("/deleteproductbyid/{pid}")
	public String deleteProductById(@PathVariable int pid)
	{
		String str = productservice.deleteProductById(pid);
		return str;
	}

}
