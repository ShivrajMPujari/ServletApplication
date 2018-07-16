<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.bridgeIt.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<% 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

User user = (User)session.getAttribute("userObj");
Cookie cookies[] = request.getCookies();
String userName = null;
String JSessionId = null;
for(Cookie cookie : cookies){
	
	if(cookie.getName().equals("user")){userName = cookie.getValue();}
	if (cookie.getName().equals("JSESSIONID")){JSessionId = cookie.getValue(); }
}

if(userName==null){
	
	response.sendRedirect("index.jsp");
	
}else{

%>

<h3>welcome <%= userName%>,</h3>

<%-- <h3>welcome <%= userName%>,</h3>   action="logout" --%>
<p> your session id is <%= JSessionId %></p>

<form action="logout" method="post">

<input type="submit" value="logout">

</form>
<%} %>
</body>
</html>