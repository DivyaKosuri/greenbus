<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
@import url(generallayout.css);

@import url(my.css);
.btn{
width:183px;
font-size:25px
}
</style>
</head>
<body>

	<div id="container">
		<table style="background-color: green">
			<div id="header">
				<div id="header1">
					<tr>
						<td><img class="img-thumbnail" src="logo.jpg" width=100px>
						</td>
				</div>
				<td>
					<div id="header2">
						<div class="btn-group">
							<button type="button" class="btn btn-success">
								<a href="http://localhost:8080/greenbus/addBusType.jsp"style="color:white">Add Bus Type</a>
							</button>
							<button type="button" class="btn btn-success">
								<a href="http://localhost:8080/greenbus/AdminServlet?action=show_bus_form"style="color:white">Add Bus</a>
							</button>
							<button type="button" class="btn btn-success">
								<a href="http://localhost:8080/greenbus/AdminServlet?action=show_bus_route_form"style="color:white">Bus Schedule</a>
							</button>
							<button type="button" class="btn btn-success">
							<a href="http://localhost:8080/greenbus/addRoute.jsp"style="color:white">Add Route</a>
							</button>
							<button type="button" class="btn btn-success">
							<a href="http://localhost:8080/greenbus/AdminServlet?action=search_form"style="color:white">Search Buses</a>
							</button>
							<button type="button" class="btn btn-success">
							<a href="http://localhost:8080/greenbus/AdminServlet?action=logout"style="color:white">Logout</a>
							</button>
						</div>
					</div>
				</td>
				</tr>
			</div>
		</table>
		<div id="main">
		<img src="image2.jpg"width="1480px"height="700px">
		</div>
        <div id="footer">
        <br><h3>Copyrights reserved</h3>
        </div>

	</div>