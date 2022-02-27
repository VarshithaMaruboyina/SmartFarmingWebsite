package com.klef.demo;


import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class paymentController {

	
	@Autowired 
	paymentService payservice;
	
	@Autowired
	cartService cservice;
	
	@Autowired
	stockService sservice;
	
	
@GetMapping("/paymentform/{sum}")
public ModelAndView paymentform(@PathVariable("sum") double sum)
{
ModelAndView mv=new ModelAndView();
mv.setViewName("paymentform");
mv.addObject("sum", sum);
return mv;
}

@GetMapping("/pay")
public String pay(@RequestParam("address") String address,@RequestParam("card_number") String cardno,HttpServletRequest req)
{
	HttpSession session=req.getSession(false);
	   String gmail=(String)session.getAttribute("gmail");
		String name=(String)session.getAttribute("name");
		Date d=new Date();
		ArrayList<cart> c=cservice.getallrecordsbygmail(gmail);
		for(cart i:c)
		{
			int id=i.getSid();
			stock s=sservice.getstockbyid(id);
			int oldq=s.getQuantity();
			oldq--;
			s.setQuantity(oldq);
			sservice.updatestock(s);
			payment p=new payment();
			p.setGmail(gmail);
			p.setName(name);
			p.setAddress(address);
			p.setCardno(cardno);
			p.setCreateDate(d);
			p.setPrice(i.getPrice());
			p.setSid(id);
			p.setStockname(i.getName());
			payservice.dopayment(p);
			cservice.deletefromcart(i.getCid());
			
			
			
		}
		return "redirect:/success";
			
}



@GetMapping("/success")
@ResponseBody
public ModelAndView success()
{
	  ModelAndView mv=new ModelAndView();
	  mv.setViewName("success");
	  return mv;
}
	
	
	
}
