package com.ruyi.service;

import java.util.List;

import com.ruyi.domain.ErrorType;

public interface ErrorTypeService {
	public List<ErrorType> getAll();
	public ErrorType findById(int id);

}
