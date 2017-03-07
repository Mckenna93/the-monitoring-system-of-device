package com.ruyi.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;

import com.ruyi.dao.UserDao;
import com.ruyi.domain.Role;
import com.ruyi.domain.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource
	private SessionFactory sessionFac;


	public User findByNameAndPwd(User user) {
		// TODO Auto-generated method stub
		//说明sessionFac注入成功了。
		//System.out.println(sessionFac==null);
		
		Query q	= sessionFac.getCurrentSession().createQuery("from User where userName=? and password=?");
		q.setParameter(0, user.getUserName());
		q.setParameter(1, user.getPassword());
	
		List list = q.list();
		if(list != null && list.size()>0){
			return (User) list.get(0);
		}else{
			return null;
		}		
	}
	
	public void updateUser(User user){
		sessionFac.getCurrentSession().update(user);	
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		Query query = sessionFac.getCurrentSession().createQuery("from User");
		return query.list();
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		User user = (User) sessionFac.getCurrentSession().get(User.class, id);
		if(user!=null){
			sessionFac.getCurrentSession().delete(user);
		}		
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		Role role = (Role) sessionFac.getCurrentSession().get(Role.class, (user.getRank()));
		user.setRole(role);
		sessionFac.getCurrentSession().save(user);
		
	}

	

}
