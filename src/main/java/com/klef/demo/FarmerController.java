package com.klef.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FarmerController {
	
	@Autowired
	FarmerService fservice;
	
	@Autowired
	technologyService techservice;
	
	@Autowired
	stockService stservice;
	
	@GetMapping("/home")
	@ResponseBody
	 public ModelAndView home()
	 {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	 }
	
	
	@GetMapping("/register")
	@ResponseBody
	 public ModelAndView register()
	 {
	
		ModelAndView mv=new ModelAndView();
		mv.setViewName("register");
		mv.addObject("far", new Farmer());
		return mv;
	 }
	
	@GetMapping("/login")
	@ResponseBody
	 public ModelAndView login()
	 {
	
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	 }
	
	@PostMapping("/submitreg")
	public String  submitreg(@ModelAttribute("far") Farmer far)
	 {
		
		fservice.addfarmer(far);
		
		return "redirect:/login";
	
	 }
	
	@PostMapping("/submitlogin")
	 public String submitlogin(@RequestParam("gmail") String gmail,@RequestParam("pwd") String pwd ,HttpServletRequest req)
	 {
		Farmer fcheck =fservice.retrivebygmail(gmail);
		if(fcheck!=null && fcheck.getPwd().equals(pwd))
		{
			HttpSession session=req.getSession();
			session.setAttribute("gmail", gmail);
			session.setAttribute("name", fcheck.getName());
			return "redirect:/farmerhome";
			
		}
		return "redirect:/login";
		
	    
		//ModelAndView mv=new ModelAndView();
		//mv.setViewName("login");
		//return mv;
	 }
	
	
	@GetMapping("/farmerhome")
	@ResponseBody
	 public ModelAndView farmerhome(HttpServletRequest req)
	 {
		HttpSession session=req.getSession(false);
		String name=(String)session.getAttribute("name");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("farmerhome");
		ArrayList<technology> t=(ArrayList<technology>) techservice.gettechnologies();
		mv.addObject(name);
		mv.addObject("t",t);
		return mv;
	 }
	
	@GetMapping("/adminlogin")
	@ResponseBody
	 public ModelAndView adminlogin()
	 {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	 }
	
	@PostMapping("/adminlogincheck")
	public String adminlogincheck(@RequestParam("gmail") String gmail,@RequestParam("pwd") String pwd )
	{
		if(gmail.equals("admin@gmail.com") && pwd.equals("admin"))
		{
			return "redirect:/adminhome";
		}
		else
		{
			return "redirect:/adminlogin";
				
		}
		
	}
	
	@GetMapping("/adminhome")
	@ResponseBody
	 public ModelAndView adminhome()
	 {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminhome");
		return mv;
	 }
	
	
	@GetMapping("/displayimage/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") int id, HttpServletResponse response) throws IOException{
		technology t=techservice.gettechnologybyid(id);
;		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(t.getImage());
		response.getOutputStream().close();
	}
	
	@GetMapping("/buytechnologies")
	@ResponseBody
	public ModelAndView buytechnologies() 
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("buytechnology");
		ArrayList<stock> s=stservice.retriveallstock();
		mv.addObject("s", s);
		return mv;	
		
	}
	@GetMapping("/displaystockimg1/{sid}")
	@ResponseBody
	public void stockImage1(@PathVariable("sid") int id, HttpServletResponse response) throws IOException{
		stock s=stservice.getstockbyid(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(s.getStockimage1());
		response.getOutputStream().close();
	}
	
	@GetMapping("/displaystockimg2/{sid}")
	@ResponseBody
	public void stockImage2(@PathVariable("sid") int id, HttpServletResponse response) throws IOException{
		stock s=stservice.getstockbyid(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(s.getStockimage2());
		response.getOutputStream().close();
	}
	
	@GetMapping("/viewstockbig/{sid}")
	@ResponseBody
	public ModelAndView viewstockbig(@PathVariable("sid") int id,HttpServletRequest req) 
	{
		HttpSession session=req.getSession(false);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("viewbuytechnology");
		stock s=stservice.getstockbyid(id);
		mv.addObject("s",s);
		return mv;
		
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public ModelAndView logout(HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		session.invalidate();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
