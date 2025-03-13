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
        // Check if any of the required fields are missing
        if (model.getStudentDob() == null || model.getStudentName() == null || model.getRollNumber() == null) {
            return new StudentModel(null, null, null, null, null, null); // Return empty object if missing fields
        }

        // Check for duplicate student (by name or roll number)
        List<StudentModel> existingStudents = viewAllStudent();
        boolean isDuplicate = existingStudents.stream().anyMatch(std ->
            std.getStudentName().equals(model.getStudentName()) || std.getRollNumber().equals(model.getRollNumber())
        );

        if (isDuplicate) {
            return new StudentModel(null, null, null, null, null, null); // Return empty object if duplicate found
        }

        // Save the new student
        return repository.save(model);
    }

    @Override
    public StudentModel updateStudent(StudentModel model) {
        // Ensure all required fields are present before updating
        if (model.getStudentId() == null || model.getStudentDob() == null || model.getStudentName() == null || model.getRollNumber() == null) {
            return new StudentModel(null, null, null, null, null, null); // Return empty object if missing fields
        }

        // Find student by ID and update
        Optional<StudentModel> existingStudent = repository.findById(model.getStudentId());
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
        // Find student by ID and return if found
        Optional<StudentModel> op = repository.findById(studentId);
        return op.orElse(new StudentModel()); // Return the student or an empty StudentModel if not found
    }

    // Add deleteStudent method to delete a student by ID
    @Override
    public boolean deleteStudent(Integer studentId) {
        Optional<StudentModel> student = repository.findById(studentId); // Check if the student exists
        if (student.isPresent()) {
            repository.deleteById(studentId);  // Delete the student if found
            return true;  // Return true if deletion was successful
        } else {
            return false;  // Return false if student not found
        }
    }
}
