package com.ruyi.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.ruyi.domain.Warning;

public interface WarningService {
	public List<Warning> findByDeviceid(String deviceid);
	public Map<Warning,Integer> todayWarning();
	public Map<Warning,Integer> historyWarning(String deviceId,String startTime,String endTime);
	public Warning deviceWarn(String deviceId, String startTime,String endTime, int errorNum);
	public int deviceWarnNum(String deviceId, String startTime,String endTime, int errorNum);
	public String deviceWarnDetail(String deviceId, String startTime,String endTime, int errorNum);
	public String countByDevice(String deviceId,int[] s_option);
	public String countByDate(String startTime, String endTime,int[] s_option);
	public String countAll(int[] s_option);
 
}
