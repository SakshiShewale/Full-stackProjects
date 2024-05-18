 package com.cjc.Cotroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.Service.StudentService;
import com.cjc.model.Student;

@Controller 
public class StudentController 
{
@Autowired 
private StudentService service;
@RequestMapping("/") 
public String landingPage() 
{
  return "index";
}
@RequestMapping("/LoginPage")
public String loginPage()
 {
   return "Login";
 }
@RequestMapping("/Registeration") 
public String Registerationpage()
 {
  return "Registeration";
 }
@RequestMapping("/log")
public String loginCheck(@RequestParam String uname, @RequestParam String pass, Model model)
 {
    List<Student> list = service.loginCheck(uname, pass);
    System.out.println(list);
      if (!list.isEmpty())  
        { model.addAttribute("data", list);
        return "success"; 
        }
      else 
    	  return "Login";
}
@RequestMapping("/reg")
public String saveStudent(@ModelAttribute Student student) 
   { 
	System.out.println("Student in Controller " + student); 
	service.saveStudent(student);
    return "index";
   }
@RequestMapping("/delete")
public String deleteStudent(@RequestParam int rollno, Model model)
   {
       List<Student> list = service.deleteStudent(rollno);  
       model.addAttribute("data", list);
       return "success";
    }
@RequestMapping("/edit") 
 public String editStudent(@RequestParam int rollno, Model model) 
  {
        Student student = service.editStudent(rollno);
        model.addAttribute("stu", student); 
        return "update";
  }
@RequestMapping("/up") 
 public String updateStudent(@ModelAttribute Student student,Model model)
  {
          List<Student> list = service.updateStudent(student);
          model.addAttribute("data", list); 
          return "success";
}
} 

