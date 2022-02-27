package com.klef.demo;

import org.springframework.data.repository.CrudRepository;

public interface FarmerRepository extends CrudRepository<Farmer,String>
{
 public Farmer findByGmail(String gmail);
	
}
