package com.codeWithRohit.studentManagement;

public class Student {
	private int studentId;
	private String stuentName;
	private String studentphone;
	private String studentCity;
	public Student(int studentId, String stuentName, String studentphone, String studentCity) {
		super();
		this.studentId = studentId;
		this.stuentName = stuentName;
		this.studentphone = studentphone;
		this.studentCity = studentCity;
	}
	public Student(String stuentName, String studentphone, String studentCity) {
		super();
		this.stuentName = stuentName;
		this.studentphone = studentphone;
		this.studentCity = studentCity;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStuentName() {
		return stuentName;
	}
	public void setStuentName(String stuentName) {
		this.stuentName = stuentName;
	}
	public String getStudentphone() {
		return studentphone;
	}
	public void setStudentphone(String studenthone) {
		this.studentphone = studenthone;
	}
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	@Override
	public String toString() {
		return "Stuent [studentId=" + studentId + ", stuentName=" + stuentName + ", studenthone=" + studentphone
				+ ", studentCity=" + studentCity + "]";
	}
	
}
