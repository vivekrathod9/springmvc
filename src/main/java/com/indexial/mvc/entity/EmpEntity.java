package com.indexial.mvc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="new_mvc")
public class EmpEntity {
	
	@Id
	int empId;
	String empName;
	int empAge;
	String empAddress;
	
	@Override
	public String toString() {
		return "EmpEntity [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empAddress="
				+ empAddress + "]";
	}
	public EmpEntity(int empId, String empName, int empAge, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empAddress = empAddress;
	}
	public EmpEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
}
