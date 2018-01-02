<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.CambiosBean"%>
<%!
CambiosBean objBean=null;
%>
<%
objBean=(CambiosBean)request.getAttribute("DATOS");
%>

<%!
ArrayList<ProyectoBean>lista=null;

%>
<%
lista=(ArrayList<ProyectoBean>)request.getAttribute("lista1");
%>
<html>
<head>
   <script>
    $('#txtfec').bootstrapMaterialDatePicker({ weekStart : 0, time: false });
</script>
</head>
<body>
    <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
        <div class="row titulocontenedor" >
            <div class="col-lg-12 text-center" >
                <h3>MODIFICAR CAMBIOS</h3>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <form name="form" ><br>
                    <div class="row control-group">

                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Codigo</label>
                            <input type="text" class="form-control" placeholder="Codigo" name="txtnum" value="<%=objBean.getNUMERO()%>"readonly="readonly" >
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>


                    
                    <br>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <select  name="txtnumproy" id="txtnumproy" class="form-control">
                                <option value="<%=objBean.getNUMPROY()%>"><%=objBean.getNOMBPROY()%> </option>
                                <option value="0">-----------------</option>
                                <%for(ProyectoBean obj:lista){%>
                                <option value="<%=obj.getNumero()%>"><%=obj.getTitulo()%></option>
                                <%}%>
                            </select>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Fecha</label>
                            <input type="text" class="form-control"   name="txtfec" id="txtfec" placeholder="Fecha"  value="<%=objBean.getFECHA()%>">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Acuerdos</label>
                            <input type="text"  class="form-control "name="txtpro" placeholder="Proposito" value="<%=objBean.getPROPOSITO()%>">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Fecha Proxima</label>
                            <input type="text"  class="form-control "name="txtimp" placeholder="Importancia" value="<%=objBean.getIMPORTANCIA()%>">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>

                    <br>
                    <div id="success"></div>
                    <center>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <input type="button" onclick="modificarCambio('<%=request.getContextPath()%>')" value="grabar" class="btn btn-success btn-lg">
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <input type="button"   onclick="salir('<%=request.getContextPath()%>','Cambios',4)" value="salir" class="btn btn-success btn-lg">
                            </div>
                            
                        </div> 
                    </center>

                </form>
            </div>
        </div>
    </div>
</body>
</html>

