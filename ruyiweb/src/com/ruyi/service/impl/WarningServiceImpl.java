package com.ruyi.service.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ruyi.dao.DeviceDao;
import com.ruyi.dao.WarningDao;
import com.ruyi.domain.Warning;
import com.ruyi.service.WarningService;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

@Component("warningService")
public class WarningServiceImpl implements WarningService {
	@Resource
	private WarningDao warningDao;

	public List<Warning> findByDeviceid(String deviceid) {
		// TODO Auto-generated method stub
		return warningDao.findByDeviceid(deviceid);
	}

	public Map<Warning,Integer> todayWarning() {
		// TODO Auto-generated method stub
		Map<Warning,Integer> map = new HashMap<Warning,Integer>();
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
		for(int i=0;i<=9;i++){	
			List<Warning> warnings = warningDao.todayWarn(i, date);
			List<BigInteger> nums = warningDao.todayWarnNum(i, date);
			for(int j = 0;j<warnings.size();j++){
				map.put(warnings.get(j), nums.get(j).intValue());
			}
		}
		return map;
	}

	public Map<Warning,Integer> historyWarning(String deviceId, String startTime,
			String endTime) {
		// TODO Auto-generated method stub
		Map<Warning,Integer> map = new HashMap<Warning,Integer>();
		for(int i=0;i<=9;i++){	
			List<Warning> warnings = warningDao.historyWarn(deviceId, startTime, endTime);
			List<BigInteger> nums = warningDao.historyWarnNum(deviceId, startTime, endTime);
			for(int j = 0;j<warnings.size();j++){
				map.put(warnings.get(j), nums.get(j).intValue());
			}
		}
		return map;
	}

	public Warning deviceWarn(String deviceId, String startTime,
			String endTime, int errorNum){
		return warningDao.deviceWarn(deviceId, startTime, endTime, errorNum);
	}
	public int deviceWarnNum(String deviceId, String startTime,
			String endTime, int errorNum){
		return (warningDao.deviceWarnNum(deviceId, startTime, endTime, errorNum)).intValue();
	}
	public String deviceWarnDetail(String deviceId, String startTime
			,String endTime, int errorNum){
		List<Warning> list = warningDao.deviceWarnDetail(deviceId, startTime, endTime, errorNum);
		if(list == null || list.size() == 0){
			return null;
		}
		StringBuffer warningDetail = new StringBuffer();
		warningDetail.append("[");
		for(Warning warn:list){
			warningDetail.append("["+warn.getErrorTime().getTime()+","+
					warn.getErrorValue()+"],");
		}
		warningDetail.deleteCharAt(warningDetail.lastIndexOf(","));
		warningDetail.append("]");
		String warnList = warningDetail.toString();
		return warnList;
	}

	public String countByDevice(String deviceId,int[] s_option) {
		// TODO Auto-generated method stub
		Map<Warning,Integer> map = new HashMap<Warning,Integer>();
		List<Warning> warnings = warningDao.countByDeviceWarn(deviceId);
		List<BigInteger> nums = warningDao.countByDeviceNum(deviceId);	
		for(int j = 0;j<warnings.size();j++){
			map.put(warnings.get(j), ((BigInteger) nums.get(j)).intValue());
		}
		return convertToStr(map,s_option);
	}

	public String countByDate(String startTime, String endTime,int[] s_option) {
		// TODO Auto-generated method stub
		Map<Warning,Integer> map = new HashMap<Warning,Integer>();
		for(int i=0;i<=9;i++){
			List<Warning> warnings = warningDao.countByDateWarn(i, startTime, endTime);
			List<BigInteger> nums = warningDao.countByDateNum(i, startTime, endTime);
			for(int j = 0;j<warnings.size();j++){
				map.put(warnings.get(j), nums.get(j).intValue());
			}
		}
		return convertToStr(map,s_option);
	}

	public String countAll(int[] s_option) {
		// TODO Auto-generated method stub
		Map<Warning,Integer> map = new HashMap<Warning,Integer>();
		for(int i=0;i<=9;i++){
			List<Warning> warnings = warningDao.countAllWarn(i);
			List<BigInteger> nums = warningDao.countAllNum(i);
			for(int j = 0;j<warnings.size();j++){
				map.put(warnings.get(j), nums.get(j).intValue());
			}
		}
		return convertToStr(map,s_option);
	}
	
	//将查询结果转换成Str传入前台
		private String convertToStr(Map<Warning,Integer> warnings,int[] s_option){
			if(warnings == null || warnings.size() == 0
					|| s_option == null || s_option.length == 0){
				return null;
			}
			StringBuffer warningList = new StringBuffer();
			warningList.append("[");
			for(int option:s_option){
				for(java.util.Map.Entry<Warning, Integer> entry:warnings.entrySet()){
					if(entry.getKey().getErrorType().getId()==option){
						warningList.append("['("+entry.getKey().getErrorType().getId()+") "
								+entry.getKey().getErrorType().getError()+"',"+
								entry.getValue()+"],");
					}
				}
			}
			warningList.deleteCharAt(warningList.lastIndexOf(","));
			warningList.append("]");
			String warnList = warningList.toString();
			return warnList;
		}

}
