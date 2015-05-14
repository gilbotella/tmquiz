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
		<h1><spring:message code="example.Wellcome" /></h1>
		<p class="lead"><spring:message code="example.Description" /></p>

		<div class="btn-group">
			<a class="btn btn-large btn-primary" href="#"><spring:message code="example.NewGame" /></a>
			<a class="btn btn-large btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="<c:url value="/newGame/easy" />"><i class="icon-thumbs-down"></i>&nbsp;&nbsp;<spring:message code="example.Easy" /> (3x3)</a></li>
				<li><a href="<c:url value="/newGame/medium" />"><i class="icon-hand-right"></i>&nbsp;&nbsp;<spring:message code="example.Medium" /> (4x4)</a></li>
				<li><a href="<c:url value="/newGame/difficult" />"><i class="icon-thumbs-up"></i>&nbsp;&nbsp;<spring:message code="example.Difficult" /> (5x5)</a></li>
				<li class="divider"></li>
				<li><a href="<c:url value="/about" />"><i class="i"></i> <spring:message code="example.About" /></a></li>
			</ul>
		</div>

		<c:if test="${quiz != null}">
			<br /><br /><br />
			<p>
				<strong><spring:message code="example.GameRunning" /></strong><br />
				<a href="<c:url value="/newGame" />"><spring:message code="example.Resume" /></a>
			</p>
		</c:if>
    </div>
</body>
</html>