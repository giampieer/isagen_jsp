<%@page import="BEAN.PersonalBean"%>

<%!
PersonalBean objCubBean=null;
%>
<%
objCubBean=(PersonalBean)request.getAttribute("DATOS");
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
          <input type ="hidden" name="txtnumproy" value="<%=objCubBean.getNUMPROY()%>">
          <input type ="hidden" name="txtcod" value="<%=objCubBean.getCODPERSONAL()%>">
          <input type="hidden" class="form-control" name="txtnom" value="<%=objCubBean.getNOMBPERSONAL()%> " >
          <input type="hidden" class="form-control" name="txtema" value="<%=objCubBean.getEMAPERSONAL()%>">
          <input type="hidden" class="form-control" name="txttel" value="<%=objCubBean.getTELFPERSONAL()%>" >
          <input type="hidden" class="form-control" name="txtdias" value="<%=objCubBean.getDIAS()%>" >
          <input type="hidden" class="form-control" name="txthoras" value="<%=objCubBean.getHORAS()%>" >
          <input type ="hidden" name="txtid" value="<%=objCubBean.getID()%>">
          <input type ="hidden" name="txtpass" value="<%=objCubBean.getPASS()%>">
          
          <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Ingrese contraseña actual</label>
                <input type="password"  maxlength="4"class="form-control" name="txtactual" placeholder="&#128273;Ingrese contraseña actual">
                <p class="help-block text-danger"></p>
            </div>
        </div>
        
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Ingrese nueva contraseña</label>
                <input type="password"  maxlength="4"class="form-control" name="txtnuevo" placeholder="&#128273;Ingrese nueva contraseña">
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <div id="success"></div>
        <center>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button"onclick="modificarLoginClavePersonal('<%=request.getContextPath()%>')"  value="modificar" class="btn btn-success btn-lg">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button" onclick="salir('<%=request.getContextPath()%>','Personal',12)"value="salir" class="btn btn-success btn-lg">
                </div>
            </div> 
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button" onclick="correoperso('<%=request.getContextPath()%>')"  value="Enviar correo" class="btn btn-success btn-lg">
                </div>
            </div>
        </center>
    </form>
</div>
</div>
</div>
</body>
</html>


