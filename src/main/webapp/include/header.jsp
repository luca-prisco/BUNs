<%@ page import="model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it-IT" xml:lang="it-IT">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/header.css" type="text/css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@800&display=swap"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
  <div class="header"> 
    <nav>
    	<div class="logo"> 
    		<a href="HomeServlet"><img src="img/logo/logo.svg"></a>
   		</div>
      <div style="display:flex; justify-content: flex-end;">
	      <div class="menu">
	        <div class="dropdown" data-dropdown>
	          <button class="dropbtn" data-dropdown-button>Panini</button>
	          <div class="dropdown-content">
	            <div class="drop-items">
	              <img src="img/navbar/steak.png" alt="Carne">
	              <a href="StartServlet?action=Carne" class="link">Carne</a>
	            </div>
	            <div class="drop-items">
	              <img src="img/navbar/pollo.png" alt="Pollo">
	              <a href="StartServlet?action=Pollo" class="link">Pollo</a>
	            </div>
	          </div>
	        </div>
	        <div class="dropdown" data-dropdown>
	          <button class="dropbtn" data-dropdown-button>Patate</button>
	          <div class="dropdown-content">
	            <div class="drop-items">
	              <img src="img/navbar/fries.png" alt="Fries">
	              <a href="StartServlet?action=Classiche" class="link">Classiche</a>
	            </div>
	            <div class="drop-items">
	              <img src="img/navbar/dippers.svg" alt="Dippers">
	              <a href="StartServlet?action=Dippers" class="link">Dippers</a>
	            </div>
	            <div class="drop-items">
	              <img src="img/navbar/american.png" alt="american">
	              <a href="StartServlet?action=Dolci" class="link">Americane dolci</a>
	            </div>
	          </div>
	        </div>
	        <div class="dropdown" data-dropdown>
	          <button class="dropbtn" data-dropdown-button>Bevande</button>
	          <div class="dropdown-content">
	            <div class="drop-items">
	              <img src="img/navbar/wine.png" alt="Alcoliche">
	              <a href="StartServlet?action=Alcolica" class="link">Alcoliche</a>
	            </div>
	            <div class="drop-items">
	              <img src="img/navbar/drink.png" alt="Analcoliche">
	              <a href="StartServlet?action=Analcolica" class="link">Analcoliche</a>
	            </div>
	            <div class="drop-items">
	              <img src="img/navbar/energy.png" alt="Energy">
	              <a href="StartServlet?action=Energy" class="link">Energy drink</a>
	            </div>
	          </div>
	        </div> 
	        <div class="dropdown" data-dropdown>
	          <button class="dropbtn" data-dropdown-button>Contatti</button>
	          <div class="dropdown-content">
	            <a href="" class="link">Chi siamo</a>
	            <a href="" class="link">Email</a>
	          </div>
	        </div> 
	        <% if(session.getAttribute("Utente")==null)
		    {%>
	        <div class="auth">
	          <a href="StartServlet?action=login" class="auth-link"><img src="img/icon/user.svg " style="padding-right: 10px;" alt="Non disponibile">Accedi</a>
	          <a href="Registrazione" class="auth-link">Registrati</a>
	        </div>
	       	<%}
	        else
	        {%>
	        <%Utente u = (Utente) session.getAttribute("Utente");%>
	        <div class="dropdown" data-dropdown>
	          <button class="dropbtn" data-dropdown-button><%=u.getNome() %><img src="img/icon/user.svg" style="padding-left: 10px;" alt="Non disponibile"></button>
	          <div class="dropdown-content">
	            <div class="drop-items">
	              <a href="" class="link"><%=u.getNome()%> <%=u.getCognome() %></a>
	            </div>
	            <div class="linea">
	            	<span></span><span></span><span></span>
	            </div>
	            <div class="drop-items">
	              <img src="img/navbar/account.png" alt="Non disponibile">
	              <a href="" class="link">I miei dati</a>
	            </div>
	            <div class="drop-items">
	              <img src="img/navbar/ordine.png" alt="Non disponibile">
	              <a href="" class="link">I miei ordini</a>
	            </div>
	            <div class="drop-items">
	              <img src="img/navbar/logout.png" alt="Non disponibile">
	              <a href="Login?action=logout" class="link">Logout</a>
	            </div>
	          </div>
	        </div>
	        <%}%>
			</div>
			<div style="display:flex; flex-direction: row;">
				<div class="navbar__icons">
					<img src="img/icon/search.svg" alt="cart" style="padding-left: 50px;"> 
					<a href="Carrello"><img src="img/icon/cart.svg" alt="cart" style="padding-left: 30px;"></a>
				</div>
				<div class="hamburger">
					<span class="bar"></span> 
					<span class="bar"></span> 
					<span class="bar"></span> 
				</div>
			</div> 
		</div>
    </nav>
  </div> 
	<script src="scripts/dropdown.js"></script>
	<script src="scripts/navbar.js"></script>
</body>
</html>