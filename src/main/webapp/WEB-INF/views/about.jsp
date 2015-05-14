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
		<h1>TMquiz</h1>
		<p>Este juego fue diseñado como prueba de concepto de testing:</p>
		<ul>
			<li>Unitario: jUnit</li>
			<li>Integración</li>
			<li>Selenium</li>
		</ul>

		<p>Tanto la librería de renderizado como el juego TMquiz puede ser descardo del repositorio de Github:
			<a href="https://github.com/gilbotella">https://github.com/gilbotella</a>
		</p>

		<br /><br />
		<address>
			<strong>Julián Gil</strong><br>
			Dr. Marañón 20, 3A<br>
			Aspe 03680<br>
			<abbr title="Phone">P:</abbr> (123) 456-7890
		</address>

		<address>
			<strong>Twitter</strong><br>
			@gilbotella
		</address>

		<address>
			<strong><a href="mailto:julian_gil@ieci.es">julian_gil@ieci.es</a></strong>
		</address>
    </div>
</body>
</html>