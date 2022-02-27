package com.klef.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class stockController {
	
  @Autowired
  stockService stservice;
  
  @GetMapping("/addstockform")
  @ResponseBody
  public ModelAndView addstockform()
  {
	  ModelAndView mv=new ModelAndView();
	  mv.setViewName("stockform");
	  return mv;
  }
  
  @PostMapping("/addstock")
  public String addstock(@RequestParam("name") String name, @RequestParam("stockimage1") MultipartFile file1 ,@RequestParam("stockimage2") MultipartFile file2 ,
			@RequestParam("price") double price,@RequestParam("quantity") int quantity) throws IOException
  {
	  
	  String fileName1 = StringUtils.cleanPath(file1.getOriginalFilename());
	  String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
		byte[] imageData1 = file1.getBytes();
		byte[] imageData2 = file2.getBytes();
	    stock s=new stock();
	    s.setName(name);
	    s.setStockimage1(imageData1);
	    s.setStockimage2(imageData2);
	    s.setPrice(price);
	    s.setQuantity(quantity);
	    stservice.addstock(s);
	    return "redirect:/viewstock";	  
  }
  
  @GetMapping("/viewstock")
  @ResponseBody
  public ModelAndView viewstock()
  {
	  ModelAndView mv = new ModelAndView();
	  ArrayList<stock> s=stservice.retriveallstock();
	  mv.setViewName("viewstock");
	  mv.addObject("s",s);
	  return mv;
	  
  }
  
  @GetMapping("/displaystockimg/{sid}")
	@ResponseBody
	public void showImage(@PathVariable("sid") int id, HttpServletResponse response) throws IOException{
		stock s=stservice.getstockbyid(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(s.getStockimage1());
		response.getOutputStream().close();
	}
  
  @GetMapping("/deletestock/{sid}")
  public String deletestock(@PathVariable("sid") int id)
  {
	  stservice.deletestockbyid(id);
	  return "redirect:/viewstock";
  }
  
  @GetMapping("/updateform/{sid}")
  public ModelAndView updateform(@PathVariable("sid") int sid)
  {
	  ModelAndView mv=new ModelAndView();
	  mv.setViewName("updateform");
	  mv.addObject("sid", sid);
	  return mv;
  }
  
  @PostMapping("/updatestock")
  public String updatestock(@RequestParam("sid") int sid ,@RequestParam("price") double price,@RequestParam("quantity") int quantity)
  {
	  stock s=stservice.getstockbyid(sid);
	  s.setPrice(price);
	  s.setQuantity(quantity);
	  stservice.updatestock(s);
	  return "redirect:/viewstock";
	  
  }
  

}
