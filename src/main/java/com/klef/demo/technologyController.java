package com.klef.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class technologyController {
	
	
	
	@Autowired
	technologyService techservice;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	
	
	@GetMapping("/addtechnologyform")
	@ResponseBody
	public ModelAndView addtechnologyform()	
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addtechnologyform");
		return mv;
		
	}
	
	@PostMapping("/addtechnology")
	public String addtechnology(@RequestParam("image") MultipartFile file ,@RequestParam("name") String name,
	@RequestParam("description") String description,HttpServletRequest request) throws IOException
	{
		System.out.println(file);
		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		 System.out.println(fileName);
		byte[] imageData = file.getBytes();
		technology t=new technology();
		t.setImage(imageData);
		t.setName(name);
		t.setDescription(description);
		techservice.addtechnology(t);
		return "redirect:/viewtechnology";
	}
	
	@GetMapping("/viewtechnology")
	public ModelAndView viewtechnology()
	{
		ModelAndView mv=new ModelAndView();
		ArrayList<technology> t=(ArrayList<technology>) techservice.gettechnologies();
		mv.setViewName("viewtech");
		
		mv.addObject("t",t);
		return mv;
	}
	
	@GetMapping("/displayimg/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") int id, HttpServletResponse response) throws IOException{
		technology t=techservice.gettechnologybyid(id);
;		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(t.getImage());
		response.getOutputStream().close();
	}

	

}
