<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
  <body>
<h1>Welcome to Login Page </h1>
  <hr>
      <div align="center">
         <form action="log" method="post">
            <label>User Name : </label>
            <input type="text" placeholder="Enter UserName"name="uname"><br><br>
            <label>Password : </label>
            <input type="text" placeholder="Enter Password"name="pass"><br><br>
            <input type="Submit" value="Login">
        </form>
      </div>
   </body>
</html>