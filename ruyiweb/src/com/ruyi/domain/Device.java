package com.ruyi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Device implements Serializable{
	@Id
	private String id;
	@Id
	private Date time;
	private String runningTime;
	private int hornSwitch;
	private int horn;
	private int hornGround;
	private int upBtnSwitch;
	private int upBtnContactorCoilUpper;
	private int upBtnContactorCoilDown;
	private int upBtnContactUpper;
	private int upBtnContactDown;
	private int downBtnSwitch;
	private int downBtnsolenoidvalveUpper;
	private int downBtnsolenoidvalveDown;
	private int masterContactorCoilUpper;
	private int masterContactorCoilDown;
	private int masterContactUpper;
	private int masterContactDown;
	private int arresterUpper;
	private int arresterDown;
	private int liftMotorCurrent;
	private int liftMotorTemperature;
	private int canDirectionandSpeedMode;
	private int canSpeed;
	private int canError;
	private int canLowPowerMode;
	private int canCourse;
	private int canDirectVoltage;
	private int canMotorCurrent;
	private int canMotorTemperature;
	private int hornCount;
	private int upBtnCount;
	private int upBtnContactorCount;
	private int downBtnCount;
	private int masterContactorCount;
	private int arresterCount;
	
	public Device(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public int getHornSwitch() {
		return hornSwitch;
	}
	public void setHornSwitch(int hornSwitch) {
		this.hornSwitch = hornSwitch;
	}
	public int getHorn() {
		return horn;
	}
	public void setHorn(int horn) {
		this.horn = horn;
	}
	public int getHornGround() {
		return hornGround;
	}
	public void setHornGround(int hornGround) {
		this.hornGround = hornGround;
	}
	public int getUpBtnSwitch() {
		return upBtnSwitch;
	}
	public void setUpBtnSwitch(int upBtnSwitch) {
		this.upBtnSwitch = upBtnSwitch;
	}
	public int getUpBtnContactorCoilUpper() {
		return upBtnContactorCoilUpper;
	}
	public void setUpBtnContactorCoilUpper(int upBtnContactorCoilUpper) {
		this.upBtnContactorCoilUpper = upBtnContactorCoilUpper;
	}
	public int getUpBtnContactorCoilDown() {
		return upBtnContactorCoilDown;
	}
	public void setUpBtnContactorCoilDown(int upBtnContactorCoilDown) {
		this.upBtnContactorCoilDown = upBtnContactorCoilDown;
	}
	public int getDownBtnSwitch() {
		return downBtnSwitch;
	}
	public void setDownBtnSwitch(int downBtnSwitch) {
		this.downBtnSwitch = downBtnSwitch;
	}
	public int getDownBtnsolenoidvalveUpper() {
		return downBtnsolenoidvalveUpper;
	}
	public void setDownBtnsolenoidvalveUpper(int downBtnsolenoidvalveUpper) {
		this.downBtnsolenoidvalveUpper = downBtnsolenoidvalveUpper;
	}
	public int getDownBtnsolenoidvalveDown() {
		return downBtnsolenoidvalveDown;
	}
	public void setDownBtnsolenoidvalveDown(int downBtnsolenoidvalveDown) {
		this.downBtnsolenoidvalveDown = downBtnsolenoidvalveDown;
	}
	public int getMasterContactorCoilUpper() {
		return masterContactorCoilUpper;
	}
	public void setMasterContactorCoilUpper(int masterContactorCoilUpper) {
		this.masterContactorCoilUpper = masterContactorCoilUpper;
	}
	public int getMasterContactorCoilDown() {
		return masterContactorCoilDown;
	}
	public void setMasterContactorCoilDown(int masterContactorCoilDown) {
		this.masterContactorCoilDown = masterContactorCoilDown;
	}
	public int getMasterContactUpper() {
		return masterContactUpper;
	}
	public void setMasterContactUpper(int masterContactUpper) {
		this.masterContactUpper = masterContactUpper;
	}
	public int getMasterContactDown() {
		return masterContactDown;
	}
	public void setMasterContactDown(int masterContactDown) {
		this.masterContactDown = masterContactDown;
	}
	public int getArresterUpper() {
		return arresterUpper;
	}
	public void setArresterUpper(int arresterUpper) {
		this.arresterUpper = arresterUpper;
	}
	public int getArresterDown() {
		return arresterDown;
	}
	public void setArresterDown(int arresterDown) {
		this.arresterDown = arresterDown;
	}
	public int getLiftMotorCurrent() {
		return liftMotorCurrent;
	}
	public void setLiftMotorCurrent(int liftMotorCurrent) {
		this.liftMotorCurrent = liftMotorCurrent;
	}
	public int getLiftMotorTemperature() {
		return liftMotorTemperature;
	}
	public void setLiftMotorTemperature(int liftMotorTemperature) {
		this.liftMotorTemperature = liftMotorTemperature;
	}
	public int getCanDirectionandSpeedMode() {
		return canDirectionandSpeedMode;
	}
	public void setCanDirectionandSpeedMode(int canDirectionandSpeedMode) {
		this.canDirectionandSpeedMode = canDirectionandSpeedMode;
	}
	public int getCanSpeed() {
		return canSpeed;
	}
	public void setCanSpeed(int canSpeed) {
		this.canSpeed = canSpeed;
	}
	public int getCanError() {
		return canError;
	}
	public void setCanError(int canError) {
		this.canError = canError;
	}
	public int getCanLowPowerMode() {
		return canLowPowerMode;
	}
	public void setCanLowPowerMode(int canLowPowerMode) {
		this.canLowPowerMode = canLowPowerMode;
	}
	public int getCanCourse() {
		return canCourse;
	}
	public void setCanCourse(int canCourse) {
		this.canCourse = canCourse;
	}
	public int getCanDirectVoltage() {
		return canDirectVoltage;
	}
	public void setCanDirectVoltage(int canDirectVoltage) {
		this.canDirectVoltage = canDirectVoltage;
	}
	public int getCanMotorCurrent() {
		return canMotorCurrent;
	}
	public void setCanMotorCurrent(int canMotorCurrent) {
		this.canMotorCurrent = canMotorCurrent;
	}
	public int getCanMotorTemperature() {
		return canMotorTemperature;
	}
	public void setCanMotorTemperature(int canMotorTemperature) {
		this.canMotorTemperature = canMotorTemperature;
	}
	public int getHornCount() {
		return hornCount;
	}
	public void setHornCount(int hornCount) {
		this.hornCount = hornCount;
	}
	public int getUpBtnCount() {
		return upBtnCount;
	}
	public void setUpBtnCount(int upBtnCount) {
		this.upBtnCount = upBtnCount;
	}
	public int getUpBtnContactorCount() {
		return upBtnContactorCount;
	}
	public void setUpBtnContactorCount(int upBtnContactorCount) {
		this.upBtnContactorCount = upBtnContactorCount;
	}
	public int getDownBtnCount() {
		return downBtnCount;
	}
	public void setDownBtnCount(int downBtnCount) {
		this.downBtnCount = downBtnCount;
	}
	public int getMasterContactorCount() {
		return masterContactorCount;
	}
	public void setMasterContactorCount(int masterContactorCount) {
		this.masterContactorCount = masterContactorCount;
	}
	public int getArresterCount() {
		return arresterCount;
	}
	public void setArresterCount(int arresterCount) {
		this.arresterCount = arresterCount;
	}
	public int getUpBtnContactUpper() {
		return upBtnContactUpper;
	}
	public void setUpBtnContactUpper(int upBtnContactUpper) {
		this.upBtnContactUpper = upBtnContactUpper;
	}
	public int getUpBtnContactDown() {
		return upBtnContactDown;
	}
	public void setUpBtnContactDown(int upBtnContactDown) {
		this.upBtnContactDown = upBtnContactDown;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (this.id+this.time).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Device){
			Device device = (Device) obj;{
				if(this.id.equals(device.id) && this.time.equals(device.time)){
					return true;
				}
			}
		}
		return false;
	}

}
