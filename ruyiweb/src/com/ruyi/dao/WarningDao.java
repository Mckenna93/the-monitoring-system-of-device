package com.ruyi.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.ruyi.domain.Warning;

public interface WarningDao {
	public List<Warning> findByDeviceid(String deviceId);
	public List<Warning> todayWarn(int i,String date);
	public List<BigInteger> todayWarnNum(int i,String date);
	public List<Warning> historyWarn(String deviceId, String startTime,String endTime);
	public List<BigInteger> historyWarnNum(String deviceId, String startTime,String endTime);
	public Warning deviceWarn(String deviceId, String startTime,String endTime, int errorNum);
	public BigInteger deviceWarnNum(String deviceId, String startTime,String endTime, int errorNum);
	public List<Warning> deviceWarnDetail(String deviceId, String startTime,String endTime, int errorNum);
	public List<Warning> countByDeviceWarn(String deviceId);
	public List<BigInteger> countByDeviceNum(String deviceId);
	public List<Warning> countByDateWarn(int i,String startTime, String endTime);
	public List<BigInteger> countByDateNum(int i,String startTime, String endTime);
	public List<Warning> countAllWarn(int i);
	public List<BigInteger> countAllNum(int i);

}
