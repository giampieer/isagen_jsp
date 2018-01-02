  <!DOCTYPE html>
  <html lang="es" > 
  <head>
    <meta charset="UTF-8">
    <meta http-equiv=?Content-Language? content=?es?/>
          <link rel="shortcut icon" href="<%=request.getContextPath()%>/imagenes/link1.ico" type="image/x-icon">
    <meta name="author" content="Giampieer Mariscal">
    <meta name="owner" content="Giampieer Mariscal">
    <meta name="description" content="Login para ingresar al menu principal del admin ,Login para ingrsear al menu principal del personal">
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
    <title>Login Admin-Personal</title>
  </head>
  <body onload="enfocar(),bloqueo()" style="  padding-top: 70px;"class="bd" >
    <div class="container animated zoomIn" style="max-width: 500px;width: 96%;background-color: white;border-radius: 7px">
      <div class="row titulocontenedor" >
        <div class="col-lg-12 text-center" >
          <h3> LOGIN</h3>
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
                <select   name="txtseleccion" id="txtseleccion"  class="form-control" >
                  <option value="0">------------SELECCIONAR-----------</option>
                  <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                  <option value="PERSONAL">PERSONAL</option></select>
                </select>
              </div>
            </div>
            
            <div class="row control-group">
              <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Usuario</label>
                <input maxlength="20" type="text" class="form-control"name="txtnombre" placeholder="&#128273; Usuario">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <br>
            
            <div class="row control-group">
              <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Contraseña</label>
                <input type="password" maxlength="4"class="form-control" name="txtcontra" placeholder="&#128274; Contraseña" onkeypress="validar(event,'<%=request.getContextPath()%>')">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div id="success"></div>
            <center>
              <br>
              <div class="row">
                <div class="form-group col-xs-12">
                  <input style="padding: 5px" type="button" onclick="enter('<%=request.getContextPath()%>')" value="INGRESAR" class="btn btn-success btn-lg">
                  <input style="padding: 5px"type="button" onclick="netflix('<%=request.getContextPath()%>')" value=" PERFILES" class="btn btn-success btn-lg">
                </div>
                
              </div>
            </center>

          </form>
          <a class="navbar-brand" href="./Relacion/Extras.jsp"  ><img  src="<%=request.getContextPath()%>/imagenes/androidqr.png"  style="height: 25px ; width: 25px ;position: initial"> </a>
        </div>
      </div>
    </div>
  </body>
  </html>