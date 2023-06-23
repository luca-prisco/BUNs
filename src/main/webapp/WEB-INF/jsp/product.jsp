<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="it-IT" xml:lang="it-IT">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/product.css" type="text/css">
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

<%
session.setAttribute("jspName", "product.jsp");
Prodotto p = (Prodotto) request.getAttribute("prodotto");
String pathImg = "img/prodotti/" + p.getIdProdotto() + ".png";
%>
<title><%=p.getNome()%></title>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<div class="content">
		<div class="prod__card">
			<div class="prod__image">
				<img src="<%=pathImg%>" alt="IMG PRODOTTO">
			</div>
			<div class="prod__info">
				<h1>${prodotto.nome}</h1>
				<div class="prod__price">
					<p>${prodotto.prezzo}&euro;</p>
				</div>
				<div class="dettagli">
					<p>${prodotto.dettagli}</p>
				</div>
				<form action="CarrelloServlet">
					<select name="quantita" id="quantita">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
					</select> 
					<br>
					<input id="ordernow" type="submit" value="Aggiungi al carrello">
				</form>
				<div id="myPopup" class="popup">
					<div class="modal-content">
						<span class="close">&times;</span>
						<p>${prodotto.nome} aggiunto al carrello</p>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div class="di__interesse">
		<h2>Potrebbero interessarti</h2>
		<div class="grid_panini">
			<div class="panino">
				<img src="img/panini/gran-crispy-mcbacon.png" alt="foto panino">
				<p>Gran Crispy Bacon</p>
			</div>
			<div class="panino">
				<img src="img/panini/gran-crispy-mcbacon.png" alt="foto panino">
				<p>nome panino</p>
			</div>
			<div class="panino">
				<img src="img/panini/gran-crispy-mcbacon.png" alt="foto panino">
				<p>nome panino</p>
			</div>
			<div class="panino">
				<img src="img/panini/gran-crispy-mcbacon.png" alt="foto panino">
				<p>nome panino</p>
			</div>

		</div>
	</div>


	<%@ include file="/include/footer.jsp"%>
	<script>
	var popup = document.getElementById("myPopup");
	var btn = document.getElementById("ordernow");

	btn.onclick = function() {
	  popup.style.display = "block";
	}
	
	window.onclick = function(event) {
	  if (event.target == popup) {
	    popup.style.display = "none";
	  }
	}
	</script>
</body>
</html>