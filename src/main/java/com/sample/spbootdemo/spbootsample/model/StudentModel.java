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

    @Column(name = "place")
    private String place;

    @Column(name = "address")
    private String address;

    @Column(name = "roll_number")
    private String rollNumber;

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "StudentModel [studentId=" + studentId + ", studentName=" + studentName + ", studentDob=" + studentDob
                + ", place=" + place + ", address=" + address + ", rollNumber=" + rollNumber + "]";
    }

    public StudentModel(Integer studentId, String studentName, String studentDob, String place, String address,
            String rollNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDob = studentDob;
        this.place = place;
        this.address = address;
        this.rollNumber = rollNumber;
    }

    public StudentModel() {
    }
}

