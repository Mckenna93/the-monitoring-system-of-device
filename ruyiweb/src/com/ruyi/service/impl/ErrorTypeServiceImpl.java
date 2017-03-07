package com.ruyi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ruyi.dao.ErrorTypeDao;
import com.ruyi.domain.ErrorType;
import com.ruyi.service.ErrorTypeService;

@Component("errorTypeService")
public class ErrorTypeServiceImpl implements ErrorTypeService {

	@Resource
	private ErrorTypeDao errorTypeDao;
	
	public List<ErrorType> getAll() {
		// TODO Auto-generated method stub
		return errorTypeDao.getAll();
	}

	public ErrorType findById(int id) {
		// TODO Auto-generated method stub
		return errorTypeDao.findById(id);
	}

}
