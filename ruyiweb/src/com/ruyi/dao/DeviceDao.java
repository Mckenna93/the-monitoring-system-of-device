package com.ruyi.dao;

import java.math.BigInteger;
import java.util.List;

import com.ruyi.domain.Device;

public interface DeviceDao {
	public List<Device> getOnlineDevice();
	public Device findById(String id);
	public List historyStateCount(Device device,String startTime,String endTime);

}
