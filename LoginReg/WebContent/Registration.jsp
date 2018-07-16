<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="tableDiv">
<form action="registerUser" method="post">
<table>
  <tr>
  	
    <td> UserName:- </td>
    <td> <input type="text" name="userName"> </td>
  </tr>
    <tr>
    <td> FullName:- </td>
    <td> <input type="text" name="fullName"> </td>
  </tr>
  <tr>
    <td> Email:- </td>
    <td> <input type="text" name="email"> </td>
  </tr>
  <tr>
    <td> Password:-:- </td>
    <td> <input type="password" name="pass1"> </td>
  </tr>
  <tr>
    <td> Retype-Password:- </td>
    <td> <input type="password" name="pass2"> </td>
  </tr>
   <tr>
    <td colspan="2"> <input type="submit" value="register"> </td>
  </tr>

</table>

</form>
</div>
</body>
</html>