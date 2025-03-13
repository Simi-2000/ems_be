package com.sample.spbootdemo.spbootsample.service;

import java.util.List;
import com.sample.spbootdemo.spbootsample.model.StudentModel;

public interface StudentService {
    StudentModel insertNewStudent(StudentModel model);
    StudentModel updateStudent(StudentModel model);
    List<StudentModel> viewAllStudent();
    StudentModel viewOneStudent(Integer studentId);

    // Add delete method in the interface
    boolean deleteStudent(Integer studentId);  // Return boolean to indicate success/failure
}
