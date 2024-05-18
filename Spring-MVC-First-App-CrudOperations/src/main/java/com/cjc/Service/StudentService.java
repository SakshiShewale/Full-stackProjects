package com.cjc.Service;

import java.util.List;

import com.cjc.model.Student;

public interface StudentService {

	void saveStudent(Student student);
	List<Student> loginCheck(String uname, String pass);
	List<Student> deleteStudent(int rollno);
	Student editStudent(int rollno);
	List<Student> updateStudent(Student student);
	
	 
}
