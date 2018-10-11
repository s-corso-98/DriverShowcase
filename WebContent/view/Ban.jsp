<%@ page session = "false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
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
<!-- font-awesome-icons -->
<!-- //font-awesome-icons -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<body>
<%HttpSession Session = request.getSession(true); %>
<!-- banner -->
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Entra in DriverShowCase</h1>
				<div class="w3layouts_main_grid">
					<form action="../ExecBan" method="post" class="w3_form_post">
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Identificativo utente/azienda</label>
								<select id="ListUtenti" name="ListUt">
								</select>
							</span>
						</div>
						<div class="w3_main_grid">
							<div class="w3_main_grid_right">
								<input type="submit" value="Banna">
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
$(document).ready(function(){
	$.get("http://localhost:8080/DriverShowcase/ExecBan",function(data){
		$("#ListUtenti").html(data);
		});	
	});


</script>
</body>
</html>