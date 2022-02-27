package com.klef.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stocktable")
public class stock {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sid")
	private int sid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="stockimage1" ,  length = Integer.MAX_VALUE, nullable = true)
	private byte[] stockimage1;
	
	@Column(name="stockimage2" ,  length = Integer.MAX_VALUE, nullable = true)
	private byte[] stockimage2;
	

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getStockimage1() {
		return stockimage1;
	}

	public void setStockimage1(byte[] stockimage1) {
		this.stockimage1 = stockimage1;
	}

	public byte[] getStockimage2() {
		return stockimage2;
	}

	public void setStockimage2(byte[] stockimage2) {
		this.stockimage2 = stockimage2;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name="stockprice")
	private double price;
	
	@Column(name="quantity")
	private int quantity;
	
	

	
	
	
	
	
	
	
	

}
