<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.RiesgosBean"%>
<%!
RiesgosBean objCubBean=null;
%>
<%
objCubBean=(RiesgosBean)request.getAttribute("DATOS");
%>

<%!
ArrayList<ProyectoBean>lista=null;

%>
<%
lista=(ArrayList<ProyectoBean>)request.getAttribute("lista1");
%>
<html>
<head>
</head>
<body onload="enfocar()">
 <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
  <div class="row titulocontenedor" >
    <div class="col-lg-12 text-center" >
      <h3>MODIFICAR  RIESGOS</h3>
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
    <input type ="hidden" name="txtnum" value="<%=objCubBean.getNumero()%>">
    <input type ="hidden" name="txtnumproy" value="<%=objCubBean.getNUMPROY()%>">
    <br>
    <div class="row control-group">
      <div class="form-group col-xs-12 floating-label-form-group controls">
        <select  name="txtniv" id="txtniv" class="form-control">
          <% if(objCubBean.getNivel().equals("Leve")){ %>
          <option value="Leve" selected>Leve</option>
          <option value="Grave">Grave</option>
          <option value="Muy Grave">Muy Grave</option>
          <%}else{
          if(objCubBean.getNivel().equals("Grave")){%> 
          <option value="Leve" >Leve</option>
          <option value="Grave" selected>Grave</option>
          <option value="Muy Grave">Muy Grave</option>
          <%}else{
          if(objCubBean.getNivel().equals("Muy Grave")){%> 
          <option value="Leve" >Leve</option>
          <option value="Grave">Grave</option>
          <option value="Muy Grave" selected>Muy Grave</option>
          <%}}}%>
        </select>
      </div>
    </div>
    <div class="row control-group">
      <div class="form-group col-xs-12 floating-label-form-group controls">
        <label>Descripcion</label>
        <input type="text" class="form-control" name="txtdes" placeholder="Descripcion" value="<%=objCubBean.getDescripción()%>">
        <p class="help-block text-danger"></p>
      </div>
    </div>
    <br>
    <div id="success"></div>
    <center>
      <div class="row">
        <div class="form-group col-xs-12">
          <input type="button" onclick="modificarRiesgoPersonal('<%=request.getContextPath()%>')"value="modificar" class="btn btn-success btn-lg">
        </div>
      </div>
      <div class="row">
        <div class="form-group col-xs-12">
          <input type="button" onclick="cargar('<%=request.getContextPath()%>','Riesgos',8,'cod='+ <%=objCubBean.getNUMPROY()%>)"value="salir" class="btn btn-success btn-lg">
        </div>
      </div> 
    </center>
  </form>
</div>
</div>
</div>
</body>
</html>

