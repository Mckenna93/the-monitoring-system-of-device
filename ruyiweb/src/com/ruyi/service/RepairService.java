package com.ruyi.service;

import java.util.List;

import com.ruyi.domain.Repair;

public interface RepairService {
	public Repair findByNumber(int number);
	public List<Repair> findByDeviceId(String deviceId);
	public void addRepair(Repair repair);

}
