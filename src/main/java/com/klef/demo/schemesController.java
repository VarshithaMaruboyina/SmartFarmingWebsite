package com.klef.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class schemesController
{
	@Autowired
	schemesService schservice;
	
	@GetMapping("/schemeform")
	@ResponseBody
    public ModelAndView schemeform()
    {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("schemeform");
		return mv;
		
		
    }
	
	@GetMapping("/getallschemes")
	@ResponseBody
	public ModelAndView getallschemes()
	{
	  ModelAndView mv=new ModelAndView();
	  mv.setViewName("schemes");
	  ArrayList<schemes> sc=(ArrayList<schemes>)schservice.getallschemes();
	  mv.addObject("sc",sc);
	  return mv;
	}
	
	@PostMapping("/addscheme")
	public String addscheme(@RequestParam("link") String link,@RequestParam("scname") String scname)
	{
		schemes sch=new schemes();
		sch.setLink(link);
		sch.setScname(scname);
		schservice.savescheme(sch);
		return "redirect:/schemeform";
	}

}
