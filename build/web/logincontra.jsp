<%@page import="BEAN.JefeBean"%>
<%!
JefeBean objJefeBean=null;
%>
<%
objJefeBean=(JefeBean)request.getAttribute("DATOS");
%>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

	<div class="container animated fadeInDown" style="max-width: 500px;width: 96%;background-color: white;border-radius: 7px">
		<div class="row titulocontenedor" >
			<center>    <h3> <img style="max-width: 120px;width:60px ;height: 60px"  class="img-responsive" src="<%=request.getContextPath()%>/imagenes/netflix1.jpg" alt=""></h3></center>
			<div class="col-lg-12 text-center" >
				<h3> <%=objJefeBean.getID()%> ingrese clave</h3>
				<hr class="star-primary">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<form name="form" ><br>
					<div class="mens">
						<% if(request.getAttribute("mensaje")!=null){
						String mensaje = (String)request.getAttribute("mensaje");
						%>
						<div class="alert alert-success animated bounceInRight" >
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
							<strong ><%=mensaje%></strong>
						</div> 
						<%  }   %>
					</div>
					<div class="row control-group">
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<input type="hidden"  name="txtseleccion" id="txtseleccion" value="ADMINISTRADOR">
							<input type="hidden"name="txtnombre" value="<%=objJefeBean.getID()%>"
						</div>
					</div>
				</div>
				<div class="row control-group">
					<div class="form-group col-xs-12 floating-label-form-group controls">
						<label>Contraseña</label>
						<input type="password" maxlength="4"class="form-control" name="txtcontra" placeholder="&#128274; Contraseña">
						<p class="help-block text-danger"></p>
					</div>
				</div>
				<div id="success"></div>
				<center>
					<br>
					<div class="row">
						<div class="form-group col-xs-12">
							<input style="padding: 5px" type="button" onclick="enter('<%=request.getContextPath()%>')" value="INGRESAR" class="btn btn-success btn-lg">
						</div>
					</div>
				</center>
			</form>
		</div>
	</div>
</div>
</body>
</html>
