package com.ruyi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Formula;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

//复合主键需要实现Serializable接口
@Entity
public class Warning implements Serializable {
	
	private static final long serialVersionUID = -4888836126783955019L; 
	@Id
	@Column(name="id")
	private String deviceid;
	@ManyToOne(targetEntity=ErrorType.class)
	@JoinColumn(name="errorNumber",referencedColumnName="id")
	@Id
	private ErrorType errorType;
	@Id
	private Date errorTime;
	private int errorValue;
	private int errorLevel;
	@Id
	private int errorState;
	
	public Warning(){
		
	}
	
	public Date getErrorTime() {
		return errorTime;
	}
	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}
	public int getErrorValue() {
		return errorValue;
	}
	public void setErrorValue(int errorValue) {
		this.errorValue = errorValue;
	}
	public int getErrorLevel() {
		return errorLevel;
	}
	public void setErrorLevel(int errorLevel) {
		this.errorLevel = errorLevel;
	}
	public int getErrorState() {
		return errorState;
	}
	public void setErrorState(int errorState) {
		this.errorState = errorState;
	}
	public ErrorType getErrorType() {
		return errorType;
	}
	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (this.deviceid+this.errorTime+this.errorType+this.errorState).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof  Warning){
			Warning warning = (Warning) obj;
			if(this.deviceid.equals(warning.getDeviceid()) && this.errorTime.equals(warning.getErrorTime())
					&& this.errorType.equals(warning.getErrorType()) && this.errorState == warning.getErrorState()){
				return true;
			}
		}
		return false;
	}

}
