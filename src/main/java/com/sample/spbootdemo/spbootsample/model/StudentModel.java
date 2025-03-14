package com.sample.spbootdemo.spbootsample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_detail")
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // This ensures auto-generation of student_id
	@Column(name = "student_roll_no")
	private Integer studentRollNo;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_dob")
	private String studentDob;

	@Column(name = "student_place")
	private String studentPlace;

	@Column(name = "student_address")
	private String studentAddress;

	public Integer getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(Integer studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}

	public String getStudentPlace() {
		return studentPlace;
	}

	public void setStudentPlace(String studentPlace) {
		this.studentPlace = studentPlace;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "StudentModel [studentRollNo=" + studentRollNo + ", studentName=" + studentName + ", studentDob="
				+ studentDob + ", studentPlace=" + studentPlace + ", studentAddress=" + studentAddress + "]";
	}

	public StudentModel(Integer studentRollNo, String studentName, String studentDob, String studentPlace,
			String studentAddress) {
		super();
		this.studentRollNo = studentRollNo;
		this.studentName = studentName;
		this.studentDob = studentDob;
		this.studentPlace = studentPlace;
		this.studentAddress = studentAddress;
	}

	public StudentModel() {
		// TODO Auto-generated constructor stub
	}
}