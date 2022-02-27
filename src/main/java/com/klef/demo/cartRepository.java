package com.klef.demo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface cartRepository extends CrudRepository<cart,Integer>
{
	public ArrayList<cart> findByGmail(String gmail);
}
