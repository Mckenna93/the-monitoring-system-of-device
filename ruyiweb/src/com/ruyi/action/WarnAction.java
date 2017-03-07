package com.ruyi.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ruyi.domain.Device;
import com.ruyi.domain.ErrorType;
import com.ruyi.domain.User;
import com.ruyi.domain.Warning;
import com.ruyi.service.DeviceService;
import com.ruyi.service.ErrorTypeService;
import com.ruyi.service.WarningService;

@Component("warnAction")
public class WarnAction extends ActionSupport{
	
	@Resource
	private WarningService warningService;
	@Resource
	private DeviceService deviceService;
	@Resource
	private ErrorTypeService errorTypeService;
	
	private String deviceId;
	private String startTime;
	private String endTime;
	private int errorNum;
	private int[] s_option;
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
	public int getErrorNum() {
		return errorNum;
	}

	public void setErrorNum(int errorNum) {
		this.errorNum = errorNum;
	}
	public int[] getS_option() {
		return s_option;
	}

	public void setS_option(int[] s_option) {
		this.s_option = s_option;
	}
	
	public String todayWarn(){
		ActionContext ac = ActionContext.getContext();
		Map<Warning, Integer> todayWarning = warningService.todayWarning();
		ac.getSession().put("todayWarning", todayWarning);
		return "todayWarning";
	}
	
	//历史故障查询页面
	public String historyWarn(){
		ActionContext ac = ActionContext.getContext();
		List<Device> devices = deviceService.getOnlineDevice();
		ac.getSession().put("deviceList", devices);
		ac.getSession().put("historyWarning", null);
		ac.getSession().put("startTime",null);
		ac.getSession().put("endTime",null);
		return "historyWarning";
	}
	
	//历史故障显示页面
	public String historyWarnList(){
		ActionContext ac = ActionContext.getContext();
		Map<Warning, Integer> historyWarning = warningService.historyWarning(deviceId, startTime, endTime);
		ac.getSession().put("historyWarning", historyWarning);
		ac.getSession().put("startTime",startTime);
		ac.getSession().put("endTime",endTime);
		return "historyWarning";
	}
	
	//叉车故障详情
	public String deviceWarning(){
		ActionContext ac = ActionContext.getContext();
		Warning deviceWarn = warningService.deviceWarn(deviceId, startTime, endTime, errorNum);
		int warnNum = warningService.deviceWarnNum(deviceId, startTime, endTime, errorNum);
		String warnDetail = warningService.deviceWarnDetail(deviceId, startTime, endTime, errorNum);
		ac.getSession().put("deviceWarn", deviceWarn);
		ac.getSession().put("warnNum", warnNum);
		ac.getSession().put("warnDetail", warnDetail);
		//System.out.println(warnDetail);
		ac.getSession().put("startTime",startTime);
		ac.getSession().put("endTime",endTime);
		return "deviceWarning";
	}
	
	//按叉车统计初始页面
	public String warningCount(){
		ActionContext ac = ActionContext.getContext();
		List<Device> devices = deviceService.getOnlineDevice();
		ac.getSession().put("deviceList", devices);
		List<ErrorType> errorTypeList = errorTypeService.getAll();
		ac.getSession().put("errorTypeList", errorTypeList);
		ac.getSession().put("warningList1", null);
		ac.getSession().put("deviceId", null);
		return "warningCount";
	}
	
	//按日期统计初始页面
	public String warningCount1(){
		ActionContext ac = ActionContext.getContext();
		List<ErrorType> errorTypeList = errorTypeService.getAll();
		ac.getSession().put("errorTypeList", errorTypeList);
		ac.getSession().put("warningList2", null);
		ac.getSession().put("startTime",null);
		ac.getSession().put("endTime",null);
		return "warningCountDate";	
	}
	
	//按故障类型统计初始页面
	public String warningCount2(){
		ActionContext ac = ActionContext.getContext();
		List<ErrorType> errorTypeList = errorTypeService.getAll();
		ac.getSession().put("errorTypeList", errorTypeList);
		ac.getSession().put("warningList3", null);
		return "warningCountAll";	
	}
	
	
	public String countByDevice(){
		String warnList = warningService.countByDevice(deviceId, s_option);
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("warningList1", warnList);
		//System.out.println(warnList);
		ac.getSession().put("deviceId", deviceId);
		//将多选框内容清空
		s_option = null;
		return "warningCount";
	}
	
	public String countByDate(){
		String warnList = warningService.countByDate(startTime, endTime, s_option);
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("warningList2", warnList);
		ac.getSession().put("startTime", startTime);
		ac.getSession().put("endTime", endTime);
		s_option = null;
		return "warningCountDate";
	}
	
	public String countAll(){
		String warnList =warningService.countAll(s_option);
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("warningList3", warnList);
		s_option = null;
		return "warningCountAll";
	}

	

}
