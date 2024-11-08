package com.jsp.student_restApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.student_restApi.dto.Student;
import com.jsp.student_restApi.service.StudentService;

@RestController
public class MainController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/student")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student){
		return service.registerStudent(student);
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> fetchStudent(){
		return service.fetchStudent();
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<String> updateStudenet(@PathVariable int id, @RequestBody Student student){
		return service.udpadeStudent(id,student);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudenet(@PathVariable int id){
		return service.deleteStudent(id);
	}
}









