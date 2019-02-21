<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Articles</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</head>

<body class="container">

<h1><spring:message code="article.list.title"/></h1>

<a href="addDVD" class="btn btn-link">Nouveau DVD</a>
<a href="addDB" class="btn btn-link">Nouveau Blue Ray</a>
<table class="table">
		<tr>
			<th><spring:message code="article.list.header.id"/></th>
			<th><spring:message code="article.list.header.nbDisques"/></th>
			<th></th>
		</tr>
		<c:forEach var="article" items="${listeArticles}">
			<tr>
				<td>${article.id}</td>
				<td>${article.nbDisques}</td>
				<td><a href="delete?id=${article.id}" class="btn btn-danger"><spring:message code="list.delete"/></a></td>
			</tr>
		</c:forEach>
</table>
</html>