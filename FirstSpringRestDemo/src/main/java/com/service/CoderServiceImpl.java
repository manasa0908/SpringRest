package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.Coder;
import com.repository.CoderRepository;

@Service
public class CoderServiceImpl implements CoderService
{
	@Autowired
	CoderRepository repo;

	@Override
	public Coder getCoder(int cid) throws Throwable {
		Supplier s1 = ()->new ResourceNotFoundException("Coder does not exists in database");
		Coder c=repo.findById(cid).orElseThrow(s1);
		
		//Coder c1=(Coder) c.get();
		return c;
	}

	
	 @Override public List<Coder> getCoders() { List<Coder> lc=repo.findAll();
	  return lc; }
	 
	  @Override public Coder addCoder(Coder c) { repo.save(c); return c; }
	 
	 @Override public List<Coder> addCoders(List<Coder> lc) { repo.saveAll(lc);
	 return lc; }


	@Override
	public Coder updateCoder(Coder c) throws Throwable 
	{
		int id = c.getCid();
		Supplier s1 = ()->new ResourceNotFoundException("Coder does not exists in database");
		Coder c1=repo.findById(id).orElseThrow(s1);
		//Coder c2 =(Coder) c1.get();
		c1.setCname(c.getCname());
		c1.setTech(c.getTech());
		repo.save(c1);
		
	
		return c1;
	}


	@Override
	public String deleteCoder(Coder c) {
		repo.delete(c);
		return "deleted";
	}


	@Override
	public String deleteCoderById(int cid) {
	
		repo.deleteById(cid);
		return "deleted";
	}


	@Override
	public Coder getCoderByCname(String cname)
	{
		Coder c1=repo.getCoderByCname(cname);
		return c1;
	}
	
	
	public List<Coder> getCoderByTech(String tech)
	{
		List<Coder> c1 = repo.getCoderByTech(tech);
		return c1;
	}


	
	
	 

}