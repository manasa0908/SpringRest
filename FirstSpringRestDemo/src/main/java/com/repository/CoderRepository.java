package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Coder;

@Repository
public interface CoderRepository extends JpaRepository<Coder,Integer>
{

	Coder getCoderByCname(String cname);

	List<Coder> getCoderByTech(String tech);

}