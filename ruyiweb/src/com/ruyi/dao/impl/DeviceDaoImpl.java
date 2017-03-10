package com.ruyi.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.ruyi.dao.DeviceDao;
import com.ruyi.domain.Device;

@Component("deviceDao")
public class DeviceDaoImpl implements DeviceDao {
	
	@Resource
	private SessionFactory sessionFac;

	public List<Device> getOnlineDevice() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM onlinedeviceinfo";
		Query query = sessionFac.getCurrentSession().createSQLQuery(sql).addEntity(Device.class);
		return query.list();
	}

	public Device findById(String id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM onlinedeviceinfo where id=?";
		Query query = sessionFac.getCurrentSession().createSQLQuery(sql).addEntity(Device.class);
		query.setParameter(0, id);
		List list = query.list();
		if(list==null || list.size()==0){
			return null;
		}else{
			return (Device) list.get(0);
		}
	}

	public List historyStateCount(Device device,String startTime,String endTime) {
		// TODO Auto-generated method stub
		String id = device.getId();
		int index = Integer.parseInt(id.substring(id.length()-2, id.length()-1));
		String sql = "SELECT COUNT(hornCount) AS hornCount,COUNT(upBtnCount) AS upBtnCount,COUNT(upBtnContactorCount) AS upBtnContactorCount,"+
				"COUNT(downBtnCount) AS downBtnCount,COUNT(masterContactorCount) AS masterContactorCount,COUNT(arresterCount) AS arresterCount"+
				"  FROM deviceinfo_"+index+" WHERE date(time) between ? AND ?";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, startTime);
		query.setParameter(1, endTime);
		return  query.list();
	}

}
