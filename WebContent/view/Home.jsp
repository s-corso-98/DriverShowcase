<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.unisa.dsc.model.CarrelloDTO"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://localhost:8080/DriverShowcase/script/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>DSC-HomePage</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_footer.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_how_to_use.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_navbar.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/DriverShowcase/style/Res_scl_bar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    
      <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        body{margin: 0;
            padding:0;}
        
         #container{
            width: 100%;
        }
    </style>



</head>
<body onload="f()"  onresize="resizemenu()">


<%
HttpSession Session=request.getSession(true);
String Logged=(String) Session.getAttribute("Logged");
boolean Admin=Boolean.parseBoolean(String.valueOf(Session.getAttribute("Admin")));
CarrelloDTO cart=(CarrelloDTO) Session.getAttribute("ShoppingCart");
%>
<script>
var Loggato = "<%=Logged%>"
var Admin = "<%=Admin%>"
	

	

	
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
	 
	 <% if(cart== null)
		 {
		  cart=new CarrelloDTO(); 
		    Session.setAttribute("ShoppingCart",cart);
		 
		 }
	 
	 %>
	    
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
        <a href="http://localhost:8080/DriverShowcase/view/Home.jsp"><img src="http://localhost:8080/DriverShowcase/images/logo.png"/></a>
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
    <div id = "scl-bar">
        <button id="prec" class="btn-scrll" onclick="indietro()">&#9664</button>
        <div id = "prova1" class="slide"><img src="http://localhost:8080/DriverShowcase/images/scrollbar01.jpg"/></div>
        <div id = "prova2" class="slide"><img src="http://localhost:8080/DriverShowcase/images/scrollbar02.jpg"/></div>
        <div id = "prova3" class="slide"><img src="http://localhost:8080/DriverShowcase/images/scrollbar03.jpg"/></div>
        <div id = "prova4" class="slide"><img src="http://localhost:8080/DriverShowcase/images/scrollbar04.jpg"/></div>
        <button id="succ" class="btn-scrll" onclick="avanti()">&#9658</button>
    </div>
    <div id="how-to-use">
    <div id="first-step" class="effect">
            <h3>1. Scegli la tua auto ideale</h3><br>
            <p>Scegli l'auto che ti piace tra le nostre offerte di auto usate e km0 di qualità</p>
        </div><div id="second-step" class="effect">
            <h3>2. Prenota la tua auto</h3><br>
            <p>Aggiudicati l'auto che hai scelto con un semplice click!</p>
        </div><div id="third-step" class="effect">
            <h3>3. Finalizza il tuo acquisto</h3><br>
            <p>Ricevi l'auto direttamente a casa tua</p>
        </div><div id="fourth-step" class="effect">
            <h3>4. Soddisfatto o rimborsato</h3><br>
            <p>Hai cambiato idea? Nessun problema puoi restituirci l'auto</p>
        </div>
        </div>
    <div id="first-par" class="parallax"></div>
    <div id="second-par" class="parallax"></div>

    <footer>
        <div id="info">
            <p>Project by:Silvio Corso-Matteo Pastore-Angelo Fortunato</p>
        </div>
        <div class="row">
            <div class="sicon">
                <div class="col-lg-1 col-md-1 col-sm-2 col-xs-3 text-center">
                    <div class="icon-circle">
                        <a href="#" class="ifacebook" title="Facebook"><i class="fa fa-facebook"></i></a>
                    </div>
                </div>

                <div class="col-lg-1 col-md-1 col-sm-2 col-xs-3 text-center">
                    <div class="icon-circle">
                        <a href="#" class="itwittter" title="Twitter"><i class="fa fa-twitter"></i></a>
                    </div>
                </div>

                <div class="col-lg-1 col-md-1 col-sm-2 col-xs-3 text-center">
                    <div class="icon-circle">
                        <a href="#" class="igoogle" title="Google+"><i class="fa fa-google-plus"></i></a>
                    </div>
                </div>

                <div class="col-lg-1 col-md-1 col-sm-2 col-xs-3 text-center">
                    <div class="icon-circle">
                        <a href="#" class="iLinkedin" title="Linkedin"><i class="fa fa-linkedin"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    
</div>


<script>

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


</script>

</body>
</html>