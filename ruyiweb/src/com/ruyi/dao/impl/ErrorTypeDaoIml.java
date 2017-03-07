package com.ruyi.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.ruyi.dao.ErrorTypeDao;
import com.ruyi.domain.ErrorType;

@Component("errorTypeDao")
public class ErrorTypeDaoIml implements ErrorTypeDao {

	@Resource
	private SessionFactory sessionFac;
	
	public List<ErrorType> getAll() {
		// TODO Auto-generated method stub
		Query query = sessionFac.getCurrentSession().createQuery("from ErrorType");
		return query.list();
	}

	public ErrorType findById(int id) {
		// TODO Auto-generated method stub
		Query query = sessionFac.getCurrentSession().createQuery("from ErrorType where id=?");
		query.setParameter(0, id);
		List list = query.list();
		if(list==null || list.size()==0){
			return null;
		}else{
			return (ErrorType) list.get(0);
		}
		
	}

}
