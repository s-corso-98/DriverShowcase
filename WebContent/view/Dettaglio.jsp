<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.unisa.dsc.model.AccessoriDTO,java.util.Base64,it.unisa.dsc.model.MotoDTO,it.unisa.dsc.model.AutoDTO" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://localhost:8080/DriverShowcase/script/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Auto</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_detail.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_navbar.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body{
            margin: 0;
            padding: 0;
            border: 0;
             background-image: url("http://localhost:8080/DriverShowcase/images/SfondoRegister.jpg");
            background-position: center center;
            background-attachment: fixed;
            background-repeat: no-repeat;
        }
        #container{
            margin: 0;
        }
    </style>
  </head>
  <body onresize="resizemenu()">
 
  
  <%
	HttpSession Session=request.getSession(true);
	String Logged=(String) Session.getAttribute("Logged");
	boolean Admin=Boolean.parseBoolean(String.valueOf(Session.getAttribute("Admin")));

%>
  
  <div id = "container">
  
<div class="nav_bar"><a href="#" onclick="showmenu()">&#9776;</a></div>
    <nav>
    	<div id="menu">
        <ul>
            <li><a href="http://localhost:8080/DriverShowcase/view/CatalogoA.jsp" onclick="closemenu();">Auto</a></li>
            <li><a href="http://localhost:8080/DriverShowcase/view/CatalogoM.jsp" onclick="closemenu();">Moto</a></li>
            <li><a href="http://localhost:8080/DriverShowcase/view/CatalogoAc.jsp" onclick="closemenu();">Accessori</a></li>
            <li><a href="http://localhost:8080/DriverShowcase/view/ViewCarrello.jsp" onclick="closemenu()"> Carrello </a></li>
        </ul>
        </div>	
        <a href="Home.jsp"><img src="http://localhost:8080/DriverShowcase/images/logo.png"/></a>
       	<a href="http://localhost:8080/DriverShowcase/view/LoginForm.jsp" ><button id="btnlg"><span class="fa">&#xf2be</span> Login</button></a>
                  <div id="action-user">
                <button class="toggle-button"><%String namejsp=(String) Session.getAttribute("name");
                String surnamejsp=(String) Session.getAttribute("surname");
                if(surnamejsp!=null)
                out.append(namejsp+" "+surnamejsp);  
                else
                out.append(namejsp); %>&nbsp&nbsp<span class="caret"></span></button>
                <ul id="Funzioni" class="menu-toggle" style="display: none">
                    <li><a href="http://localhost:8080/DriverShowcase/view/Inserimento.jsp">Inserisci Annuncio</a></li>
                    <li><a href="http://localhost:8080/DriverShowcase/view/AnnunciUtente.jsp">Controlla i tuoi annunci</a></li>
                    <li><a href="#" onclick="Logout()">Disconnetti</a></li>
                </ul>
        </div>
    </nav>


      <% if(request.getParameter("tipo").equals("Accessori")) { %>
      <div id="detail">
      <form action="../Carrello?tipo=Accessori" method="post">
     	 <div id="detail-foto">
        	<img id="0" name="Img" src="<% out.println(request.getParameter("Img"));%>">
     	 </div>
     	 <div id="detail-general-info">
     	 	
        	<p id="1" >Marca: <% out.println(request.getParameter("Marca"));%></p>
        	<p id="2" >Modello:<% out.println(request.getParameter("Modello")); %></p>
       	 	<p id="3">Prezzo:<% out.println(request.getParameter("Prezzo")); %></p>
       	 	<input type="hidden" name="Cf" value='<%=request.getParameter("Cf")%>'>
			<input type="hidden" name="Iv" value='<%=request.getParameter("Iv")%>'>
			<input type="hidden" name="Id" value='<%=request.getParameter("Id")%>'>
       	 	<input type="hidden" name="Marca" value='<%=request.getParameter("Marca") %>'>
       	 	<input type="hidden" name="Modello" value='<%=request.getParameter("Modello") %>'>
       	 	<input type="hidden" name="Prezzo" value='<%=request.getParameter("Prezzo")%>'>
       	 	<input type="hidden" name="Desc" value='<%=request.getParameter("Desc") %>'>
       	 	<input type="hidden" name="Img" value='<%=request.getParameter("Img")%>'>
      	</div>
      	<div id="detail-description">
        	<h4>Descrizione:</h4>
        	<p id="5"><% out.println(request.getParameter("Desc")); %> </p>
        	<input id = "button" type="submit" value="Aggiungi al carrello">
      </div>
      </form>
    </div>
    <% } %>

    
    <% if(request.getParameter("tipo").equals("Auto")) { %>
    <div id="detail">
    <form action="../Carrello?tipo=Auto" method="post">
     	 <div id="detail-foto">
        <img id="0" src="<% out.println(request.getParameter("Img"));%>">
      </div><div id="detail-general-info">
        <p id="1">Marca: <% out.println(request.getParameter("Marca"));%></p>
        <p id="2">Modello:<% out.println(request.getParameter("Modello")); %></p>
        <p id="3">Kilometri:<% out.println(request.getParameter("Km")); %></p>
        <p id="4">Anno immatricolazione:<% out.println(request.getParameter("Anno")); %></p>
        <p id="6">Prezzo : <% out.println(request.getParameter("Prezzo")); %>
        <input type="hidden" name="Cf" value='<%=request.getParameter("Cf")%>'>
		<input type="hidden" name="Iv" value='<%=request.getParameter("Iv")%>'>
		<input type="hidden" name="Id" value='<%=request.getParameter("Id")%>'>
		<input type="hidden" name="Km" value='<%=request.getParameter("Km") %>'>
		<input type="hidden" name="Anno" value='<%=request.getParameter("Anno") %>'>
       	<input type="hidden" name="Marca" value='<%=request.getParameter("Marca") %>'>
       	<input type="hidden" name="Modello" value='<%=request.getParameter("Modello") %>'>
       	<input type="hidden" name="Prezzo" value='<%=request.getParameter("Prezzo")%>'>
       	<input type="hidden" name="Desc" value='<%=request.getParameter("Desc") %>'>
       	<input type="hidden" name="Img" value='<%=request.getParameter("Img")%>'>
      </div><div id="detail-description">
        <h4>Descrizione:</h4>
        <p id="5"><% out.println(request.getParameter("Desc")); %> </p>
        <input id = "button" type="submit" value="Aggiungi al carrello">
      </div>
      </form>
      
    </div>
 <% } %>
 
 	<% if(request.getParameter("tipo").equals("Moto")) { %>
    <div id="detail">
    <form action="../Carrello?tipo=Moto" method="post">
     	 <div id="detail-foto">
         <img id="0" src="<% out.println(request.getParameter("Img"));%>">
      </div><div id="detail-general-info">
        <p id="1">Marca: <% out.println(request.getParameter("Marca"));%></p>
        <p id="2">Modello:<% out.println(request.getParameter("Modello")); %></p>
        <p id="3">Kilometri:<% out.println(request.getParameter("Km")); %></p>
        <p id="4">Anno immatricolazione:<% out.println(request.getParameter("Anno")); %></p>
        <p id="6">Prezzo : <% out.println(request.getParameter("Prezzo")); %>
        <input type="hidden" name="Cf" value='<%=request.getParameter("Cf")%>'>
		<input type="hidden" name="Iv" value='<%=request.getParameter("Iv")%>'>
		<input type="hidden" name="Id" value='<%=request.getParameter("Id")%>'>
		<input type="hidden" name="Km" value='<%=request.getParameter("Km") %>'>
		<input type="hidden" name="Anno" value='<%=request.getParameter("Anno") %>'>
       	<input type="hidden" name="Marca" value='<%=request.getParameter("Marca") %>'>
       	<input type="hidden" name="Modello" value='<%=request.getParameter("Modello") %>'>
       	<input type="hidden" name="Prezzo" value='<%=request.getParameter("Prezzo")%>'>
       	<input type="hidden" name="Desc" value='<%=request.getParameter("Desc") %>'>
       	<input type="hidden" name="Img" value='<%=request.getParameter("Img")%>'>
      </div><div id="detail-description">
        <h4>Descrizione:</h4>
        <p id="5"><% out.println(request.getParameter("Desc")); %> </p>
         <input id = "button" type="submit" value="Aggiungi al carrello">
      </div>
      </form>
      
    </div>
 <% } %>
 
   
  </div>
  
  <script>
  
