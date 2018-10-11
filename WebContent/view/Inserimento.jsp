<%@ page session = "false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entra in DriverShowCase!</title>
<!-- Per cellulari -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script> -->
<!-- //for-mobile-apps -->
<!-- //custom-theme -->
<link href="http://localhost:8080/DriverShowcase/style/styleRegister&Login.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<body>
<!-- banner -->
<%HttpSession Session = request.getSession(true); %>
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Entra in DriverShowCase</h1>
				<div class="w3layouts_main_grid">
					<form action="http://localhost:8080/DriverShowcase/InserimentoServlet" method="post" class="w3_form_post" onsubmit="return validateForm()" enctype="multipart/form-data">
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid" style="color: white; font-weight: bold;">
        						Auto <input type="radio" id="tip" name="tipologia" value="Auto" onclick="fill(this.value)"/>
        						Moto <input type="radio" id="tip" name="tipologia" value="Moto" onclick="fill(this.value)"/>
        						Accessori <input type="radio" id="tip" name="tipologia" value="Accessori" onclick="fill(this.value)"/>
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
	
<script src="http://localhost:8080/DriverShowcase/script/jquery-3.3.1.min.js"></script>
<script>

var loadFile = function(event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
  };

function validateForm()
{	
	var Azione=$("input[name=tipologia]:checked").val();
	
	if(Azione==("Auto")||Azione==("Moto"))
		{
		 var form = document.forms["myForm"];
		    if (!validateMarca(form.Marca))
		        return false;
			if(!validateModello(form.Modello))
		        return false;
			if (!validatePrezzo(form.Prezzo))
		        return false;
			if (!validateKilometri(form.Kilometri))
		        return false;
			if (!validateAnno(form.Anno))
		        return false;

		}
	else
	{
		 var form = document.forms["myForm"];
		    if (!validateMarca(form.Marca))
		        return false;
			if(!validateModello(form.Modello))
		        return false;
			if (!validatePrezzo(form.Prezzo))
		        return false;
	}
	}
function validateMarca(Marca){
	var Regexp = /^[a-zA-Z ]+$/;
	if(Marca.value.match(Regexp))
		return true;
	else{
		alert('Il campo Marca deve contenere solo lettere e spazi!');
		Marca.focus();
		return false;
	}
}
function validateModello(Modello){
	var Regexp = /^[a-zA-Z0-9\- ]+$/;
	if(Modello.value.match(Regexp))
		return true;
	else{
		alert('Il campo Modello deve contenere solo lettere, trattini e spazi!');
		Modello.focus();
		return false;
	}
}
function validatePrezzo(Prezzo){
	var Regexp = /^([0-9]+[.])?[0-9]+$/;
	if(Prezzo.value.match(Regexp))
		return true;
	else{
		alert('Il campo Prezzo deve contenere solo Numeri,se sono decimali inserire il .!');
		Prezzo.focus();
		return false;
	}
}
function validateKilometri(Kilometri){
	var Regexp = /^([0-9]+$/;
	if(Kilometri.value.match(Regexp))
		return true;
	else{
		alert('Il campo Kilometri deve contenere solo Numeri!');
		Kilometri.focus();
		return false;
	}
}
function validateAnno(Anno){
	var Regexp = /^[0-9]+$/;
	if(Anno.value.match(Regexp))
		return true;
	else{
		alert('Il campo Anno deve contenere solo Numeri!');
		Anno.focus();
		return false;
	}
}



function fill(action)
{
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function ()
	{
	if(xhttp.status==200 && xhttp.readyState==4)
		{
		 document.getElementById("dariempire").innerHTML=xhttp.responseText;
		}
	}
xhttp.open("GET","http://localhost:8080/DriverShowcase/InserimentoServlet?azione="+action,true);
xhttp.setRequestHeader("connection","close");
xhttp.send();
}


</script>
</body>
</html>