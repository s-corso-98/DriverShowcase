<%@ page session = "false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.unisa.dsc.model.CarrelloDTO,java.util.Base64"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Entra in DriverShowCase!</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_footer.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_how_to_use.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_navbar.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_scl_bar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="http://localhost:8080/DriverShowcase/style/Res_cartview.css">
    <script src="http://localhost:8080/DriverShowcase/script/jquery-3.3.1.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">

      <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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



<body  onresize="resizemenu()">

<%
HttpSession Session = request.getSession(true); 
String Logged=(String)Session.getAttribute("Logged");
boolean Admin=Boolean.parseBoolean(String.valueOf(Session.getAttribute("Admin")));
%>

<div id="container">

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


        	<div id="cart-view">
        	</div>
      	</div>
<script>

$(document).ready(function(){

	$.post("http://localhost:8080/DriverShowcase/ShowAnnunci",{},function(data){
		$("#cart-view").html(data);
		
		
	})
})

 
var Loggato = "<%=Logged%>"
var Admin = "<%=Admin%>"


	$(".toggle-button").click(function(){
		$(".menu-toggle").toggle();	
	});

	function Logout()
	{
	$(document).ready(function(){
	$.post("http://localhost:8080/DriverShowcase/Logout",{},function(data){
		window.location.href = "http://localhost:8080/DriverShowcase/view/Home.jsp";
		});	
	});
	}

	 
	 
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
 
 
    var slides = document.getElementsByClassName("slide");
    var i;
    var currentSlide = 0;
    function f() {
        for (i=1;i<slides.length;i++)
        {
            slides[i].style.opacity = 0;
        }
    }
    function avanti(){
        slides[currentSlide].style.opacity = 0;
        currentSlide++;
        currentSlide = currentSlide % (slides.length);
        slides[currentSlide].style.opacity = 1;
    }
    function indietro() {
        slides[currentSlide].style.opacity = 0;
        currentSlide--;
        if (currentSlide < 0)
            currentSlide = (slides.length)-1;
        currentSlide = currentSlide % (slides.length);
        slides[currentSlide].style.opacity = 1;
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