var Loggato = "<%=Logged%>"
var Admin = "<%=Admin%>"	

  	$(".toggle-button").click(function(){
			$(".menu-toggle").toggle();	
		});


		
	  $(document).ready(function(){

	 	if(Loggato=="null")
	 		{
	 		$("#action-user").hide();
	 		    $("#btnlg").show();
	 		 
	 		
	 		}
	 	else{
	 		
	 		$("#action-user").show();
	 	   $("#btnlg").hide();
	 		
	 	}
	 	
		 if(Loggato != "null" && Admin !="false")
		    {
		    $("#Funzioni").append("<li><a href=\"http://localhost:8080/DriverShowcase/view/Ban.jsp\" >Banna Utente</a></li>");
		    }
	 });


	 function Logout()
	 {
	 $(document).ready(function(){
	 $.post("http://localhost:8080/DriverShowcase/Logout",{},function(data){
	 	window.location.href = "http://localhost:8080/DriverShowcase/view/Home.jsp";
	 	});	
	 });
	 }
  
  
  
    function showmenu() {
        if( document.getElementById("menu").style.display == "block")
            document.getElementById("menu").style.display = "none"
        else
            document.getElementById("menu").style.display = "block"
    }
    function resizemenu() {
        var x = window.innerWidth
        if (x >= 1300)
            document.getElementById("menu").style.display = "block"
        else
            document.getElementById("menu").style.display = "none"
    }
    function closemenu() {
        var x = window.innerWidth
        if (x <= 1300)
            document.getElementById("menu").style.display = "none"
    }
    
    
    
    
</script>
  
  </body>
</html>