<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Registration</title>
</head>
<body>
  <h2>Create New Account</h2>
   <form action="saveReg" method="post">
       first name<input type="text" name="firstName"/></br>
       last name<input type="text" name="lastName"/></br>
       email<input type="text" name="email"/></br>
       password<input type="text" name="password"/></br>
       <input type="submit" value="save"/>
   </form>
</body>
</html>