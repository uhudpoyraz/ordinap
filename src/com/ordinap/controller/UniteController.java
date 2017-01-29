package com.ordinap.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.ordinap.entity.ExamType;
import com.ordinap.entity.Unite;
import com.ordinap.service.ExamTypeService;
import com.ordinap.service.UniteService;

@Controller
@RequestMapping(value="admin/unite/")
public class UniteController {
	
	@Autowired
	UniteService uniteService;
	
	@Autowired
	ExamTypeService examTypeService;
	
	@RequestMapping(value="{courseId}/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("Unite") Unite unite,Model model,@PathVariable("courseId") Integer courseId){
		
 		model.addAttribute("examTypes",examTypeService.all());
		model.addAttribute("courseId",courseId);
		
		
		return "admin/unite/add";
	}
	
	@RequestMapping(value="save/",method=RequestMethod.POST)
	public String save(@ModelAttribute("Unite") Unite unite,@RequestParam("examtype[]") Integer[] examTypeIds,@RequestParam("courseId") Integer courseId){
		
	
		System.out.println(examTypeIds.length);
		System.out.println(courseId);
		uniteService.add(courseId,examTypeIds, unite);
		return "redirect:/admin/unite/"+courseId+"/add";
	}
	

	@RequestMapping(value = { "{courseId}/" }, method = RequestMethod.GET)
	public String list(Model model,Integer page,@PathVariable("courseId") Integer courseId) {

		if (page == null) {
			page = 1;
		}
		int maxResults = 2;
		int start = maxResults * (page - 1);
		Long count=uniteService.count(courseId);
		int maxLinkSize=(int) Math.ceil(count/(double)maxResults);
		model.addAttribute("list", uniteService.all(courseId,start, maxResults));
		model.addAttribute("count", count);
		model.addAttribute("offset", page);
		model.addAttribute("maxLinkSize", maxLinkSize);
		System.out.println("count:"+count+",maxResult:"+maxResults +",ceil:"+maxLinkSize);
		return "admin/unite/list";
	}
	
	@RequestMapping(value="edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id,Model model){
		
		Unite unite=uniteService.get(id);
		List<ExamType> examTypes=examTypeService.all();
		
		model.addAttribute("examTypes",examTypes);
		model.addAttribute("Unite",unite);
		model.addAttribute("courseId",unite.getCourseId());
		model.addAttribute("uniteExamTypes",unite.getExamTypes());
	 		 
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
