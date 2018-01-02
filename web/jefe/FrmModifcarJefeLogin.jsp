<%@page import="BEAN.JefeBean"%>
<%!
JefeBean objJefeBean=null;
%>
<%
objJefeBean=(JefeBean)request.getAttribute("DATOS");
%>
<html>
<head>
</head>
<body>
 <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
  <div class="row titulocontenedor" >
    <div class="col-lg-12 text-center" >
      <h3>MODIFICAR  USUARIO</h3>
      <hr class="star-primary">
    </div>
  </div>
  <div class="row">
    <div class="col-lg-8 col-lg-offset-2">
      <form name="form" >
        <input type="hidden" class="form-control" placeholder="Codigo" name="txtcod" value="<%=objJefeBean.getCODJEFE()%>" readonly="readonly" >
        <div class="mens">
         <% if(request.getAttribute("mensaje")!=null){
         String mensaje = (String)request.getAttribute("mensaje");
         %>
         <div class="alert alert-success animated bounceInRight">
          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
          <strong><%=mensaje%></strong>
        </div> 
        <%  }   %>
      </div>
      <div class="row control-group">
        
        <div class="form-group col-xs-12 floating-label-form-group controls">
          <label>Nombre</label>
          <input type="text" class="form-control" name="txtnom" placeholder="Nombre" value="<%=objJefeBean.getNOMBJEFE()%>">
          <p class="help-block text-danger"></p>
        </div>
      </div>
      
      <div class="row control-group">
        <div class="form-group col-xs-12 floating-label-form-group controls">
          <label>Email</label>
          <input type="email" class="form-control" name="txtema" placeholder="Ejemplo@gmail.com" value="<%=objJefeBean.getEMAJEFE()%>" required>
          <p class="help-block text-danger"></p>
        </div>
      </div>
      <div class="row control-group">
        <div class="form-group col-xs-12 floating-label-form-group controls">
          <label>Telefono</label>
          <input type="number" class="form-control" name="txttel" value="<%=objJefeBean.getTELFJEFE()%>" placeholder="Telefono">
          <p class="help-block text-danger"></p>
        </div>
      </div>
      <br>
      <div class="row control-group">
        <div class="form-group col-xs-12 floating-label-form-group controls">
          <select  name="txtare" id="txtare" class="form-control">
            <% if(objJefeBean.getAREAJEFE().equalsIgnoreCase("DIRECCION")){ %>
            <option value="Direccion" selected>DIRECCION</option>
            <option value="Administracion">ADMINISTRACION</option>
            <option value="Finanzas">FINANZAS</option>
            <option value="Informatica">INFORMATICA</option>
            <%}else{
            if(objJefeBean.getAREAJEFE().equalsIgnoreCase("ADMINISTRACION")){%> 
            <option value="Direccion">DIRECCION</option>
            <option value="Administracion" selected>ADMINISTRACION</option>
            <option value="Finanzas">FINANZAS</option>
            <option value="Informatica">INFORMATICA</option>
            <%}else{
            if(objJefeBean.getAREAJEFE().equalsIgnoreCase("FINANZAS")){%> 
            <option value="Direccion">DIRECCION</option>
            <option value="Administracion">ADMINISTRACION</option>
            <option value="Finanzas" selected>FINANZAS</option>
            <option value="Informatica">INFORMATICA</option>
            <%}else{
            if(objJefeBean.getAREAJEFE().equalsIgnoreCase("INFORMATICA")){%> 
            <option value="Direccion">DIRECCION</option>
            <option value="Administracion">ADMINISTRACION</option>
            <option value="Finanzas">FINANZAS</option>
            <option value="Informatica" selected>INFORMATICA</option>
            
            <%}}}}%>
          </select>          
        </div>
      </div>
      <input type="hidden" class="form-control" name="txtid" placeholder="ID" value="<%=objJefeBean.getID()%>" >
      <input type="hidden"  class="form-control " name="txtpass" placeholder="Contraseña" value="<%=objJefeBean.getPASS()%>">
      <div id="success"></div>
      <center>
        <div class="row">
          <div class="form-group col-xs-12">
            <input type="button" onclick="modificarLoginJefe('<%=request.getContextPath()%>')" value="modificar" class="btn btn-success btn-lg">
          </div>
        </div>
        <div class="row">
          <div class="form-group col-xs-12">
            <input type="button"  onclick="salir('<%=request.getContextPath()%>','Jefe',12)" value="salir" class="btn btn-success btn-lg">
          </div>
        </div> 
      </center>
    </form>
  </div>
</div>
</div>
</body>
</html>


