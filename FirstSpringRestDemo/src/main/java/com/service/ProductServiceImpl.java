package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository repo;

	@Override
	public Product getProduct(int pid) {
		
		Optional p = repo.findById(pid);
		
		Product p1 = (Product)  p.get();
		
		return p1;
	}

	@Override
	public List<Product> getProducts() {
		
		List<Product> lc = repo.findAll();
	
		return lc;
	}

	@Override
	public Product addProduct(Product p) {
		repo.save(p);
		return p;
	}

	@Override
	public List<Product> addProducts(List<Product> lp) {
		
		repo.saveAll(lp);
		return lp;
	}

	@Override
	public Product updateProduct(Product p) {
		int id = p.getPid();
		Product p1 = repo.findById(id).orElseThrow();
		p1.setPname(p.getPname());
		p1.setPrize(p.getPrize());
		repo.save(p1);
		return p1;
	}

	@Override
	public String deleteProduct(Product p) {
		repo.delete(p);
		return "Product Deleted";
	}

	@Override
	public String deleteProductById(int pid) {
	
		repo.deleteById(pid);
		return "Product Deleted";
	}

}
