<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.ActividadesBean"%>
<%!
ActividadesBean objBean=null;
%>
<%
objBean=(ActividadesBean)request.getAttribute("DATOS");
%>


<html>
<head>
</head>
<body onload="enfocar()">
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
                    <input type ="hidden" name="txtnum" value="<%=objBean.getNumero()%>">
                    <input type ="hidden" name="txtnumproy" value="<%=objBean.getNUMPROY()%>">
                    <br>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Actividad</label>
                            <input type="text" class="form-control" name="txtact" value="<%=objBean.getActividad()%>"placeholder="Actividad"  >
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Duracion</label>
                            <input type="text" class="form-control"  name="txtdur" value="<%=objBean.getDuracion()%>" placeholder="Duracion" >
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Responsable</label>
                            <input type="text" class="form-control"  name="txtres" value="<%=objBean.getResponsable()%>" placeholder="Responsable" >
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div id="success"></div>
                    <center>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <input type="button"  onclick="modificarActividadPersonal('<%=request.getContextPath()%>')"  value="modificar"class="btn btn-success btn-lg">
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <input type="button"   onclick="cargar('<%=request.getContextPath()%>','Actividades',8,'cod='+<%=objBean.getNUMPROY()%>)" value="salir" class="btn btn-success btn-lg">
                            </div>
                            
                        </div> 
                    </center>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

