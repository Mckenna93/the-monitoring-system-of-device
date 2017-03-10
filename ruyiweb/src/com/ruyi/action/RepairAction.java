package com.ruyi.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ruyi.domain.Device;
import com.ruyi.domain.ErrorType;
import com.ruyi.domain.Repair;
import com.ruyi.domain.User;
import com.ruyi.service.DeviceService;
import com.ruyi.service.ErrorTypeService;
import com.ruyi.service.RepairService;

@Component("repairAction")
@Scope("prototype")
public class RepairAction extends ActionSupport implements ModelDriven<Repair>{

	@Resource
	private DeviceService deviceService;
	@Resource
	private RepairService repairService;
	@Resource
	private ErrorTypeService errorTypeService;
	private Repair repair = new Repair();
	private int errortypeId;
	
	public Repair getModel() {
		// TODO Auto-generated method stub
		return repair;
	}

	public Repair getRepair() {
		return repair;
	}

	public void setRepair(Repair repair) {
		this.repair = repair;
	}
	
	public int getErrortypeId() {
		return errortypeId;
	}

	public void setErrortypeId(int errortypeId) {
		this.errortypeId = errortypeId;
	}
	
	public String info(){
		ActionContext ac = ActionContext.getContext();
		//第一次访问时不应该有维修信息
		ac.getSession().put("repairList", null);
		List<Device> device = deviceService.getOnlineDevice();
		List<ErrorType> errors = errorTypeService.getAll();
		ac.getSession().put("deviceList", device);
		ac.getSession().put("errorList", errors);
		return "repair";	
	}
	
	public String findByDeviceId(){
		List<Repair> repairList = repairService.findByDeviceId(repair.getId());
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("repairList", repairList);
		return "repair";
		
	}
	
	public String addRepair(){
		ErrorType errorType = errorTypeService.findById(errortypeId);
		repair.setErrorType(errorType);
		repairService.addRepair(repair);
		//跳转到执行查询的action
		return findByDeviceId();
		
	}

	

}
