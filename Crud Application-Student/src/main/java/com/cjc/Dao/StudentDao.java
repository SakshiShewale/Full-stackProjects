package com.cjc.Dao;

import java.util.List;

import com.cjc.model.Student;

public interface StudentDao {

	void saveStudent(Student student);
	List<Student> getAllStudent();
	List<Student> deleteStudent(int rollno);
	Student editStudent(int rollno);
	List<Student> updateStudent(Student student);


}
