<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/index.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Alata&display=swap" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@800&display=swap"
	rel="stylesheet">
<title>BUNs - Enjoy your meal!</title>
<%
	Prodotto primoPiano = (Prodotto) request.getAttribute("primoPiano");
	Collection<?> bestPanini = (Collection<?>) request.getAttribute("bestPanini");
	Collection<?> bestBevande = (Collection<?>) request.getAttribute("bestBevande");
	if (bestPanini == null || bestBevande == null) {
		response.sendRedirect(response.encodeURL("./HomeServlet"));
		return;
	}
%>
</head>
<body>
	<div class="all">
		<%@ include file="/include/header.jsp"%>
		<div class="content">
			<%String primoPianoImg = "img/prodotti/" + primoPiano.getIdProdotto() + ".png"; %>
			<div class="homepage__content">
				<div class="prod__description">
					<h1><%=primoPiano.getNome()%><img src="img/icon/star.png"></h1>
					<p><%=primoPiano.getDettagli()%></p>
					<div class="prod__buttons">
						<button class="ordernow">
							<a href="#">ORDER NOW</a>
						</button>
						<button class="scopridipiu">
							<a href="Product">SCOPRI DI PIU'</a>
						</button>
					</div>
				</div>
				<div class="prod__home">
					<img src="<%=primoPianoImg%>" alt="LOGO">
				</div>
			</div>
		</div>
		<h1 id="intestazione">Best panini</h1>
		<div class="bestseller">
			<%
				int i = 0;					
				Iterator<?> it = bestPanini.iterator();
				while(i<3) {
					Prodotto prodotto = (Prodotto) it.next();
					String paninoImg = "img/prodotti/" + prodotto.getIdProdotto() + ".png";
			%>
			<div class="bestseller__container">
				<div class="bestseller__card">
					<img src="<%=paninoImg%>" alt="LOGO">
					<h2><%=prodotto.getNome()%></h2>
					<p><%=prodotto.getDescrizione()%></p>
					<button class="ordernow">
						<a href="#">ORDER NOW</a>
					</button>
				</div>
			</div>
			<%i++; } %>
		</div>
		<h1 id="intestazione">Best bevande</h1>
		<div class="bestseller">
			<%
				int j = 0;					
				Iterator<?> it2 = bestBevande.iterator();
				while(j<3) {
					Prodotto prodotto = (Prodotto) it2.next();
					String bevandaImg = "img/prodotti/" + prodotto.getIdProdotto() + ".png";
			%>
			<div class="bestseller__container">
				<div class="bestseller__card">
					<img src="<%=bevandaImg %>" alt="LOGO">
					<h2><%=prodotto.getNome() %></h2>
					<p><%=prodotto.getDescrizione() %></p>
					<button class="ordernow">
						<a href="#">ORDER NOW</a>
					</button>
				</div>
			</div>
			<%j++; } %>
		</div>
		<%@ include file="/include/footer.jsp"%>
	</div>
</body>
</html>