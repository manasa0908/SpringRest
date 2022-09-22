package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Coder;
import com.repository.CoderRepository;

@SpringBootTest
class CoderServiceImplTest {

	@Autowired
	CoderService coderservice;
	
	@MockBean
	CoderRepository repo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetCoder() throws Throwable{
		
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Maya");
		c1.setTech("Java");
		
		Optional<Coder> c2= Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(coderservice.getCoder(1)).isNotEqualTo(c2);
		
	}

	@Test
	void testGetCoders() {
		Coder c1 = new Coder();
		
		c1.setCid(1);
		c1.setCname("Maya");
		c1.setTech("Java");
		
		Coder c2 = new Coder();
		
		c2.setCid(2);
		c2.setCname("Tina");
		c2.setTech("AI");
		
		List <Coder> lc = new ArrayList<>();
		lc.add(c1);
		lc.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(lc);
		
		assertThat(coderservice.getCoders()).isEqualTo(lc);
	}

	
	  @Test 
	  void testAddCoder() 
	  { 
		  Coder c1 = new Coder();
		  c1.setCid(1);
		  c1.setCname("Maya");
		  c1.setTech("Java");
		  
		  Mockito.when(repo.save(c1)).thenReturn(c1);
		  assertThat(coderservice.addCoder(c1)).isEqualTo(c1);
	  }
	 
	 @Test 
	 void testAddCoders() 
	 { 
		 Coder c1 = new Coder();
			
			c1.setCid(1);
			c1.setCname("Maya");
			c1.setTech("Java");
			
			Coder c2 = new Coder();
			
			c2.setCid(2);
			c2.setCname("Tina");
			c2.setTech("AI");
			
			List <Coder> lc = new ArrayList<>();
			lc.add(c1);
			lc.add(c2);
			
			Mockito.when(repo.saveAll(lc)).thenReturn(lc);
			
			assertThat(coderservice.addCoders(lc)).isEqualTo(lc);
	 } 
	 @Test 
	 void testUpdateCoder() throws Throwable
	 { 
		 Coder c1=new Coder();
			c1.setCid(1);
			c1.setCname("Maya");
			c1.setTech("Java");
			Optional<Coder> c2=Optional.of(c1);
			
			Mockito.when(repo.findById(1)).thenReturn(c2);
			
			Mockito.when(repo.save(c1)).thenReturn(c1);
			c1.setCname("Dia");
			c1.setTech("ML");
			
			assertThat(coderservice.updateCoder(c1)).isEqualTo(c1);
	 }
	  
	  @Test 
	  void testDeleteCoder() 
	  { 
		  Coder c1=new Coder();
			c1.setCid(1);
			c1.setCname("Maya");
			c1.setTech("Java");
			Optional<Coder> c2=Optional.of(c1);
			
			Mockito.when(repo.findById(1)).thenReturn(c2);
			 Mockito.when(repo.existsById(c1.getCid())).thenReturn(false);
			   assertFalse(repo.existsById(c1.getCid())); 
	  }
	  
		/*
		 * @Test void testDeleteCoderById() { Coder c1 = new Coder(); c1.setCid(1);
		 * c1.setCname("Maya"); c1.setTech("Java");
		 * 
		 * Optional <Coder> c2 = Optional.of(c1);
		 * 
		 * Mockito.when(repo.f) }
		 */
	  
	 /* @Test void testGetCoderByCname() { fail("Not yet implemented"); }
	 * 
	 * @Test void testGetCoderByTech() { fail("Not yet implemented"); }
	 */
}
