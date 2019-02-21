<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition d'un film</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>
	
</head>

<body class="container">
	<h1>Edition d'un film</h1>
	<form:form action="save" method="get" modelAttribute="film">
	
		<form:hidden path="version" />
		<div class="form-group">
			<form:label path="id">id:</form:label>
			<form:input path="id" cssClass="form-control" readonly="true" />
		<div class="form-group">
			<form:label path="dateSortie">date de sortie:</form:label>
			<form:input type="date" path="dateSortie" cssClass="form-control" />
		</div>
			<button type="submit" class="btn btn-success">enregistrer</button>
			<a href="list" class="btn btn-warning">annuler</a>
		</div>
	</form:form>

</body>
</html>