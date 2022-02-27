package com.klef.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {
	
	  @Autowired
      FarmerRepository frepo ;
	  
	  public void addfarmer(Farmer f)
	  {
		  frepo.save(f);
	  }
	  
	  public Farmer retrivebygmail(String gmail)
	  {
		
		  Farmer fcheck=frepo.findByGmail(gmail);
		return fcheck;
		
		
	  }
	

}
