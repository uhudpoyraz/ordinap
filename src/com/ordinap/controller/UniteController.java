package com.ordinap.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.hibernate.annotations.AttributeAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ordinap.entity.Unite;
import com.ordinap.service.UniteService;

@Controller
@RequestMapping(value="admin/unite/")
public class UniteController {
	
	@Autowired
	UniteService uniteService;
	
	@RequestMapping(value="{courseId}/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("Unite") Unite unite,Model model,@PathVariable("courseId") Integer courseId){
		
		model.addAttribute("courseId",courseId);
		
		
		return "admin/unite/add";
	}
	
	@RequestMapping(value="save/",method=RequestMethod.POST)
	public String save(@ModelAttribute("Unite") Unite unite,@RequestParam("courseId") Integer courseId){
		
		System.out.println(courseId);
		uniteService.add(courseId, unite);
		
		
		return "redirect:/admin/unite/"+courseId+"/add";
	}
	

	@RequestMapping(value={"{courseId}/{page}","{courseId}/","{courseId}"},method=RequestMethod.GET)
	public String list(Model model,@PathVariable Optional<Integer> page,@PathVariable("courseId") Integer courseId){
		 
		int pageNumber; 
		if(page.isPresent() && page.get()>1){
			
			pageNumber=page.get();
		
		}else {
			pageNumber=1;
		}
		int offset=20;
		int start=offset*(pageNumber-1);
		System.out.println("After"+pageNumber+" start="+start);
	    model.addAttribute("list",uniteService.all(courseId,start,offset));
 		model.addAttribute("courseId",courseId);
		return "admin/unite/list";
	}
	
	@RequestMapping(value="edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id,Model model){
		
		Unite unite=uniteService.get(id);
		model.addAttribute("Unite",unite);
		model.addAttribute("courseId",unite.getCourseId());

		
		return "admin/unite/edit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute("Unite") Unite unite,@RequestParam("courseId") Integer courseId){
		

		uniteService.update(courseId,unite);
		
		return "redirect:/admin/unite/edit/"+unite.getId();
	}
	@RequestMapping(value="{courseId}/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable Integer courseId,@PathVariable Integer id){
		
			uniteService.delete(uniteService.get(id));
		
		return "redirect:/admin/unite/"+courseId+"/";
	}
	

}
