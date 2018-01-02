<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.ActividadesBean"%>
<%!
ActividadesBean objBean=null;
%>
<%
objBean=(ActividadesBean)request.getAttribute("DATOS");
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
<body >
    <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
        <div class="row titulocontenedor" >
            <div class="col-lg-12 text-center" >
                <h3>MODIFICAR  ACTIVIDAD</h3>
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
                        <label>Codigo</label>
                        <input type="text" class="form-control" placeholder="Codigo" name="txtnum" value="<%=objBean.getNumero()%>"readonly="readonly" >
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <br>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <select name="txtnumproy" id="txtnumproy" class="form-control">
                            <option value="<%=objBean.getNUMPROY()%>"><%=objBean.getNOMBPROY()%></option>
                            <option value="0">-----------------</option>
                            <%for(ProyectoBean obj:lista){%>
                            <option value="<%=obj.getNumero()%>"><%=obj.getTitulo()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>
                <br>

                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Actividad</label>
                        <input type="text" class="form-control"  name="txtact" placeholder="Actividad" value="<%=objBean.getActividad()%>" >
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Duracion</label>
                        <input type="text" class="form-control"  name="txtdur" placeholder="Duracion"value="<%=objBean.getDuracion()%>"  >
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Responsable</label>
                        <input type="text" class="form-control"  name="txtres" placeholder="Responsable" value="<%=objBean.getResponsable()%>">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div id="success"></div>
                <center>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <input type="button"onclick="modificarActividad('<%=request.getContextPath()%>')"value="modificar" class="btn btn-success btn-lg">
                        </div>
                        
                    </div>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <input type="button"  onclick="salir('<%=request.getContextPath()%>','Actividades',4)"  value="salir" class="btn btn-success btn-lg">
                        </div>
                        
                    </div> 
                </center>
            </form>
        </div>
    </div>
</div>
</body>
</html>

