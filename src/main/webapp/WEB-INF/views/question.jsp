<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="m" uri="http://www.spring-monet.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>TmQuiz</title>
	<jsp:include page="includes.jsp" />
</head>
<body>
	<jsp:include page="languages.jsp" />

	<m:form id="form" method="post" class="form-horizontal" action="/tmquiz/response" modelAttribute="responseTm">
		<input type="hidden" value="${question.tm.id}" name="id" />

		<div class="controls span5">
			<table class="table table-bordered">
			<tr>
				<td><img src="${question.tm.urllogo}" width="100%"></td>
			</tr>
			<tr class="info">
				<td>
					<div class="input-append">
						<m:input path="tmname" cssClass="span3"  placeholder="Insert the name" />
						<button class="btn" type="submit">Go!</button>
					</div>
				</td>
			</tr>
			<tr class="info">
				<td>
					${question.tm.name}
				</td>
			</tr>
			</table>
		</div>
	</m:form>
</body>
</html>
