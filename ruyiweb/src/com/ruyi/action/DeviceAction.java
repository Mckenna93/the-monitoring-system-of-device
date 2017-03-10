package com.ruyi.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ruyi.domain.Device;
import com.ruyi.domain.User;
import com.ruyi.service.DeviceService;

@Component("deviceAction")
@Scope("prototype")
public class DeviceAction extends ActionSupport implements ModelDriven<Device>{
	
	@Resource
	private DeviceService deviceService;
	private Device device = new Device();
	private String startTime;
	private String endTime;
	
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Device getModel() {
		// TODO Auto-generated method stub
		return device;
	}
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getOnlineDevice(){
		//在方法中getContext		
		List<Device> device = deviceService.getOnlineDevice();
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("deviceList", device);
		return "list";
		
	}
	
	public String findById(){
		//id参数传递成功
		String id = device.getId();
		Device findDevice = deviceService.findById(id);
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("device", findDevice);
		return "device";
	}
	
	public String historyState(){
		ActionContext ac = ActionContext.getContext();
		List<Device> device = deviceService.getOnlineDevice();
		ac.getSession().put("deviceList", device);
		ac.getSession().put("historyState", null);
		ac.getSession().put("startTime",null);
		ac.getSession().put("endTime",null);
		return "historyState";
		
	}
	
	public String historyStateList(){
		ActionContext ac = ActionContext.getContext();
		Device historyState = deviceService.historyState(device, startTime, endTime);
		ac.getSession().put("historyState", historyState);
		ac.getSession().put("startTime",startTime);
		ac.getSession().put("endTime",endTime);
		return "historyState";
	}



}
