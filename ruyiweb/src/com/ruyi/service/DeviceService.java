package com.ruyi.service;

import java.util.List;

import com.ruyi.domain.Device;

public interface DeviceService {
	public List<Device> getOnlineDevice();
	public Device findById(String id);
	public Device historyState(Device device,String startTime,String endTime);

}
