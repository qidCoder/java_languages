<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert name here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>

<div class="container">
	<h1>Languages</h1>
	<a href="/">Dashboard</a>
	

						<p>${language.name}</p>
						<p>${language.creator}</p>
						<p>${language.version}</p>
						<a href="/delete/${language.id }">Delete</a>
						<a href="/update/${language.id }">Edit</a>
			
	

</div>

</body>
</html>