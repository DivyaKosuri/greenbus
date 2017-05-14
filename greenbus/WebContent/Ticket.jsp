<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${successMessage}${errorMessage}</h3>
	<form method="post" action="TicketServlet">
		<input type="hidden" name="action" value="ticket" /> RegistrationNo<input
			type="text" name="registrationNo" id="regno"
			placeholder="registrationNo" /><br> RouteId<input type="text"
			name="routeId" id="routeid" placeholder="RouteId" /><br> Date<input
			type="text" name="journeyDate" id="date" placeholder="date" /><br>
		UserId<input type="text" name="userId" id="userId"
			placeholder="userId" /><br> <br>
		<center>
			<input type="submit" value="submit">
		</center>
	</form>
</body>
</html>