package com.ordinap.service;

import java.util.List;

import com.ordinap.entity.ExamType;

public interface ExamTypeService {
	
	public void add(ExamType examType);
	public ExamType get(int id);
	public List<ExamType> all();
	public List<ExamType> all(Integer start,Integer rowCount);
	public void update(ExamType examType);
	public void delete(ExamType examType);
	public Long count();

}
