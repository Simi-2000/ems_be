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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_dob")
    private String studentDob;

    
    // Getters and Setters
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    

    // toString() method
    @Override
    public String toString() {
        return "StudentModel [studentId=" + studentId + ", studentName=" + studentName +
                ", studentDob=" + studentDob + "]";
    }

    // Parameterized Constructor
    public StudentModel(Integer studentId, String studentName, String studentDob) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDob = studentDob;
       
    }

    // Default Constructor
    public StudentModel() {
    }
}
