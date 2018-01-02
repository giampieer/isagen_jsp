
<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.ControldeCalidadBean"%>
<%!
ControldeCalidadBean objCubBean=null;
%>
<%
objCubBean=(ControldeCalidadBean)request.getAttribute("DATOS");
%>


<html>
<head>

</head>

<body onload="enfocar()">
   <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
    <div class="row titulocontenedor" >
        <div class="col-lg-12 text-center" >
            <h3>MODIFICACION DEL CONTROL DE CALIDAD</h3>
            <hr class="star-primary">
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
            <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
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
          
          


          
          <br>

          <input type ="hidden" name="txtcod" value="<%=objCubBean.getNumero()%>">
          <input type ="hidden" name="txtnumproy" value="<%=objCubBean.getNUMPROY()%>">
          
          <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Plan de Gestion</label>
                <input type="text" class="form-control" name="txtplge" value="<%=objCubBean.getPlandegestion()%>"placeholder="Plan de Gestion"  >
                <p class="help-block text-danger"></p>
            </div>
        </div>
        
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Plan de Mejora</label>
                <input type="text" class="form-control" name="txtplca" value="<%=objCubBean.getPlandemejoradecalidad()%>"  placeholder="Plan de Mejora" >
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <br>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <select  name="txtmeca" id="txtmeca" class="form-control">
                    <% if(objCubBean.getMetricasdecalidad().equalsIgnoreCase("NINGUNA METRICA REALIZADA")){ %>
                    <option value="Ninguna metrica Realizada" selected>NINGUNA METRICA REALIZADA</option>
                    <option value="Operacion - Revision - Transicion">FACTORES QUE AFECTAN LA CALIDAD</option>
                    <option value="Correccion - Mantenimiento - Facilidad de uso - Integridad">MEDIDA DE CALIDAD </option>
                    <option value="Numero de Errores - Defectos Encontrados">EFICACIA DE LA ELIMINACION DE DEFECTOS</option>
                    <%}else{
                    if(objCubBean.getMetricasdecalidad().equalsIgnoreCase("OPERACION - REVISION - TRANSICION")){%> 
                    <option value="Ninguna metrica Realizada">NINGUNA METRICA REALIZADA</option>
                    <option value="Operacion - Revision - Transicion" selected>FACTORES QUE AFECTAN LA CALIDAD</option>
                    <option value="Correccion - Mantenimiento - Facilidad de uso - Integridad">MEDIDA DE CALIDAD </option>
                    <option value="Numero de Errores - Defectos Encontrados">EFICACIA DE LA ELIMINACION DE DEFECTOS</option>
                    <%}else{
                    if(objCubBean.getMetricasdecalidad().equalsIgnoreCase("CORRECCION - MANTENIMIENTO - FACILIDAD DE USO - INTEGRIDAD")){%> 
                    <option value="Ninguna metrica Realizada">NINGUNA METRICA REALIZADA</option>
                    <option value="Operacion - Revision - Transicion">FACTORES QUE AFECTAN LA CALIDAD</option>
                    <option value="Correccion - Mantenimiento - Facilidad de uso - Integridad" selected>MEDIDA DE CALIDAD </option>
                    <option value="Numero de Errores - Defectos Encontrados">EFICACIA DE LA ELIMINACION DE DEFECTOS</option>
                    <%}else{
                    if(objCubBean.getMetricasdecalidad().equalsIgnoreCase("NUMERO DE ERRORES - DEFECTOS ENCONTRADOS")){%> 
                    <option value="Ninguna metrica Realizada">NINGUNA METRICA REALIZADA</option>
                    <option value="Operacion - Revision - Transicion">FACTORES QUE AFECTAN LA CALIDAD</option>
                    <option value="Correccion - Mantenimiento - Facilidad de uso - Integridad">MEDIDA DE CALIDAD </option>
                    <option value="Numero de Errores - Defectos Encontrados" selected>EFICACIA DE LA ELIMINACION DE DEFECTOS</option>
                    
                    
                    <%}}}}%>
                </select>
            </div>
        </div>
        <br>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Actualizaciones</label>
                <input type="text" class="form-control"   name="txtacdo" placeholder="Actualizaciones" value="<%=objCubBean.getActualizacionesdeladocumentacion()%> " >
                <p class="help-block text-danger"></p>
            </div>
        </div>
        
        <div id="success"></div>
        <center>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button"  onclick="modificarControlPersonal('<%=request.getContextPath()%>')" value="modificar" class="btn btn-success btn-lg">
                </div>
                
            </div>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button"  onclick="cargar('<%=request.getContextPath()%>','ControldeCalidad',8,'cod='+<%=objCubBean.getNUMPROY()%>)"value="salir" class="btn btn-success btn-lg">
                </div>
                
            </div> 
        </center>

    </form>
</div>
</div>
</div>
</body>
</html>

