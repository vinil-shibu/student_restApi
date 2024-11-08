package com.jsp.student_restApi.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import com.jsp.student_restApi.dto.Student;
import com.jsp.student_restApi.repository.StudentRepository;
import com.jsp.student_restApi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public ResponseEntity<Student> registerStudent(Student student) {
		return new ResponseEntity<Student>(repository.save(student), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Student>> fetchStudent() {
		List<Student> students = repository.findAll();
		if (students.isEmpty())
			return new ResponseEntity<List<Student>>(students, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Student>>(students, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<String> udpadeStudent(int id, Student student) {
		if (repository.existsById(id)) {
			repository.save(student);
			return new ResponseEntity<String>("Data Updated Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not Data Found", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<String> deleteStudent(int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return new ResponseEntity<String>("Data Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not Data Found", HttpStatus.NOT_FOUND);
		}
	}

}
