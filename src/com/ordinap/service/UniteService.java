package com.ordinap.service;

import java.util.List;

import com.ordinap.entity.Unite;

public interface UniteService {
	
	
	public void add(Integer courseId,Integer[] examTypeIds,Unite unite);
	public Unite get(int id);
	public List<Unite> all();
	public List<Unite> all(int id);
	public List<Unite> all(Integer id,Integer start,Integer rowCount);
	public void update(Integer courseId,Unite unite);
	public void delete(Unite unite);
	public Long count(int courseId);
 
	

}
