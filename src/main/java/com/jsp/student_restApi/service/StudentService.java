package com.jsp.student_restApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.student_restApi.dto.Student;

public interface StudentService {

	ResponseEntity<Student> registerStudent(Student student);

	ResponseEntity<List<Student>> fetchStudent();

	ResponseEntity<String> udpadeStudent(int id, Student student);

	ResponseEntity<String> deleteStudent(int id);
	
}
