<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><!-- in order to use validations via JSTL -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert name here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>

<div class="container">
	<h1>Update</h1>
	<a href="/delete/${language.id}">Delete</a>
	<a href="/">Dashboard</a>
	
	
	<!-- form to add a new language -->		
		<form:form method="POST" action="/update/${language.id}" modelAttribute="language">
			<div class="form-group">
				<form:label path="name">Name:
					<form:errors path="name"/>
					<form:input path="name"/>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="creator">Creator:
					<form:errors path="creator"/>
					<form:input path="creator"/>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="version">Version:
					<form:errors path="version"/>
					<form:input path="version"/>
				</form:label>
			</div>
			
			<button>Update New Language</button>
			
		</form:form>
</div>

</body>
</html>