package com.ordinap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ordinap.dao.ExamTypeDao;
import com.ordinap.entity.ExamType;

@Service
@Transactional
public class ExamTypeServiceImp implements ExamTypeService{

	@Autowired
	ExamTypeDao examTypeDao;
	@Override
	public void add(ExamType examType) {
		
		examTypeDao.add(examType);
		
	}

	@Override
	public ExamType get(int id) {
		
		return examTypeDao.get(id);
	}

	@Override
	public List<ExamType> all() {
		
		return examTypeDao.all();
	}

	@Override
	public List<ExamType> all(Integer start, Integer rowCount) {
		
		return examTypeDao.all(start, rowCount);

	}

	@Override
	public void update(ExamType examType) {
		
		examTypeDao.update(examType);

	}

	@Override
	public void delete(ExamType examType) {

		examTypeDao.delete(examType);

	}

	@Override
	public Long count() {
			
		return examTypeDao.count();

 	}

	
	
	
}
