package com.ruyi.dao;

import java.util.List;

import com.ruyi.domain.Repair;

public interface RepairDao {
	public Repair findByNumber(int number);
	public List<Repair> findByDeviceId(String deviceId);
	public void addRepair(Repair repair);
 
}
