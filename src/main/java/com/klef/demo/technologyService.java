package com.klef.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class technologyService {
	
	@Autowired
	technologyRepository techrepo;
	
	public Boolean addtechnology(technology t)
	{
		techrepo.save(t);
		return true;
	}
	
	public List<technology> gettechnologies()
	{
		return (ArrayList<technology>)techrepo.findAll();
	}
    public technology gettechnologybyid(int id)
    {
    	technology t= techrepo.findById(id).get();
    	return t;
    }
}
