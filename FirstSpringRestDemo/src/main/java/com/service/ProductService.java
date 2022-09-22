package com.service;

import java.util.List;

import com.entity.Product;

public interface ProductService {
	
	public Product getProduct(int pid);
	
	public List<Product> getProducts();
	
	public  Product addProduct(Product p);
	
	public List<Product> addProducts(List<Product> lp);
	
	public Product updateProduct(Product p);
	
	public String deleteProduct(Product p);
	
	public String deleteProductById(int pid);

}
