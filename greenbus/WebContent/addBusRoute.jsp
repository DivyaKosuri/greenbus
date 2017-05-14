
<%@ page language="java" contentType="text/html"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.svecw.greenbus.dao.BusTypeDAO"%>
<%@page import="com.svecw.greenbus.dto.BusType"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<style>
@import
url(design.css)
</style>
<script>
	
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h3>${successMessage}${errorMessage}</h3>
	<form action="AdminServlet" method="post">
	
	
		<input type="hidden" name="action" value="bus_route" />
		<center>
			Source<select id="source" name="source" class="source"><br>

				<c:forEach var="route" items="${routeList}">
					<option value="${route.source}" >${route.source}</option>
				</c:forEach>
			</select>
			</center>
			<center>
			Destination<select id="destination" name="destination" class="destination"><br>

				<c:forEach var="route" items="${routeList}">
					<option value="${route.destination}" >${route.destination}</option>
				</c:forEach>
			</select>
			</center>
		<center>
			RegistrationNo <select id="registrationNo" name="registrationNo" class="registrationNo"><br>

				<c:forEach var="bus" items="${busList}">
					<option value="${bus.registrationNo}" >${bus.registrationNo}</option>
				</c:forEach>
			</select>
		</center>
		<br>
		<center>
			ArrivalTime <input type="text" name="arrivalTime"></input>
		</center>
		<br>
		<center>
			DepatureTime <input type="text" name="departureTime"></input>
		</center>
		<br> 
		 <br>
		<center>
			<input type="submit" value="submit">
		</center>
	</form>
</body>
</html>