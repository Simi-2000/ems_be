package com.sample.spbootdemo.spbootsample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spbootdemo.spbootsample.model.StudentModel;
import com.sample.spbootdemo.spbootsample.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository repository;

	@Override
	public StudentModel insertNewStudent(StudentModel model) {
		
		return repository.save(model);
	}

	@Override
	public StudentModel updateStudent(StudentModel model) {
		Optional<StudentModel> op = repository.findById(model.getStudentId());
		if (!op.isEmpty()) {
			return repository.save(model);
		}
		return new StudentModel();
	}

	@Override
	public List<StudentModel> viewAllStudent() {
		return repository.findAll();
	}

	@Override
	public StudentModel viewOneStudent(Integer studentId) {

		Optional<StudentModel> op = repository.findById(studentId);
		if (!op.isEmpty()) {
			return op.get();
		}
		return new StudentModel();
	}

	@Override
	public StudentModel deleteStudent(Integer studentId) {
		Optional<StudentModel> op = repository.findById(studentId);
		if (!op.isEmpty()) {
			repository.deleteById(studentId);
			return op.get();
		}
		return new StudentModel();
	}
	


}
