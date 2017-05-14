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
	<form method="post" action="PassengerDetailsServlet">
		<input type="hidden" name="action" value="passenger_details" />
		TicketId<input type="text" name="ticketId" id="ticketId"
			placeholder="ticketId" /><br> Name<input type="text" name="name"
			id="name" placeholder="name" /><br> Seat_No<input type="text"
			name="seatNo" id="seatno" placeholder="seatno" /><br> Gender<input
			type="radio" name="gender" id="male" value="male"> Male </input> <input
			type="radio" name="gender" id="female" value="female"> Female
		</input><br> Age<input type="text" name="age" id="age" placeholder="age" />

		<br>
		<center>
			<input type="submit" value="submit">
		</center>

	</form>

</body>
</html>