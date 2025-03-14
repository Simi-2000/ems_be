package com.sample.spbootdemo.spbootsample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spbootdemo.spbootsample.model.StudentModel;
import com.sample.spbootdemo.spbootsample.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repository;

	@Override
	public StudentModel insertNewStudent(StudentModel model) {
		if (model == null || model.getStudentName() == null || model.getStudentDob() == null
				|| model.getStudentPlace() == null || model.getStudentAddress() == null) {
			return new StudentModel();
		}
		return repository.save(model);
	}

	@Override
	public StudentModel updateStudent(StudentModel model) {
		if (model == null || model.getStudentName() == null || model.getStudentDob() == null
				|| model.getStudentRollNo() == null) {
			return new StudentModel();
		}
		Optional<StudentModel> existingStudent = repository.findById(model.getStudentRollNo());
		if (existingStudent.isPresent()) {
			return repository.save(model); // Update and save the student if exists
		}
		return new StudentModel(); // Return empty StudentModel if student not found
	}

	@Override
	public List<StudentModel> viewAllStudent() {
		return repository.findAll(); // Return all students from the database
	}

	@Override
	public StudentModel viewOneStudent(Integer studentId) {
		Optional<StudentModel> op = repository.findById(studentId);
		return op.orElse(new StudentModel()); // Return the student or an empty StudentModel if not found
	}

	// Add deleteStudent method to delete a student by ID
	@Override
	public boolean deleteStudent(Integer studentId) {
		if (studentId == null) {
			return false; // If studentId is null, we don't proceed with deletion
		}

		Optional<StudentModel> student = repository.findById(studentId); // Check if the student exists
		if (student.isPresent()) {
			repository.deleteById(studentId); // Delete the student if found
			return true; // Return true if deletion was successful
		} else {
			return false; // Return false if student not found
		}
	}
}
