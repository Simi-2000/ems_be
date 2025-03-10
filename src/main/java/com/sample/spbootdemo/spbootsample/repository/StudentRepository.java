package com.sample.spbootdemo.spbootsample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.spbootdemo.spbootsample.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer>{

	List<StudentModel> findByStudentName(String studentName);
	
}
