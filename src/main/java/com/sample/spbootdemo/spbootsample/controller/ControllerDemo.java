package com.sample.spbootdemo.spbootsample.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spbootdemo.spbootsample.model.StudentModel;
import com.sample.spbootdemo.spbootsample.service.StudentService;



@RestController
@RequestMapping("advanced") 
@CrossOrigin("http://localhost:3000")
public class ControllerDemo {

	@Autowired
	private StudentService service;
	
	@PostMapping("add")//GET http://localhost:8081/students/add
	public ResponseEntity<StudentModel> insert(@RequestBody StudentModel model){
		return new ResponseEntity<>(service.insertNewStudent(model),HttpStatus.CREATED);
	}
	
	@PutMapping("update")//POST http://localhost:8081/students/update
	public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel model){
		return new ResponseEntity<>(service.updateStudent(model),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("one")//GET http://localhost:8081/students/one/5
	public ResponseEntity<StudentModel> viewOneStudent(@RequestParam Integer studentId){
		return new ResponseEntity<>(service.viewOneStudent(studentId),HttpStatus.OK);
	}
	@GetMapping("all")// http://localhost:8081/students/all
	public ResponseEntity<List<StudentModel>> viewAllStudent(){
		return new ResponseEntity<>(service.viewAllStudent(),HttpStatus.OK);
	}
}