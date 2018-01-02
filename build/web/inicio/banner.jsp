
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
	<!-- redireccion boostrap en css-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
	<meta name="viewport " content="width-device-width,initial-scale=1">
	<!--redirecciona a la carpeta js-->
	<script  src="js/jquery-3.1.1.min.js" ></script>
	<style>
		@-webkit-keyframes pulse { 
			from { 
				opacity: 0.0; /* Nivel de transparencia inicial */ 
				font-size: 50px; /* Tamaño inicial de la font en la animación */ 
			} 
			to { 
				opacity: 0.8; /* Nivel de Transparencia final */ 
				font-size: 100px; /* Tamaño final de la font en la animación */ 
			} 
		} 
		#animacionpulse { 
			-webkit-animation-name: pulse; /* El nombre del efecto que estamos agregando */ 
			-webkit-animation-duration: 2s; /* Tiempo que durará la animación */ 
			-webkit-animation-iteration-count: infinite; /* Las veces que queremos reproducir la animación */ 
			-webkit-animation-timing-function: ease-in-out; 
			-webkit-animation-direction: alternate; /* Propiedad utilizada para que el texto regrese al tamaño de origen de manera gradual */ 
		} 

		@-webkit-keyframes bounce { 
			from { 
				left: 0px; 
			} 
			to { 
				left: 200px; 
			} 
		} 
		#animacionbounce { 
			-webkit-animation-name: bounce; 
			-webkit-animation-duration: 2s; 
			-webkit-animation-iteration-count: infinite; 
			-webkit-animation-direction: alternate; 
			width: 50%; 
			padding: 0.2em 11em; 
			position: relative; /*La posición relative es necesaria */ 
			background: crimson; 
		} 
		.banner{

			width: 500px;
			height: 280px;
			border: 3px solid #0066cc;
			margin: auto;
			background-size: 100% 100%;
			animation: banner 10s infinite;
			animation-direction: alternate;

		}
		@keyframes banner{


			0%,20%{
				opacity:1;
				background-image:url(imagenes/1.jpg);

			}

			21%,41%{
				opacity:1;
				background-image:url(imagenes/proyecto3.jpg);

			}

			42%,65%{
				opacity:1;
				background-image:url(imagenes/proyecto2.jpg);

			}
			66%,100%{
				opacity:1;
				background-image:url(imagenes/login1.png);

			}
		}


	</style> 
</head>
<body style="background: #666666">
	<br>  <br>  <br> 
	<div class="container" id="animacionpulse" style="font-family: Arial; text-align: center;">BIENVENIDOS  </div> 
	<div id="animacionbounce">  </div> <br>
	<div class="banner">
	</div>
</body>
</html>
