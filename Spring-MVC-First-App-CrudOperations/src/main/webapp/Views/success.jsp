<%@page import="com.cjc.model.Student"%>
 <%@page import="java.util.List"%> 
 <%@ page language="java" contentType="text/html; 
 charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html>
   <html>
    <head> 
    <meta charset="ISO-8859-1"> 
    <title>Insert title here</title>
<script type="text/javascript"> function addStudent() 
{
    alert("Add New Student");  
    document.myForm.action="Registeration";
}
function editStudent()
{ alert("Edit Student"); 
   document.myForm.action="edit";
   document.myForm.submit();
}
function deleteStudent()
{
	alert("Student is Deleting");
    document.myForm.action="delete"; 
    document.myForm.submit();
    }
</script>
</head> 

<body style="background-color: #ff6666">

<%List<Student> stuList = (List<Student>)request.getAttribute("data"); %>
<div align="center">
 <h1>Login Success Welcome to CJC Dashboard</h1> 
 </div> 
 <div align="center"> 
 <hr>
  <h2 style="color: white">************** Student Details *****************</h2>
<form name="myForm">
<table border="5px" cellspacing="20px"> 
<thead style="color: white;"> 
<tr>
 <th>Select</th>
  <th>Rollno</th> 
  <th>Name</th> 
  <th>Marks</th> 
  <th>Mobile</th>
  <th>Address</th>

</tr> 
</thead> 
<tbody style="color: yellow;"> 
<%for(Student student : stuList) { %>
<tr>
<td>
<input type="radio" name="rollno" value="<%=student.getRollno()%>">
</td> 
<td><%=student.getRollno()%></td> 
<td><%=student.getName()%></td> 
<td><%=student.getMarks()%></td> 
<td><%=student.getMobile()%></td> 
<td><%=student.getAddress()%></td>
</tr>
    <% } %>
</tbody> </table>
<div style="padding-top: 30px"> <input type="submit" onclick="addStudent()" value="ADD"> 
<input type="submit" onclick="editStudent()" value="EDIT"> 
<input type="submit" onclick="deleteStudent()" value="DELETE">
 </div>
</form> 
</div>
</body>
 </html>














