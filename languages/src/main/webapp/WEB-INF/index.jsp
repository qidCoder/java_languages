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
	<h1>Languages</h1>
	
	<!-- display all in a table -->
			<table class="table table-dark">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				<!-- loop through arraylist -->
				<c:forEach items="${allLanguages}" var="language">
					<tr>
						<td><a href="/show/${language.id}">${language.name}</a></td>
						<td>${language.creator}</td>
						<td>${language.version}</td>
						<td><a href="/delete/${language.id }">Delete</a> | <a href="/update/${language.id }">Edit</a></td>
					</tr>
				
				</c:forEach>
			
			</tbody>
		</table>
	
	<!-- form to add a new language -->		
		<form:form method="POST" action="/add" modelAttribute="language">
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
			
			<button>Submit New Language</button>
			
		</form:form>
</div>

</body>
</html>