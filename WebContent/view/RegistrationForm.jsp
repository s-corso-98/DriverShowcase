<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrati a DriverShowCase!</title>
<!-- Per cellulari -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script> -->
<!-- //for-mobile-apps -->
<!-- //custom-theme -->
<link href="http://localhost:8080/DriverShowcase/style/styleRegister&Login.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="http://localhost:8080/DriverShowcase/script/jquery-3.3.1.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<!-- //font-awesome-icons -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<body>
<%HttpSession Session = request.getSession(true); %>
<!-- banner -->
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Registrati a DriverShowCase</h1>
				<div class="w3layouts_main_grid">
					<form name="myForm" action="http://localhost:8080/DriverShowcase/Registration" method="post" class="w3_form_post" onsubmit="return validateForm()">
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid" style="color: white; font-weight: bold;">
        						Azienda <input type="radio" name="tipologia" value="Azienda" onclick="fill(this.value)"/>
        						Privato <input type="radio" name="tipologia" value="Privato" onclick="fill(this.value)"/>
        					</span>
        				</div>
        				
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<div id="dariempire">
								
								</div>
							</span>
						</div>
								
					<div class="w3_main_grid">
						<div class="w3_main_grid_right">
							<input type="submit" value="Submit">
						</div>
					</div>
				</form>
			</div>
			<div class="w3layouts_copy_right">
				<div class="container">
					<p>© 2018 DriverShowCase. All rights reserved</p>
				</div>
			</div>
		</div>
	</div>
	
<script>
function validateForm()
{	
	var Azione=$("input[name=tipologia]:checked").val();
	
	if(Azione==("Azienda"))
		{
		 var form = document.forms["myForm"];
		    if (!validateNome(form.Nome))
		        return false;
			if(!validateEmail(form.Email))
		        return false;
			if (!validatePassword(form.Password))
		        return false;
			if (!validatePIVA(form.PIVA))
		        return false;
			if (!validateRecapito(form.Recapito))
		        return false;
			if (!validateProvincia(form.Provincia))
		        return false;
			if (!validateCitta(form.Citta))
		        return false;
			if (!validateVia(form.Via))
		        return false;

		}
	else
	{
		var form = document.forms["myForm"];
	    if (!validateNome(form.Nome))
	        return false;
		if(!validateEmail(form.Email))
	        return false;
		if (!validatePassword(form.Password))
	        return false;
		if (!validateCognome(form.Cognome))
	        return false;
		if (!validateRecapito(form.Recapito))
	        return false;
		if (!validateProvincia(form.Provincia))
	        return false;
		if (!validateCitta(form.Citta))
	        return false;
		if (!validateVia(form.Via))
	        return false;
		if (!validateCodiceFiscale(form.CodiceFiscale))
	        return false;
		
	}
}
function validateNome(Nome){
	var Regexp = /^[a-zA-Z0-9 ]+$/;
	if(Nome.value.match(Regexp))
		return true;
	else{
		alert('Il campo Nome deve contenere solo lettere,numeri e spazi!');
		Nome.focus();
		return false;
	}
}
function validateEmail(Email){
	var Regexp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/;
	if(Email.value.match(Regexp))
		return true;
	else{
		alert('Il campo Email deve contenere solo lettere, trattini e spazi!');
		Email.focus();
		return false;
	}
}
function validatePassword(Password){
	var Regexp =  /^[a-zA-Z0-9]+$/;
	if(Password.value.match(Regexp))
		return true;
	else{
		alert('Il campo Password deve contenere solo lettere e numeri!');
		Password.focus();
		return false;
	}
}
function validatePIVA(PIVA){
	var Regexp = /^[0-9]+$/;
	if(PIVA.value.match(Regexp))
		return true;
	else{
		alert('Il campo Partita Iva deve contenere solo numeri!');
		PIVA.focus();
		return false;
	}
}
function validateRecapito(Recapito){
	var Regexp = /^[0-9]+$/;
	if(Recapito.value.match(Regexp))
		return true;
	else{
		alert('Il campo Recapito deve contenere solo Numeri!');
		Recapito.focus();
		return false;
	}
}
function validateProvincia(Provincia){
	var Regexp = /^[A-Za-z]+$/;
	if(Provincia.value.match(Regexp))
		return true;
	else{
		alert('Il campo Provincia deve contenere solo lettere!');
		Provincia.focus();
		return false;
	}
}
function validateCitta(Citta){
	var Regexp = /^[A-Za-z ]+$/;
	if(Citta.value.match(Regexp))
		return true;
	else{
		alert('Il campo Città deve contenere solo Lettere!');
		Citta.focus();
		return false;
	}
}
function validateVia(Via){
	var Regexp = /^[A-Za-z]+[ ]{1}[0-9]+$/;
	if(Via.value.match(Regexp))
		return true;
	else{
		alert('Il campo Via deve contenere solo il nome della via e numero civico!');
		Via.focus();
		return false;
	}
}
function validateCognome(Cognome){
	var Regexp = /^[a-zA-Z]+$/;
	if(Cognome.value.match(Regexp))
		return true;
	else{
		alert('Il campo Cognome deve contenere solo lettere!');
		Cognome.focus();
		return false;
	}
}
function validateCodiceFiscale(CodiceFiscale){
	var Regexp =/^[A-Z]{6}\d{2}[A-Z]\d{2}[A-Z]\d{3}[A-Z]$/i;
	if(CodiceFiscale.value.match(Regexp))
		return true;
	else{
		alert("Il campo CodiceFiscale deve contenere tre caratteri alfabetici per il cognome, tre caratteri alfabetici per il nome,due caratteri numerici per l'anno di nascita,un carattere alfabetico per il mese di nascita,due caratteri numerici per il giorno di nascita ed il sesso,quattro caratteri, di cui uno alfabetico e tre numerici per il comune italiano o per lo Stato estero di nascita,il sedicesimo carattere, alfabetico, ha funzione di controllo!");
		CodiceFiscale.focus();
		return false;
	}
}

function fill(action)
{
	$(document).ready(function(){
		$.get("http://localhost:8080/DriverShowcase/Registration?azione="+action,function(data,status)
			{
			$("#dariempire").html(data);
			});
		});

}
</script>
</body>
</html>