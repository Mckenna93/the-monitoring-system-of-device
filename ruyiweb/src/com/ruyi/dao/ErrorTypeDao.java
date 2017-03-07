package com.ruyi.dao;

import java.util.List;

import com.ruyi.domain.ErrorType;

public interface ErrorTypeDao {
	public List<ErrorType> getAll();
	public ErrorType findById(int id);

}
