<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Random" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Card Preview</title>
</head>
<body>

<center style="margin-top:200px">
<div style="border:3px solid black; width:200px">


<%! Random rand = new Random(); %>


	<%--
	<%
	if (request.getSession().getAttribute("name") == null) {
		response.sendRedirect(request.getContextPath());
	}
	%>
	
	--%>

<img src="https://cdn.pixabay.com/photo/2017/11/10/05/48/user-2935527_1280.png"  width="200" height="200"/>
<br/>
<h1 style="margin:0">
<%= request.getAttribute("fname") %>
</h1>
<br/>
<h2 style="margin:0">
<%= request.getAttribute("phone") %>
</h2>
<br/>
<h6 style="margin:0;color:red">
<%= request.getAttribute("name")%>
</h6>

</div>


</center>
<h6 style="margin:0;color:red">
<%= rand.nextInt(10000) %>
</h6>

</body>
</html>