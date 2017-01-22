package com.ordinap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ordinap.entity.ExamType;
import com.ordinap.service.ExamTypeService;

@Controller
@RequestMapping("admin/examtype")
public class ExamTypeController {
	
	@Autowired
	ExamTypeService examTypeService;
	
	@RequestMapping("/add")
	public String add(@ModelAttribute("ExamType") ExamType examType){
		
		
		
		return "admin/examType/add";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("ExamType") ExamType examType, final RedirectAttributes redirectAttributes){
		
		System.out.println(examType.getExamTypeName());
		examTypeService.add(examType);
		redirectAttributes.addFlashAttribute("message","Başarıyla Kaydedilmiştir.");
		return "redirect:/admin/examtype/add";
	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String list(Model model,Integer page) {

		if (page == null) {
			page = 1;
		}
		int maxResults = 2;
		int start = maxResults * (page - 1);
		Long count=examTypeService.count();
		int maxLinkSize=(int) Math.ceil(count/(double)maxResults);
		model.addAttribute("list", examTypeService.all(start, maxResults));
		model.addAttribute("count", count);
		model.addAttribute("offset", page);
		model.addAttribute("maxLinkSize", maxLinkSize);
		System.out.println("count:"+count+",maxResult:"+maxResults +",ceil:"+maxLinkSize);
		
		return "admin/examType/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable("id") int id) {

		ExamType examType = examTypeService.get(id);
		model.addAttribute("Course", examType);

		return "/admin/course/edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("ExamType") ExamType examType, final RedirectAttributes redirectAttributes) {

		examTypeService.update(examType);
		redirectAttributes.addFlashAttribute("message", "Başarıyla Güncellenmiştir.");
		return "redirect:/admin/course/edit/" + examType.getId();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		examTypeService.delete(examTypeService.get(id));
		return "redirect:/admin/course/";
	}

	
	

}
