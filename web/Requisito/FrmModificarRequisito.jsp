<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.RequisitoBean"%>
<%!
RequisitoBean objCubBean=null;
%>
<%
objCubBean=(RequisitoBean)request.getAttribute("DATOS");
%>
<!-- cargar el combobox con datos del proyecto-->
<%!
ArrayList<ProyectoBean>lista=null;

%>
<%
lista=(ArrayList<ProyectoBean>)request.getAttribute("lista1");
%>

<html>
<html>
<head>      
</head>
<body>
    <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px;">
        <div class="row" style="background-color: #009688">
            <div class="col-lg-12 text-center">
                <h3>MODIFICAR REQUISITO</h3>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <form name="form" id="contactForm" novalidate>
                  <input class="form-control" type ="hidden" name="txtnum" value="<%=objCubBean.getNumero()%>">
                  <br>
                  <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <select  name="txtnumproy" id="txtnumproy" class="form-control" >
                            <option value="<%=objCubBean.getNUMPROY()%>"><%=objCubBean.getNOMBPROY()%></option>
                            <option value="0">-----------------</option>                               
                            <%for(ProyectoBean obj:lista){%>
                            <option value="<%=obj.getNumero()%>"><%=obj.getTitulo()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>
                
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Alcance</label>
                        <input type="text" class="form-control" placeholder="Alcance" name="txtalc" value="<%=objCubBean.getAlcance()%>">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Descripcion del Proyecto</label>
                        <input type="text" class="form-control"name="txtdes" placeholder="Descripcion del Proyecto" value="<%=objCubBean.getDescripcion()%>" >
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Cantidad de Personal</label>
                        <input type="number" class="form-control" placeholder="Cantidad de Personal"name="txtper" value="<%=objCubBean.getPersonal()%>" >
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Cantidad de Reuniones</label>
                        <input type="number" class="form-control" placeholder="Cantidad de Reuiniones" name="txtreu" value="<%=objCubBean.getReunion()%>">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <br>
                <div id="success"></div>
                <center>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <input type="button" onclick="modificarRequisito('<%=request.getContextPath()%>')" value="modificar" class="btn btn-success btn-lg">
                        </div>
                        
                    </div>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <input type="button" onclick="salir('<%=request.getContextPath()%>','Requisito',4)" value="salir" class="btn btn-success btn-lg">
                        </div>
                    </div> 
                </center>
            </form>
        </div>
    </div>
</div>
</body>
</html>

