
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
	
	
		<input type="hidden" name="action" value="bus" />
		<center>
			Registration Number<input type="text" name="registrationNo"></input>
		</center>
		<br>
		<center>
			BusTypeName <select id="busTypeId" name="busTypeId" class="busTypeId"><br>

				<c:forEach var="busType" items="${busTypesList}">
					<option value="${busType.busTypeId}" >${busType.name}</option>
				</c:forEach>
			</select>
		</center>
		<br>
		<center>
			SeatCount <input type="text" name="seatCount"></input>
		</center>
		<br> <br>
		<center>
			<input type="submit" value="submit">
		</center>
	</form>
</body>
</html>