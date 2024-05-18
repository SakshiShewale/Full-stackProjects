<%@page import="com.cjc.model.Student"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html> 
<html> 
<head>
 <meta charset="ISO-8859-1"> 
<title>Insert title here</title>
 </head> 
 <body style="background-color: #3e2b6e">
 <div align="center"> 
 <h1 style="color: yellow;">Welcome to Update</h1>
</div> 
  <hr> 
 <div align="center" 
      style="padding-top: 30px; background-color: #715cb8 ;color: white">
      
 <%Student student = (Student)request.getAttribute("stu");%>
<form action="up" method="post">
<label>Rollno     :  <%=student.getRollno()%>
 </label> 
 <input type="hidden" name="rollno" placeholder="Enter Rollno" value="<%=student.getRollno()%>"> <br><br> 
<label>Name         : </label> 
<input type="text" name="name" placeholder="Enter Name" value="<%=student.getName()%>"> <br><br> 
<label>Marks        : </label> 
<input type="text" name="marks" placeholder="Enter Marks" value="<%=student.getMarks()%>"> <br><br> 
<label>Mobile Number : </label>
 <input type="text" name="mobile" placeholder="Enter Mobile Number" value="<%=student.getMobile()%>"> <br><br> 
<label>Address       : </label>
 <input type="text" name="address" placeholder="Enter Addresss " value="<%=student.getAddress()%>"> <br><br> 
<input type="submit" value="UPDATE"> 
</form>
</div> 
</body> 
</html>