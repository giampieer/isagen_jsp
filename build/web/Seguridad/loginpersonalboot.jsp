
<link rel="Stylesheet" type="text/css"href="<%=request.getContextPath()%>/css/login.css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="Stylesheet" type="text/css"href="<%=request.getContextPath()%>/css/animate.css">
<!doctype html>
<html lang="en-US">
<head>
 <script>
  function enfocar(){
    document.form.txtnombre.focus();
  }
  function enter(){
    var usuario,clave;
    usuario=document.form.txtnombre.value;
    clave=document.form.txtcontra.value;
    if(usuario==''){
      alert("Ingrese el usuario por favor!!");
      document.form.txtnombre.focus();
      return;
    }else if(clave==''){
      alert("Ingrese la clave por favor!!");
      document.form.txtcontra.focus();
      return;
    }else{
      document.form.action="<%=request.getContextPath()%>/PersonalServlet?op=9";
      document.form.method="POST";
      
      document.form.submit();
    }
  }
  function SALIR(){
    
    document.form.action="<%=request.getContextPath()%>/PersonalServlet?op=15";
    document.form.method="POST";
    
    document.form.submit();
  }
  
  
</script>

<style>
  .barrah1{
    background-color: #009688;
    padding: 15px;
  }
  
  
  
</style>


</head>

<body  style="background-color: #333333" onload="enfocar()">

 <h2 class="barrah1 animated bounceInRight"><center>LOGIN PERSONAL</center></h2>
 <div id="franja_superior"></div>
 <center>
  
  <div class="mensaje   animated bounceInRight ">
    <% if(request.getAttribute("mensaje")!=null){
    String mensaje = (String)request.getAttribute("mensaje");
    %>
    <div class="alert alert-success">
      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
      <strong><%=mensaje%></strong>

    </div> 
    <%  }   %>
  </div>
  
  
  
  <div id="login-form"  class="animated zoomIn" >
    <h1>SISTEMA DE GESTION DE PROYECTOS</h1>

    <fieldset>

      <form    name="form">
        <img  class="animated infinite pulse" width="150px"src="<%=request.getContextPath()%>/imagenes/Usuario.png"><br><br>
        <input class="tex " maxlength="20" type="text" name="txtnombre" placeholder="&#128273; Usuario"><br><br>
        <input class="tex" maxlength="4"type="password" name="txtcontra" placeholder="&#128274; Contraseña"><br><br>
        <input type="submit" value="INGRESAR" class="btn " onclick="enter()">
        <input type="submit" value="SALIR" class="btn " onclick="SALIR()">
        <br><br>
        
      </form>

    </fieldset>

  </div> <!-- end login-form -->

</body>
</html>