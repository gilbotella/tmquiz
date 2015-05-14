<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="m" uri="http://www.spring-monet.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>TmQuiz</title>
	<jsp:include page="includes.jsp" />
</head>
<body>
	<jsp:include page="languages.jsp" />

	<div class="container">
		<div class="controls span2">
			<table class="table table-striped">
				<tr><td><spring:message code="example.Pending" />:</td><td>${quiz.numPending}</td></tr>
				<tr><td><spring:message code="example.Ok" />:</td><td>${quiz.numCorrect}</td></tr>
				<tr><td><spring:message code="example.Casi" />:</td><td>${quiz.numSimilar}</td></tr>
				<tr><td><spring:message code="example.Ko" />:</td><td>${quiz.numFailed}</td></tr>
			</table>
		</div>
		<div class="controls span7">
			<table>
			<c:forEach items="${quiz.questions}" var="tm" varStatus="cont">
				<c:if test="${cont.count%quiz.level.size==1}"><tr></c:if>
					<td width="80px">
	
			<table class="table table-bordered" style="margin-bottom: 3px">
				<tr><td style="height:70px;vertical-align:middle"><img src="${tm.value.tm.urllogo}" width="60px" style="width:60px"><br /></td></tr>
			<c:choose>
				<c:when test="${tm.value.state == \"FAILED\"}">
					<tr class="error"><td><a id="btn${tm.value.tm.id}" class="btn btn-danger btn-small btn-block" href="<c:url value="/question/${tm.value.tm.id}" />"><spring:message code="example.No" /> <i class="icon-remove icon-white"></i></a></td></tr>
				</c:when>
				<c:when test="${tm.value.state == \"CORRECT\"}">
					<tr class="success"><td><a id="btn${tm.value.tm.id}" class="btn btn-success btn-small btn-block" href="#"><spring:message code="example.Ok2" /> <i class="icon-ok icon-white"></i></a></td></tr>
				</c:when>
				<c:when test="${tm.value.state == \"SIMILAR\"}">
					<tr class="warning"><td><a id="btn${tm.value.tm.id}" class="btn btn-warning btn-small btn-block" href="<c:url value="/question/${tm.value.tm.id}" />"><spring:message code="example.Near" /> <i class="icon-repeat icon-white"></i></a></td></tr>
				</c:when>
				<c:otherwise>
					<tr><td><a id="btn${tm.value.tm.id}" class="btn btn-small btn-block" href="<c:url value="/question/${tm.value.tm.id}" />"><spring:message code="example.ToDo" /></a></td></tr>
				</c:otherwise>
			</c:choose>
				
			</table>
					</td>
				<c:if test="${cont.count== 0}"><tr></c:if>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
