package com.sample.spbootdemo.spbootsample.service;

import java.util.Iterator;
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
//	List<StudentModel> list= repository.findByStudentName(model.getStudentName());
//	if(list.size()!=0) {
//		return new StudentModel(null,null,null);
//	}
		List<StudentModel> slist = viewAllStudent();
		if (model.getStudentId() == null && (model.getStudentDob() == null || model.getStudentName() == null)) {
			return new StudentModel(null, null, null);
		}
		for (StudentModel std : slist) {
			if (std.getStudentName().equals(model.getStudentName())) {
				return new StudentModel(null, null, null);
			}
		}
		return repository.save(model);
	}

	@Override
	public StudentModel updateStudent(StudentModel model) {
		if (model.getStudentId() == null || model.getStudentDob() == null || model.getStudentName() == null) {
			return new StudentModel(null, null, null);
		}
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

}
