package com.jackson.api;

public class Employee {

	private Long empId;
	private String empName;
	private int []  phoneNummbers;
	private String wife;
	private Address address;
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int[] getPhoneNummbers() {
		return phoneNummbers;
	}
	public void setPhoneNummbers(int[] phoneNummbers) {
		this.phoneNummbers = phoneNummbers;
	}
	public String getWife() {
		return wife;
	}
	public void setWife(String wife) {
		this.wife = wife;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
