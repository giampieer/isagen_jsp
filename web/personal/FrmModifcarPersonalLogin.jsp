<%@page import="BEAN.PersonalBean"%>
<%!
PersonalBean objBean=null;
%>
<%
objBean=(PersonalBean)request.getAttribute("DATOS");
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
          <input type ="hidden" name="txtcod" value="<%=objBean.getCODPERSONAL()%>">
          <input type ="hidden" name="txtnumproy" value="<%=objBean.getNUMPROY()%>">
          <div class="row control-group">
            
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Nombre</label>
                <input type="text" class="form-control" name="txtnom" placeholder="Nombre"  value="<%=objBean.getNOMBPERSONAL()%>">
                <p class="help-block text-danger"></p>
            </div>
        </div>
        
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Email</label>
                <input type="email" class="form-control" name="txtema" placeholder="Ejemplo@gmail.com"  value="<%=objBean.getEMAPERSONAL()%>"required>
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Telefono</label>
                <input type="number" class="form-control" name="txttel" value="<%=objBean.getTELFPERSONAL()%>"placeholder="Telefono">
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <br>
        
        
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Hora</label>
                <input type="number" class="form-control" placeholder="Hora"  name="txthoras" value="<%=objBean.getHORAS()%>">
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Dias</label>
                <input type="number"  class="form-control " placeholder="Dias" name="txtdias" value="<%=objBean.getDIAS()%>">
                <p class="help-block text-danger"></p>
            </div>
        </div>
        
        <input type="hidden" class="input-49" name="txtid" value="<%=objBean.getID()%>">
        <input type="hidden" class="input-49" name="txtpass" value="<%=objBean.getPASS()%>">
        
        <div id="success"></div>
        <center>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button" onclick="modificarLoginPersonal('<%=request.getContextPath()%>')"  value="modificar" class="btn btn-success btn-lg">
                </div>
                
            </div>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button" onclick="salir('<%=request.getContextPath()%>','Personal',12)" value="salir" class="btn btn-success btn-lg">
                </div>
            </div> 
        </center>
    </form>
</div>
</div>
</div>
</body>
</html>

