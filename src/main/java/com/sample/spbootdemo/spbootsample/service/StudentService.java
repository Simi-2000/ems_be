package com.sample.spbootdemo.spbootsample.service;

import java.util.List;

import com.sample.spbootdemo.spbootsample.model.StudentModel;

public interface StudentService {
	 public StudentModel insertNewStudent(StudentModel model);
	   public StudentModel updateStudent(StudentModel model);
	   public List<StudentModel> viewAllStudent();
	   public StudentModel viewOneStudent(Integer studentId);
	  

}
