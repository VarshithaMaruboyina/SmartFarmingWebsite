package com.klef.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class schemesService 
{
	@Autowired
	schemesRepository schrepo;
	
	public ArrayList<schemes> getallschemes()
	{
		ArrayList<schemes> sch=(ArrayList<schemes>)schrepo.findAll();
	    return sch;
	}
	
	public void savescheme(schemes sch)
	{
		
		schrepo.save(sch);
	}
	

}
