package com.ruyi.dao.impl;


import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Component;

import com.ruyi.dao.WarningDao;
import com.ruyi.domain.Warning;

@Component("warningDao")
public class WarningDaoImpl implements WarningDao {
	
	@Resource
	private SessionFactory sessionFac;

	//用于测试一个实体类对应多张表
	public List<Warning> findByDeviceid(String deviceId) {
		// TODO Auto-generated method stub
		/*Query query = sessionFac.getCurrentSession().createQuery("from Warning where deviceid=?");
		query.setParameter(0, deviceId);*/
		//不同的表名拼接进sql语句
		String sql = "select * from warninfo_"+deviceId.charAt(deviceId.length()-1)+" where id=?";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql).addEntity(Warning.class);
		query.setParameter(0, deviceId);
		return query.list();
	}

	public List<Warning> todayWarn(int i,String date){	
		String sql ="SELECT * FROM  warninfo_"
				+i+" where errorTime>?  and errorTime<?  group by id,errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, date+" 00:00:00");
		query.setParameter(1, date+" 23:59:59");
		query.addEntity(Warning.class);
		return query.list();
	}
	public List<BigInteger> todayWarnNum(int i,String date){
		String sql = "SELECT COUNT(*)AS warningNum FROM  warninfo_"
				+i+" where errorTime>?  and errorTime<?  group by id,errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);//addEntity(Integer.class);
		query.setParameter(0, date+" 00:00:00");
		query.setParameter(1, date+" 23:59:59");
		return query.list();
	}
	public List<Warning> historyWarn(String deviceId, String startTime,String endTime){
		String sql ="SELECT * FROM  warninfo_"
				+deviceId.charAt(deviceId.length()-1)
				+" where errorTime>? and errorTime<? and id=? group by id,errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, startTime+" 00:00:00");
		query.setParameter(1, endTime+" 23:59:59");
		query.setParameter(2, deviceId);
		query.addEntity(Warning.class);
		return query.list();
	}
	public List<BigInteger> historyWarnNum(String deviceId, String startTime,String endTime){
		String sql = "SELECT COUNT(*)AS warningNum FROM  warninfo_"
				+deviceId.charAt(deviceId.length()-1)
				+" where errorTime>? and errorTime<? and id=?  group by id,errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);//addEntity(Integer.class);
		query.setParameter(0, startTime+" 00:00:00");
		query.setParameter(1, endTime+" 23:59:59");
		query.setParameter(2, deviceId);
		return query.list();
	}
	public Warning deviceWarn(String deviceId, String startTime,
			String endTime, int errorNum) {
		String sql ="SELECT * FROM  warninfo_"
				+deviceId.charAt(deviceId.length()-1)
				+" where errorTime>? and errorTime<? and id=? "
				+"and errorNumber=? group by id,errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, startTime+" 00:00:00");
		query.setParameter(1, endTime+" 23:59:59");
		query.setParameter(2, deviceId);
		query.setParameter(3, errorNum);
		query.addEntity(Warning.class);
		List<Warning> warnings = query.list();
		Warning warning = null;
		if(warnings==null || warnings.size()==0){
			return null;
		}else{
			return warnings.get(0);
		}
	}
	public BigInteger deviceWarnNum(String deviceId, String startTime,
			String endTime, int errorNum) {
		String sql = "SELECT COUNT(*)AS warningNum FROM  warninfo_"
				+deviceId.charAt(deviceId.length()-1)
				+" where errorTime>? and errorTime<? and id=? " 
				+"and errorNumber=?  group by id,errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);//addEntity(Integer.class);
		query.setParameter(0, startTime+" 00:00:00");
		query.setParameter(1, endTime+" 23:59:59");
		query.setParameter(2, deviceId);
		query.setParameter(3, errorNum);
		List nums = query.list();
		if(nums==null || nums.size()==0){
			return null;
		}else{
			return (BigInteger) nums.get(0);
		}
	}
	//查询叉车故障详情形成序列图
	public List<Warning> deviceWarnDetail(String deviceId, String startTime
			,String endTime, int errorNum){
		String sql ="SELECT * FROM  warninfo_"
				+deviceId.charAt(deviceId.length()-1)
				+" where errorTime>? and errorTime<? and id=?  and errorNumber=? ";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, startTime+" 00:00:00");
		query.setParameter(1, endTime+" 23:59:59");
		query.setParameter(2, deviceId);
		query.setParameter(3, errorNum);
		query.addEntity(Warning.class);
		return query.list();
	}
	public List<Warning> countByDeviceWarn(String deviceId){
		String sql = "SELECT * FROM warninfo_"+
				deviceId.charAt(deviceId.length()-1)+" WHERE id=? GROUP BY errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, deviceId);
		query.addEntity(Warning.class);
		return query.list();
	}
	public List<BigInteger> countByDeviceNum(String deviceId){
		String sql2 = "SELECT COUNT(*)AS warningNum FROM  warninfo_"+
				deviceId.charAt(deviceId.length()-1)+" WHERE id=? GROUP BY errorNumber";
		SQLQuery query2 = sessionFac.getCurrentSession().createSQLQuery(sql2);
		query2.setParameter(0, deviceId);
		return query2.list();
	}
	public List<Warning> countByDateWarn(int i,String startTime, String endTime){
		String sql ="SELECT * FROM  warninfo_"
				+i+" where errorTime>?  and errorTime<?  group by errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, startTime+" 00:00:00");
		query.setParameter(1, endTime+" 23:59:59");
		query.addEntity(Warning.class);
		return query.list();
	}
	public List<BigInteger> countByDateNum(int i,String startTime, String endTime){
		String sql = "SELECT COUNT(*)AS warningNum FROM  warninfo_"
				+i+" where errorTime>? and errorTime<? group by errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, startTime+" 00:00:00");
		query.setParameter(1, endTime+" 23:59:59");
		return query.list();
	}
	public List<Warning> countAllWarn(int i){
		String sql ="SELECT * FROM  warninfo_"
				+i+"  group by errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Warning.class);
		return query.list();
	}
	public List<BigInteger> countAllNum(int i){
		String sql = "SELECT COUNT(*)AS warningNum FROM  warninfo_"
				+i+" group by errorNumber";
		SQLQuery query = sessionFac.getCurrentSession().createSQLQuery(sql);
		return query.list();
	}

}
