package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.AutoConfiguration;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {
	
	
	@Id
	@GeneratedValue
	private int pid;
	private String pname;
	private double prize;
	
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="jid",referencedColumnName="cid")
	 * 
	 * @JsonBackReference
	 * 
	 * 
	 * 
	 * Coder coder;
	 * 
	 * 
	 * public Coder getCoder() { return coder; } public void setCoder(Coder coder) {
	 * this.coder = coder; }
	 */
	 
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", prize=" + prize +"]";
	}
	
	
	
	
	

}
