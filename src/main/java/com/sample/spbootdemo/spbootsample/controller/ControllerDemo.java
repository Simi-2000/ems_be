package com.sample.spbootdemo.spbootsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.spbootdemo.spbootsample.model.StudentModel;
import com.sample.spbootdemo.spbootsample.service.StudentService;

@RestController
@RequestMapping("advanced")
@CrossOrigin("http://localhost:3000")
public class ControllerDemo {

    @Autowired
    private StudentService service;

    @PostMapping("add")
    public ResponseEntity<StudentModel> insert(@RequestBody StudentModel model) {
        return new ResponseEntity<>(service.insertNewStudent(model), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel model) {
        return new ResponseEntity<>(service.updateStudent(model), HttpStatus.ACCEPTED);
    }

    @GetMapping("one")
    public ResponseEntity<StudentModel> viewOneStudent(@RequestParam Integer studentId) {
        return new ResponseEntity<>(service.viewOneStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<StudentModel>> viewAllStudent() {
        return new ResponseEntity<>(service.viewAllStudent(), HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Integer studentId) {
        boolean isDeleted = service.deleteStudent(studentId);
        if (isDeleted) {
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
}


