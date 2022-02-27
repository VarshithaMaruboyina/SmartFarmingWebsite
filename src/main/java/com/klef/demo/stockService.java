package com.klef.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class stockService {
	
	@Autowired
	stockRepository srepo;
	
	public Boolean addstock(stock s)
	{
		srepo.save(s);
		return true;
	}
	
	public ArrayList<stock> retriveallstock()
	{
		ArrayList<stock> s=(ArrayList<stock>)srepo.findAll();
		return s;
	}
	
	public stock getstockbyid(int id)
	{
		stock s=srepo.findById(id).get();
		return s;
	}
	
	public void deletestockbyid(int id)
	{
		  srepo.deleteById(id);
	}
	
	public Boolean updatestock(stock s)
	{
		srepo.save(s);
		return true;
	}
	

}
