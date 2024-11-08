package com.jsp.student_restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.student_restApi.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
