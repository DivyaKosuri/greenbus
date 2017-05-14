
<%@ page language="java" contentType="text/html"%>
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
	<form  action="AdminServlet"
		method="post">
		<input type="hidden" name="action" value="bus_type" />
		<center>
			Bus Type<input type="text" name="busType"></input>
		</center>
		<br> <br> 
		<center>
			<input type="submit" value="submit">
		</center>
	</form>
</body>
</html>