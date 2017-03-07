package com.ruyi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ruyi.dao.RepairDao;
import com.ruyi.domain.Repair;
import com.ruyi.service.RepairService;

@Component("repairService")
public class RepairServiceImpl implements RepairService {
	
	@Resource
	private RepairDao repairDao;

	public Repair findByNumber(int number) {
		// TODO Auto-generated method stub
		return repairDao.findByNumber(number);
	}

	public List<Repair> findByDeviceId(String deviceId) {
		// TODO Auto-generated method stub
		return repairDao.findByDeviceId(deviceId);
	}

	public void addRepair(Repair repair) {
		// TODO Auto-generated method stub
		repairDao.addRepair(repair);
	}

}
