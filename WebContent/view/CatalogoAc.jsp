<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Catalogo| Auto</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_navbar.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_catalogo.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body{margin: 0;
            padding:0;
            background-image: url("http://localhost:8080/DriverShowcase/images/SfondoRegister.jpg");
            background-position: center center;
            background-attachment: fixed;
            background-repeat: no-repeat;
        }
        #container{
            width: 100%;
            height: auto;

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
    <div id = "catalogo">
    
        <div id="filter">
            <div class="filter_box" id="MarcaDiv">
                Marca: <select id="Marca" onchange="SelectModello()" selected="0">
                <option disabled selected value> -- select an option -- </option></select>
            </div>
            <div class="filter_box" id="ModelloDiv">
                Modello: <select id="Modello" onchange="SelectKm()" >
                <option disabled selected value> -- select an option -- </option></select>
            </div>
            <div class="filter_box" id="FasciaDiPrezzoDiv">
                Fascia di prezzo: <select id="FasciaDiPrezzo" >
                <option disabled selected value> -- select an option -- </option>
                <option value="5-20">5-20</option>
                <option value="20-50">20-50</option>
                <option value="50-100">50-100</option>
                <option value="100-200">100-200</option>
                <option value="200-500">200-500</option>
                <option value="500+">500+</option>
                </select>
            </div>
            <br>
            <button id="Cerca" onclick="Cerca()">Cerca</button>
        </div>
	<div id="result" ></div>
    </div>
</div>



<script>




var Loggato = "<%=Logged%>"
var Admin ="<%=Admin%>"	
	

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
 
   

$(document).ready(function(){
	$.post("http://localhost:8080/DriverShowcase/CreazioneCatalogo",{tipo:"Accessori"},function(data){
		$("#result").html(data);
	});
	});
	
		function inDettaglio(){ 
		var y = document.getElementById("ok").innerHTML;
		window.location.replace("/Dettaglio.jsp?x="+y);
			}

	
//FUNZIONI FILTRO	
$(document).ready(function(){
	  $.post("http://localhost:8080/DriverShowcase/Filtri",{"Filtro": "1","TipoFilter":"Accessori"},function(data){
		  $("#Marca").html(data);
	  });
	});
function SelectModello(){

	
	var Marca=$( "#Marca option:selected" ).text();
$.post("http://localhost:8080/DriverShowcase/Filtri",{"Filtro": "2","TipoFilter":"Accessori","Marca":  Marca },function(data){
	  $("#Modello").html(data);
	

});
}



function Cerca(){

	
	var Marca=$( "#Marca option:selected" ).text();
	if(Marca!=(" -- select an option -- "))
		{
			var Modello=$( "#Modello option:selected" ).text();
		var Km=$( "#Km option:selected" ).text();
		var Prezzo=$("#FasciaDiPrezzo option:selected").text();
		var Anno=$("#Anno option:selected").text();
    	$.post("http://localhost:8080/DriverShowcase/Filtri",{"Filtro": "3","TipoFilter":"Accessori","Modello":  Modello, "Marca": Marca,"Prezzo": Prezzo},function(data){
  		$("#result").html(data);
  		});
    }
	  else
		{
	    	var Prezzo=$("#FasciaDiPrezzo option:selected").text();
	    	$.post("http://localhost:8080/DriverShowcase/Filtri",{"Filtro":"4","TipoFilter":"Accessori","Prezzo": Prezzo},function(data){
	    	$("#result").html(data);	
	    	});
	    	
	    }
}	
	
</script>
</body>
</html>
