package com.klef.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class paymentService
{
  
	@Autowired
	paymentRepository payrepo;
	
	
	public void dopayment(payment p)
	{
		payrepo.save(p);
	}
	
	
	
	
	
	
}
