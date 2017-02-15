package com.ordinap.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ordinap.dao.UniteDao;
import com.ordinap.entity.Course;
import com.ordinap.entity.ExamType;
import com.ordinap.entity.Unite;

@Transactional
@Service
public class UniteServiceImp implements UniteService {

	@Autowired
	CourseService courseService;
	@Autowired
	UniteDao uniteDao;
	@Autowired
	ExamTypeService examTypeService;
 	@Override
	public void add(Integer courseId,Integer[] examTypeIds,Unite unite) {
	
 		List<ExamType> examTypes = new ArrayList<ExamType>();
		for (Integer examTypeId : examTypeIds) {
			examTypes.add(examTypeService.get(examTypeId));
		}
 		
		Course course=courseService.get(courseId);
		unite.setCourse(course);
		unite.setExamTypes(examTypes);
		uniteDao.add(unite);		
	}

	
 	@Override
	public Unite get(int id) {
 		
		return uniteDao.get(id);
	}
	
 	@Override
	public List<Unite> all(int id) {
		
		return uniteDao.all(id);
	}

 	@Override
	public void update(Integer courseId,Unite unite) {

		Course course=courseService.get(courseId);
		unite.setCourse(course); 
		uniteDao.update(unite);
		
	}
 	@Override
	public void delete(Unite unite) {
		
		uniteDao.delete(unite);
		
	}
 	
 	@Override
	public List<Unite> all() {

		return uniteDao.all();

	}


	@Override
	public List<Unite> all(Integer id, Integer start, Integer rowCount) {

		return uniteDao.all(id, start, rowCount);

	}

	@Override
	public Long count(int courseId){
		return uniteDao.count(courseId);
	}

 
}
