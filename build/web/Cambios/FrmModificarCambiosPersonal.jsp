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

<body onload="enfocar()">
   <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
    <div class="row titulocontenedor" >
        <div class="col-lg-12 text-center" >
            <h3>MODIFICAR  CAMBIOS</h3>
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
          
          

          <input type ="hidden" name="txtnum" value="<%=objBean.getNUMERO()%>">
          <br>
          <input type ="hidden" name="txtnumproy" value="<%=objBean.getNUMPROY()%>">
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
                    <input type="button" onclick="modificarCambioPersonal('<%=request.getContextPath()%>')" value="modificar" class="btn btn-success btn-lg">
                </div>
                
            </div>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button"  onclick="cargar('<%=request.getContextPath()%>','Cambios',8,'cod='+ <%=objBean.getNUMPROY()%>)" value="salir" class="btn btn-success btn-lg">
                </div>
                
            </div> 
        </center>

    </form>
</div>
</div>
</div>

</body>
</html>


