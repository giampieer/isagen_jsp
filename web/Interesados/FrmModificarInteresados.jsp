<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.InteresadosBean"%>
<%!
InteresadosBean objBean=null;
%>
<%
objBean=(InteresadosBean)request.getAttribute("DATOS");
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
<body>
   <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
    <div class="row titulocontenedor" >
        <div class="col-lg-12 text-center" >
            <h3>MODIFICAR  INTERESADO</h3>
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
                        <option value="<%=objBean.getNUMPROY()%>"><%=objBean.getNOMBPROY()%></option>
                        <option value="0">-----------------</option>
                        <%for(ProyectoBean obj:lista){%>
                        <option value="<%=obj.getNumero()%>"><%=obj.getTitulo()%></option>
                        <%}%>
                    </select>
                </div>
            </div>
            <div class="row control-group">
                <div class="form-group col-xs-12 floating-label-form-group controls">
                    <label>Nombre</label>
                    <input type="text" class="form-control"  name="txtnom" placeholder="Nombre" value="<%=objBean.getNOMBRE()%>"  >
                    <p class="help-block text-danger"></p>
                </div>
            </div>
            <div class="row control-group">
                <div class="form-group col-xs-12 floating-label-form-group controls">
                    <label>Importe</label>
                    <input type="text"  class="form-control "name="txtimp" placeholder="Importe" value="<%=objBean.getIMPORTE()%>">
                    <p class="help-block text-danger"></p>
                </div>
            </div>
            <div class="row control-group">
                <div class="form-group col-xs-12 floating-label-form-group controls">
                    <label>Necesidad</label>
                    <input type="text"  class="form-control " name="txtnec" placeholder="Necesidad" value="<%=objBean.getNECESIDADES()%>">
                    <p class="help-block text-danger"></p>
                </div>
            </div>
            <div class="row control-group">
                <div class="form-group col-xs-12 floating-label-form-group controls">
                    <label>Interes</label>
                    <input type="text"  class="form-control "name="txtinte" placeholder="Interes"  value="<%=objBean.getINTERES()%>" >
                    <p class="help-block text-danger"></p>
                </div>
            </div>
            <br>
            <div id="success"></div>
            <center>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <input type="button" onclick="modificarInteresado('<%=request.getContextPath()%>')"  value="modificar" class="btn btn-success btn-lg">
                    </div>
                    
                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <input type="button"  onclick="salir('<%=request.getContextPath()%>','Interesados',4)"  value="salir" class="btn btn-success btn-lg">
                    </div>
                    
                </div> 
            </center>

        </form>
    </div>
</div>
</div>
</body>
</html>

