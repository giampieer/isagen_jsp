
<%@page import="BEAN.JefeBean"%>
<%@page import="BEAN.ProblemaBean"%>
<%!
JefeBean objCubBean=null;
%>
<%
objCubBean=(JefeBean)request.getAttribute("DATOS");
%>
<html>
<head>

</head>
<body>
    <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
        <div class="row titulocontenedor" >
            <div class="col-lg-12 text-center" >
                <h3>MODIFICAR  CLAVE</h3>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
             <form name="form" >
                <input type ="hidden" name="txtcod" value="<%=objCubBean.getCODJEFE()%>">
                <input type ="hidden" name="txtnom" value="<%=objCubBean.getNOMBJEFE()%>">
                <input type ="hidden" name="txtema" value="<%=objCubBean.getEMAJEFE()%>">
                <input type ="hidden" name="txttel" value="<%=objCubBean.getTELFJEFE()%>">
                <input type ="hidden" name="txtare" value="<%=objCubBean.getAREAJEFE()%>">
                <input type ="hidden" name="txtid" value="<%=objCubBean.getID()%>">
                <input type ="hidden" name="txtpass" value="<%=objCubBean.getPASS()%>">
                
                <div class="mens">
                   <% if(request.getAttribute("mensaje")!=null){
                   String mensaje = (String)request.getAttribute("mensaje");
                   %>
                   <div class="alert alert-success animated bounceInRight">
                      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                      <strong><%=mensaje%></strong></div> 
                      <%  }   %>
                  </div>
                  <div class="row control-group">

                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Contraseña Actual</label>
                        <input type="password"  maxlength="4"class="form-control" name="txtactual" placeholder="&#128273;contraseña actual"></div>
                        <p class="help-block text-danger"></p>
                    </div>
                    
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Contraseña Nueva</label>
                            <input type="password" maxlength="4"class="form-control" name="txtnuevo" placeholder="&#128273;nueva contraseña">                                
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    
                    <div id="success"></div>
                    <center>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <input type="button" onclick="modificarLoginClaveJefe('<%=request.getContextPath()%>')" value="modificar" class="btn btn-success btn-lg">                            </div>
                                
                            </div>
                            <div class="row">
                                <div class="form-group col-xs-12">
                                  <input type="button" onclick="salir('<%=request.getContextPath()%>','Jefe',12)" value="salir" class="btn btn-success btn-lg">
                              </div>
                              
                          </div> 
                          <div class="row">
                            <div class="form-group col-xs-12">
                                <input type="button" onclick="correojefe('<%=request.getContextPath()%>')"  value="Enviar correo" class="btn btn-success btn-lg">
                            </div>
                            
                        </div> 
                    </center>

                </form>
            </div>
            
        </div>
    </div>
</body>
</html>


