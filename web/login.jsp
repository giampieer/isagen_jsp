<%@page import="BEAN.JefeBean"%>
<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%!
ArrayList<JefeBean> lista=null;
%>
<%
lista=(ArrayList<JefeBean>)request.getAttribute("lista");
%>
<%!
JefeBean objJefeBean=null;
%>
<%
objJefeBean=(JefeBean)request.getAttribute("DATOS");
%>
<!DOCTYPE html>
<html lang="es" > 
<head>
	<meta charset="UTF-8">
	<meta http-equiv=?Content-Language? content=?es?/>
                  <link rel="shortcut icon" href="<%=request.getContextPath()%>/imagenes/link1.ico" type="image/x-icon">
	<meta name="author" content="Giampieer Mariscal">
	<meta name="owner" content="Giampieer Mariscal">
	<meta name="description" content="Login para ingrsear al menu principal del admin ">
	<meta name="keywords" content="ejemplo de software, software libre, login">
	<meta name="robots" content="index,follow">
	<meta name="classification" content="proyecto gestion,isagen,ejemplo,practica gestion">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="theme-color" content="#009688" />

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
	<link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/lado22.css">
	<link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/freelancer.min.css">
	<link rel="Stylesheet" type="text/css"href="<%=request.getContextPath()%>/css/animate.css">
	<link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/alertify.min.css">
	<link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/default.min.css">

	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script  src="<%=request.getContextPath()%>/js/bootstrap.min.js" ></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
	<script src="<%=request.getContextPath()%>/js/alertify.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/push.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/freelancer.min.js"></script>               
	<script>
		function enfocar(){
			document.form.txtnombre.focus();     
		}
	</script>
	<title>Login Admin</title>
</head>
<body class="bd">

	<div class="row titulocontenedor animated fadeInDown" >
	  <div id="barra_material_design" class="load-bar" style="display:none">
              <div class="bar"></div>
              <div class="bar"></div>
              <div class="bar"></div>
             </div>	
            <div class="col-lg-12 text-center" >
			<h3>  ADMINISTRAR PERFILES</h3>
			<hr class="star-primary">
		</div>
	</div>
	<br>
	<div class="container-fluid text-center wow animated fadeInUp" id="carrusel">

		<div class="row">
			<%for(JefeBean obj:lista){%>
			<div class="col-sm-4">
				<input type="image"    style="max-width: 120px;width:120px ;height: 120px"   src=" <%=request.getContextPath()%>/imagenes/netflix1.jpg"    onclick="cargar('<%=request.getContextPath()%>','Jefe',26,'cod='+ <%=obj.getCODJEFE()%>)"  class="enviarfor">
				<h4 style="color: #999999"><%=obj.getID()%></h4>
			</div>
			<%}%>
		</div>
	</div>
	<br>
	<script src="<%=request.getContextPath()%>/js/freelancer.min.js"></script>  

</body>
</html>