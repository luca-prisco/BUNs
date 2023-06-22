<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BUNs - Login</title>
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link rel="stylesheet" href="css/login.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Alata&display=swap" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@400&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="all">
		<%@ include file="/include/header.jsp"%>
		<div class="content">
			<form method="post" action="Login" id="form" class="form">
				<div class="form-top">
					<h1>Login</h1>
				</div>
				<div class="input-control">
					<label for="email">Email</label> 
					<input type="text" name="email" id="email" required>
				</div>
				<div class="input-control">
					<label for="password">Password</label> 
					<input type="password" name="password" id="password" required>
				</div>
				<button type="submit" class="login" value="submit" name="submit">Login</button>
			</form>
		</div>
		<%@ include file="/include/footer.jsp"%>
	</div>
</body>
</body>
</html>