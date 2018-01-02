<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.PersonalBean"%>
<%!
PersonalBean objBean=null;
%>
<%
objBean=(PersonalBean)request.getAttribute("DATOS");
%>
<%!ArrayList<ProyectoBean>lista=null;%>
<%lista=(ArrayList < ProyectoBean >)request.getAttribute("lista1");%>
<html>
<head>
   
</head>
<body >
    <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
        <div class="row titulocontenedor" >
            <div class="col-lg-12 text-center" >
                <h3>REGISTRAR  PERSONAL</h3>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
              <form name="form" ><br>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Codigo</label>
                        <input type="text" class="form-control" placeholder="Codigo" name="txtcod" value="<%=objBean.getCODPERSONAL()%>" readonly="readonly" >
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <br>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <select  name="txtnumproy" id="txtnumproy" class="form-control">
                            <option value="<%=objBean.getNUMPROY()%>"><%=objBean.getNOMBPROY()%></option>
                            <option value="0">-----------------</option>                                <%for(ProyectoBean obj:lista){%>
                            <option value="<%=obj.getNumero()%>"><%=obj.getTitulo()%></option>
                            <%}%>
                        </select>  
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Nombre</label>
                        <input type="text" class="form-control" name="txtnom" placeholder="Nombre" value="<%=objBean.getNOMBPERSONAL()%>" >
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Correo</label>
                        <input type="email"  class="form-control " name="txtema" placeholder="Ejemplo@gmail.com" required value="<%=objBean.getEMAPERSONAL()%>">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Telefono</label>
                        <input type="number" class="form-control"  name="txttel" placeholder="Telefono" value="<%=objBean.getTELFPERSONAL()%>">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Telefono</label>
                        <input type="number" class="form-control" name="txthor" placeholder="Horas Lab." value="<%=objBean.getHORAS()%>">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Dias Laborales</label>
                        <input type="number" class="form-control"  name="txtdia" placeholder="Dias Lab."  value="<%=objBean.getDIAS()%>">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>ID</label>
                        <input type="text" class="form-control" name="txtid" placeholder="ID" value="<%=objBean.getID()%>"> 
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                
                <input type="hidden" class="form-control" name="txtpass" placeholder="Contraseña" value="<%=objBean.getPASS()%>">
                
                <div id="success"></div>
                <center>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <input type="button"  onclick="modificarPersonal('<%=request.getContextPath()%>')"value="modificar" class="btn btn-success btn-lg">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <input type="button"  onclick="salir('<%=request.getContextPath()%>','Personal',4)"  value="salir" class="btn btn-success btn-lg">
                        </div>
                    </div> 
                </center>
            </form>
        </div>
    </div>
</div>
</body>
</html>

