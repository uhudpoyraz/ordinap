package com.ordinap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Test(Model model){
		
		
		return "test";
	}
	
	
}
