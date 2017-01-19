package com.ordinap.controller;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ordinap.entity.Course;
import com.ordinap.service.CourseService;
 
@Controller
@RequestMapping("/admin/course/")
public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("Course") Course course,Model model){
		
	 
		return "admin/course/add";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("Course") Course course,final RedirectAttributes redirectAttributes){
		
		courseService.add(course);
		redirectAttributes.addFlashAttribute("message","Başariyla Eklenmiştir.");
		return "redirect:/admin/course/add";

	}
	
	@RequestMapping(value={"/{page}","/"},method=RequestMethod.GET)
	public String list(Model model,@PathVariable Optional<Integer> page){
		 
		int pageNumber; 
		if(page.isPresent() && page.get()>1){
			
			pageNumber=page.get();
		
		}else {
			pageNumber=1;
		}
		int offset=2;
		int start=offset*(pageNumber-1);
		System.out.println("After"+pageNumber+" start="+start);
		model.addAttribute("list",courseService.all(start,offset));
 		
		return "admin/course/list";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String edit(Model model,@PathVariable("id") int id){
		
		Course course=courseService.get(id);
		model.addAttribute("Course",course);
		
		return "/admin/course/edit";
	} 
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute("Course") Course course,final RedirectAttributes redirectAttributes){
		
		courseService.update(course);
		redirectAttributes.addFlashAttribute("message","Başarıyla Güncellenmiştir.");		
		return "redirect:/admin/course/edit/"+course.getId();
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") int id,final RedirectAttributes redirectAttributes){
		
		courseService.delete(courseService.get(id));
		return "redirect:/admin/course/";
	}
	
}
