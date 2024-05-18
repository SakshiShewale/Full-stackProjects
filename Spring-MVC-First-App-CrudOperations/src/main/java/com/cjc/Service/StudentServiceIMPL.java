package com.cjc.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.cjc.Dao.StudentDao;
import com.cjc.model.Student;

@Service
public class StudentServiceIMPL implements StudentService{
    

@Autowired 
private StudentDao studentDao;
public void saveStudent(Student student)
{ 
	System.out.println("Student in Service "+student); 
	studentDao.saveStudent(student);
  }
	public List<Student> loginCheck(String uname, String pass)
	{
		if (uname.equals("Admin") && pass.equals("Admin@123"))
		return studentDao.getAllStudent();
		else
		return new ArrayList<Student>();
		
	}
		
	public List<Student> deleteStudent(int rollno) 
	{
		return studentDao.deleteStudent(rollno);
	
	}
	public Student editStudent(int rollno)
	{
		return studentDao.editStudent(rollno);
		}
	public List<Student> updateStudent(Student student) 
	{
		return studentDao.updateStudent(student);
	
	}
	
}



