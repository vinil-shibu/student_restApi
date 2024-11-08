package com.jsp.student_restApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.student_restApi.dto.Student;
import com.jsp.student_restApi.helper.ResponseStructure;

public interface StudentService {

	ResponseEntity<ResponseStructure<Student>> registerStudent(Student student);

	ResponseEntity<ResponseStructure<List<Student>>> fetchStudent();

	ResponseEntity<ResponseStructure<Student>> udpadeStudent(Student student);

	ResponseEntity<ResponseStructure<Student>> deleteStudent(int id);
	
}
