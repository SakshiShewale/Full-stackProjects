package com.cjc.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.model.Student;
@Repository
public class StudentDaoIMPL implements StudentDao {

@Autowired 
private SessionFactory factory;

public void saveStudent(Student student) 
{ 
   System.out.println("Student in Repository " + student);
   Session session = factory.openSession(); 
   session.save(student); 
   session.beginTransaction().commit(); 
 }
public List<Student> getAllStudent() 
{
    Session session = factory.openSession();
    Query query = session.createQuery("from Student");
    List<Student> resultList = query.getResultList();
   return resultList;
   }

public List<Student> deleteStudent(int rollno)
{
          Session session = factory.openSession();
          session.beginTransaction();
          Query query = session.createQuery("delete from Student where rollno = :id");
          query.setParameter("id", rollno);
          query.executeUpdate(); 
          session.getTransaction().commit();
        return getAllStudent();
}
 
public Student editStudent(int rollno) 
    {
            return factory.openSession().get(Student.class, rollno);
     }
public List<Student> updateStudent(Student student) 
{    
	Session session = factory.openSession();   
	session.beginTransaction(); 
	session.update(student); 
	session.getTransaction().commit(); 
	return getAllStudent(); 
	}
}