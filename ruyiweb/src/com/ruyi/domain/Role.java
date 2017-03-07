package com.ruyi.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Role���ڶ���User�ǹ���Ա������ͨ�û���
@Entity
@Table(name="roles")
public class Role {
	@Id
	private int id;
	private String name;
	private int defaultNum;
	private int permissions;
	
	public Role(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDefaultNum() {
		return defaultNum;
	}
	public void setDefaultNum(int defaultNum) {
		this.defaultNum = defaultNum;
	}
	public int getPermissions() {
		return permissions;
	}
	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}

}
