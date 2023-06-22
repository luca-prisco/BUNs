<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/pagamento.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Alata&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@400&display=swap"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
<title>Pagamento</title>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<div class="content">
		<form method="post" id="pagamentoForm" action="CheckoutServlet" onsubmit="return validate()">
				<div class="form-top">
					<h1>Pagamento</h1>
				</div>
				<div class="input-control">
					<label for="intestatario">Nome e cognome intestatario</label>
						<input type="text" name="intestatario" id="intestatario" required pattern="^[A-Z\sa-z]+$" placeholder="Mario Rossi"
						onchange="validateFormElem(this, document.getElementById('errorIntestatario'), intestatarioErrorMessage)">
						<span id="errorIntestatario"></span>
				</div>
				<div class="input-control">
					<label for="numeroCarta">Numero carta</label>
						<input type="text" name="numeroCarta" id="numeroCarta" required pattern="^(?:5[1-5][0-9]{2}) [0-9]{4} [0-9]{4} [0-9]{4}$" placeholder="5555 4444 3333 2222"
						onchange="validateFormElem(this, document.getElementById('errorNumeroCarta'),numCartaErrorMessage)">
						<span id="errorNumeroCarta"></span>
				</div>
				<div class="input-control">
					<label for="dataScadenza">Data scadenza</label>
						<input type="text" name="dataScadenza" id="dataScadenza" required pattern="^(0[1-9]|1[0-2])\/?([0-9]{2})$" placeholder="xx/xx"
						onchange="validateFormElem(this, document.getElementById('errorDataScadenza'),dataScadenzaErrorMessage)">
						<span id="errorDataScadenza"></span>
				</div>
				<div class="input-control">
					<label for="CVV">CVV</label>
						<input type="text" name="CVV" id="CVV" required pattern="^([0-9]{3})$" placeholder="xxx"
						onchange="validateFormElem(this, document.getElementById('errorCVV'),CVVErrorMessage)">
						<span id="errorCVV"></span>
				</div>
				<div>
					<input class="ordina" type="submit" value="Ordina">
				</div>
		</form>
	</div>
	
	<%@ include file="/include/footer.jsp"%>
	<script src="scripts/validatePag.js"></script>
</body>
</html>