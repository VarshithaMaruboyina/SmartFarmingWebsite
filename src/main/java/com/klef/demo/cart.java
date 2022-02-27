package com.klef.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="carttable")
public class cart {
	
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="cartid")
     private int cid;
	 @Column(name="gmail")
     private String gmail;
	 @Column(name="name")
     private String name;
	 @Column(name="stockid")
     private int sid;
	 @Column(name="sname")
     private String sname;
	 @Column(name="price")
     private double price;
    
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
     
     
}
