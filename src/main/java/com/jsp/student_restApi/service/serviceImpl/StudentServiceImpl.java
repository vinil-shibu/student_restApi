package com.jsp.student_restApi.service.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import com.jsp.student_restApi.dto.Student;
import com.jsp.student_restApi.helper.ResponseStructure;
import com.jsp.student_restApi.repository.StudentRepository;
import com.jsp.student_restApi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;
	
	@Autowired
	ResponseStructure<Student> structure;
	
	@Autowired
	ResponseStructure<List<Student>> structure2;

	@Override
	public ResponseEntity<ResponseStructure<Student>> registerStudent(Student student) {
		structure.setMessage("Data Save Success");
		structure.setData(repository.save(student));
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Student>>> fetchStudent() {
		List<Student> students = repository.findAll();
		if (students.isEmpty()) {
			throw new NoSuchElementException("Data Not Found");
		} else {
			structure2.setMessage("Data Found Success");
			structure2.setStatus(HttpStatus.FOUND.value());
			structure2.setData(students);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure2, HttpStatus.FOUND);
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Student>> udpadeStudent(Student student) {
		structure.setMessage("Data Update Success");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(repository.save(student));
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {
		if (repository.existsById(id)) {
			structure.setMessage("Data Deletion Success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(repository.findById(id).orElseThrow());
			repository.deleteById(id);
			
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementException("Data Not Found");
		}
	}

}
