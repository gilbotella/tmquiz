<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="includes.jsp" />
</head>
<body>
	<jsp:include page="languages.jsp" />

	<div class="container">
		<h1><spring:message code="example.Congratulations" /></h1>
		<p>
			<spring:message code="example.Resolved" arguments="${time}"  />
		</p>
    </div>
</body>
</html>