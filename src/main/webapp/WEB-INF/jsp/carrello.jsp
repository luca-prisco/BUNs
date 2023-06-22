<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/carrello.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Alata&display=swap" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@800&display=swap"
	rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<%
		Double prezzo = 0.0;
		Double totale = 0.0;
		ArrayList<Prodotto> carrello = (ArrayList<Prodotto>) session.getAttribute("cart-list");
		ArrayList<Integer> qList = (ArrayList<Integer>) session.getAttribute("quantitaArticoli");
	%>
<title>BUNs</title>
</head>
<body>
<%@ include file="/include/header.jsp"%>
<% if(carrello == null || carrello.size() == 0)
{%>
	<div class="content">
		<div class="cart-container">
			<h1>Il carrello e' vuoto</h1>
			<br><br>
			
			<%} 
			else if(carrello != null || carrello.size() > 0)
			{ %>
			<table>
				<h1>Carrello</h1>
				<% for(int i=0; i<carrello.size(); i++) {
					int id = carrello.get(i).getIdProdotto();
					String pathImg = "img/prodotti/" + id + ".png";
					String nome = carrello.get(i).getNome();
					String dettagli = carrello.get(i).getDettagli();
					prezzo = carrello.get(i).getPrezzo()*qList.get(i);
					totale+=carrello.get(i).getPrezzo()*qList.get(i);
				%>	
				<tr>
					<td>
						<div class="prodotto-carrello">
							<div class="image-prod">
								<img src="<%=pathImg %>" alt="foto non disponibile">
							</div>
							<div class="info-prod">
								<h3><%=nome %></h3>
								<p><%=dettagli %></p>
							</div>
							<div class="prezzo-prod">
								<h4><%=prezzo %>&euro;</h4>
							</div>
						</div>
					</td>
				</tr>
				<%} %>
			</table>
			
			<div class="cart-totale">
				<h3>Totale: <%=totale %>&euro;</h3>
				<a class="ordernow" href="PagamentoServlet">Procedi</a>
			</div>
			<%} %>
		</div>	
	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>