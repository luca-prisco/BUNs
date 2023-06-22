<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BUNs - Registrati</title>
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link rel="stylesheet" href="css/registration.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Alata&display=swap" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@400&display=swap"
	rel="stylesheet">
	<% String x=" ";
		if(request.getAttribute("controllo")!=null){
			x="Email già presente!";
		}%>
</head>
<body>
	<div class="all">
		<%@ include file="/include/header.jsp"%>
		<div class="content">
			<form method="post" id="registrazioneForm" action="RegistrazioneServlet" onsubmit="return validate()">
				<div class="form-top">
					<h1>Registrazione</h1>
				</div>
				<div class="input-control">
					<label for="nome">Nome</label>
						<input type="text" name="nome" id="nome" required pattern="^[A-Za-z]+$" placeholder="Mario"
						onchange="validateFormElem(this, document.getElementById('errorNome'), nomeErrorMessage)">
						<span id="errorNome"></span>
				</div>
				<div class="input-control">
					<label for="nome">Cognome</label>
						<input type="text" name="cognome" id="cognome" required pattern="^[A-Za-z]+$" placeholder="Rossi"
						onchange="validateFormElem(this, document.getElementById('errorCognome'), cognomeErrorMessage)">
						<span id="errorCognome"></span>
				</div>
				<div class="input-control">
					<label for="nome">Indirizzo email</label>
						<input type="text" name="email" id="email" required pattern="^\S+@\S+\.\S+$" placeholder="mariorossi@gmail.com"
						onchange="validateFormElem(this, document.getElementById('errorEmail'), emailErrorMessage)">
						<span id="errorEmail"></span>
				</div>
				<div class="input-control">
					<label for="nome">Password</label>
						<input type="text" name="password" id="password" required pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" placeholder="minimo 8 caratteri"
						onchange="validateFormElem(this, document.getElementById('errorPassword'), passwordErrorMessage)">
						<span id="errorPassword"></span>
				</div>
				<div class="input-control">
					<label for="nome">Via</label>
						<input type="text" name="via" id="via" required pattern="^([A-Za-z]{3,5}\s[\sA-Za-z]{3,30}\s[0-9]{1,3})$" placeholder="Via Enrico Berlinguer 75"
						onchange="validateFormElem(this, document.getElementById('errorVia'), viaErrorMessage)">
						<span id="errorVia"></span>
				</div>
				<div class="input-control">
					<label for="nome">Città</label>
						<input type="text" name="citta" id="citta" required pattern="^[('A-Za-z\s)+]{3,40}$" placeholder="Pompei"
						onchange="validateFormElem(this, document.getElementById('errorCitta'), cittaErrorMessage)">
						<span id="errorCitta"></span>
				</div>
				<div class="input-control">
					<label for="nome">CAP</label>
						<input type="text" name="cap" id="cap" required pattern="^(\d{5})+$" placeholder="80048"
						onchange="validateFormElem(this, document.getElementById('errorCap'), CapErrorMessage)">
						<span id="errorCap"></span>
				</div>
				<div class="input-control">
					<label for="nome">Provincia</label>
						<input type="text" name="provincia" id="citta" required pattern="^[(A-Z)]{2}$" placeholder="NA"
						onchange="validateFormElem(this, document.getElementById('errorProvincia'), provinciaErrorMessage)">
						<span id="errorProvincia"></span>
				</div>
				<div>
					<input class="registrati" type="submit" value="Registrati">
				</div>
		</form>
		</div>
		<%@ include file="/include/footer.jsp"%>
	</div>
	<script src="scripts/validateReg.js"></script>
</body>
</html>