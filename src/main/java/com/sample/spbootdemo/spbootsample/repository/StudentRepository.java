package com.sample.spbootdemo.spbootsample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.spbootdemo.spbootsample.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer>{

}
