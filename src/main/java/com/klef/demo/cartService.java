package com.klef.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cartService {
	
	@Autowired
	cartRepository crepo;
	
	public void addtocart(cart c)
	{
		crepo.save(c);
	}
	
	public void deletefromcart(int cid)
	{
		crepo.deleteById(cid);
		
		
	}
	
	public ArrayList<cart> getallrecordsbygmail(String gmail)
	{
		return (ArrayList<cart>)crepo.findByGmail(gmail);
	}

}
