<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html lang="it-IT" xml:lang="it-IT">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/catalogo.css" type="text/css">
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Alata&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Jost:wght@800&display=swap" rel="stylesheet">
	<%
		String categoria =  request.getParameter("action");
		Collection<?> prodotti = (Collection<?>) request.getAttribute(categoria);
	%>

<title>BUNs - <%=categoria %></title>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<div class="prodotto__container">
	<%					
		Iterator<?> it = prodotti.iterator();
		while(it.hasNext()) {
			Prodotto prodotto = (Prodotto) it.next();
			String pathImg = "img/prodotti/" + prodotto.getIdProdotto() + ".png";
			String nomeProdotto = prodotto.getNome();
	%>
		<div class="prodotto__card">
			<img src="<%=pathImg %>" alt="LOGO">
			<h2><%=prodotto.getNome() %></h2>
			<p><%=prodotto.getDescrizione() %></p>
			<a class="ordernow" href="SceltaProdotto?search=<%=nomeProdotto%>">ORDER NOW</a>
		</div>
		<%} %>
	</div>

	<%@ include file="/include/footer.jsp"%>
</body>
</html>