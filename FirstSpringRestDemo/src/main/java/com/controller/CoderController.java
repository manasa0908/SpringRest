package com.controller;

import java.util.List;
//import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.advices.ResourceNotFoundException;
import com.entity.Coder;
import com.service.CoderService;

@RestController
@RequestMapping("api")
public class CoderController {
	
	@Autowired
	CoderService coderservice;
	
	@GetMapping("/getCoder/{cid}")
	public Coder getCoder(@PathVariable  int cid) throws Throwable
	{
		Coder c1=coderservice.getCoder(cid);
		
		return c1;
		
	}
	
	
	 @GetMapping("/getCoders") public List<Coder> getCoders() { List<Coder>
	 c1=coderservice.getCoders();
	 
	 return c1;
	 }
	
	  @PostMapping("/addcoder")
	  public Coder addCoder(@RequestBody Coder c) 
	  { 
		  Coder c1 = coderservice.addCoder(c);
		  return c1;
	  }
	 
	 @PostMapping("/addcoders") 
	 public List<Coder> addCoders(@RequestBody List<Coder> lc) 
	 { 
		 List<Coder> c1 = coderservice.addCoders(lc);
	  
	     return c1; 
	 }
	 
	 @PutMapping("/updatecoder")
	 public Coder updateCoder(@RequestBody Coder c) throws Throwable
	 {
		 Coder c1=coderservice.updateCoder(c);
		 return c1;
	 }
	 
	 @DeleteMapping("/deletecoder")
	 public String deleteCoder(@RequestBody Coder c)
	 {
		 String str = coderservice.deleteCoder(c);
		 return str;
	 }
	 
	 @DeleteMapping("/deletecoderbyid/{cid}")
	 public String deleteCoderById(@PathVariable int cid)
	 {
		 String str = coderservice.deleteCoderById(cid);
		 return str;
	 }
	 
	 @GetMapping("/getcoderbycname/{cname}")
	 public Coder getCoderByCname(@PathVariable String cname)
	 {
		 Coder c = coderservice.getCoderByCname(cname);
		 return c;
	 }
	 
	 @GetMapping("/getcoderbytech/{tech}")
	 public List<Coder> getCoderByTech(@PathVariable String tech)
	 {
		 List<Coder> lc= coderservice.getCoderByTech(tech);
		 
		 return lc;
	 }

}