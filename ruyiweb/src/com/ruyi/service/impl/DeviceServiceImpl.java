package com.ruyi.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ruyi.dao.DeviceDao;
import com.ruyi.domain.Device;
import com.ruyi.service.DeviceService;

@Component("deviceService")
public class DeviceServiceImpl implements DeviceService {

	@Resource
	private DeviceDao deviceDao;
	
	public List<Device> getOnlineDevice() {
		// TODO Auto-generated method stub
		return deviceDao.getOnlineDevice();
	}

	public Device findById(String id) {
		// TODO Auto-generated method stub
		return deviceDao.findById(id);
	}

	public Device historyState(Device device, String startTime, String endTime) {
		// TODO Auto-generated method stub
		List listArr = deviceDao.historyStateCount(device, startTime, endTime);
		if(listArr!=null && listArr.size()>0){
			Object[] list =  (Object[])listArr.get(0);
			device.setHornCount(((BigInteger)list[0]).intValue());
			device.setUpBtnCount(((BigInteger)list[1]).intValue());
			device.setUpBtnContactorCount(((BigInteger)list[2]).intValue());
			device.setDownBtnCount(((BigInteger)list[3]).intValue());
			device.setMasterContactorCount(((BigInteger)list[4]).intValue());
			device.setArresterCount(((BigInteger)list[5]).intValue());
		}
		return device;
	}

}
