package com.klef.demo;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class cartController {
	
	
	   @Autowired
	   cartService cservice;
	   
	   @Autowired
	   stockService sservice;
	   
	   
	   @GetMapping("/viewcart")
	   @ResponseBody
	   public ModelAndView viewcart(HttpServletRequest req)
	   {
		   HttpSession session=req.getSession(false);
		   String gmail=(String)session.getAttribute("gmail");
			String name=(String)session.getAttribute("name");
		   ModelAndView mv=new ModelAndView();
		   ArrayList<cart> c= (ArrayList<cart>) cservice.getallrecordsbygmail(gmail);
		   ArrayList<Integer> a=new ArrayList<Integer>();
		   double sum=0.0;
		   for(cart i:c)
		   {
			  int sid= i.getSid();
			 stock s= sservice.getstockbyid(sid);
			  if(s.getQuantity()==0)
			  {
				  cservice.deletefromcart(i.getCid());
			  }
			  else
			  {
			   sum=sum+i.getPrice();
			  }
		   }
			   
		   mv.addObject("c", c);
		   mv.addObject("sum",sum);
		   mv.setViewName("viewcart");
		   return mv;
	   }
	   
	   @GetMapping("/addcart/{sid}")
	   public String addcart(@PathVariable("sid") int sid,HttpServletRequest req)
	   {
		   HttpSession session=req.getSession(false);
		   String gmail=(String)session.getAttribute("gmail");
			String name=(String)session.getAttribute("name");
		   stock st=sservice.getstockbyid(sid);
		   cart c=new cart();
		   c.setGmail(gmail);
		   c.setName(name);
		   c.setSid(st.getSid());
		   c.setSname(st.getName());
		   c.setPrice(st.getPrice());
		   cservice.addtocart(c); 
		   return "redirect:/viewcart";
		   
	   }
	   
	   
	   @GetMapping("/deletefromcart/{cid}")
	   public String deletefromcart(@PathVariable("cid") int cid)
	   {
		   cservice.deletefromcart(cid);
		   return "redirect:/viewcart";
		   
	   }
	   
	   

}
