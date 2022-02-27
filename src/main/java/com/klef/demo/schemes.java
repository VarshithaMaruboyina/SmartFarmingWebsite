package com.klef.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="schemetable")
public class schemes 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lid", nullable = false, unique = true)
	private int lid;
	@Column(name="linkurl")
	private String link;
	@Column(name="schemename")
	private String scname;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
    
	
	
	
	

}
