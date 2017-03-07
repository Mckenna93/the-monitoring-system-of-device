package com.ruyi.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.ruyi.dao.RepairDao;
import com.ruyi.domain.Repair;
@Component("repairDao")
public class RepairDaoImpl implements RepairDao {

	@Resource
	private SessionFactory sessionFac;
	
	public Repair findByNumber(int number) {
		// TODO Auto-generated method stub
		Query query = sessionFac.getCurrentSession().createQuery("from Repair where number=?");
		query.setParameter(0, number);
		List list = query.list();
		if(list==null || list.size()==0){
			return null;
		}else{
			return (Repair) list.get(0);
		}
	}

	public List<Repair> findByDeviceId(String deviceId) {
		// TODO Auto-generated method stub
		Query query = sessionFac.getCurrentSession().createQuery("from Repair where id=?");
		query.setParameter(0, deviceId);
		return query.list();
	}

	public void addRepair(Repair repair) {
		// TODO Auto-generated method stub
		sessionFac.getCurrentSession().save(repair);
	}

}
