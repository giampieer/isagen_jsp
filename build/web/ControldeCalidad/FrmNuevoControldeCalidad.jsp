
<%@page import="DAO.ControldeCalidadDAO"%>
<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%!
ArrayList<ProyectoBean>lista=null;

%>
<%!   
ControldeCalidadDAO obj=new ControldeCalidadDAO();
%>
<%
lista=(ArrayList<ProyectoBean>)request.getAttribute("lista1");
%>
<html>
<head>
   

    <script>
        function enfocar(){
            document.form.txtNum.focus();
        }
        
    </script>
</head>
<body onload="enfocar()">
   <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
    <div class="row titulocontenedor" >
        <div class="col-lg-12 text-center" >
            <h3>REGISTRAR  CONTROL DE CALIDAD</h3>
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
          
          <div class="row control-group">
           <% int i=obj.generarCodigo();
           if(i==0){i=1;}
           else{i=obj.generarCodigo();}%>
           <div class="form-group col-xs-12 floating-label-form-group controls">
            <label>Codigo</label>
            <input type="text" class="form-control" placeholder="Codigo" name="txtcod" value="<%=i%>" readonly="readonly" >
            <p class="help-block text-danger"></p>
        </div>
    </div>


    
    <br>
    <div class="row control-group">
        <div class="form-group col-xs-12 floating-label-form-group controls">
            <select  name="txtnumproy" id="txtnumproy" class="form-control">
                <option value="0">----- Seleccionar Proyecto ----</option>
                <%for(ProyectoBean obj:lista){%>
                <option value="<%=obj.getNumero()%>"><%=obj.getTitulo()%></option>
                <%}%>
            </select>
        </div>
    </div>
    
    
    <div class="row control-group">
        <div class="form-group col-xs-12 floating-label-form-group controls">
            <label>Plan de Gestion</label>
            <input type="text" class="form-control" name="txtplge" placeholder="Plan de Gestion"  >
            <p class="help-block text-danger"></p>
        </div>
    </div>
    
    <div class="row control-group">
        <div class="form-group col-xs-12 floating-label-form-group controls">
            <label>Plan de Mejora</label>
            <input type="text" class="form-control" name="txtplca" placeholder="Plan de Mejora" >
            <p class="help-block text-danger"></p>
        </div>
    </div>
    <br>
    <div class="row control-group">
        <div class="form-group col-xs-12 floating-label-form-group controls">
         <select  name="txtmeca" id="txtmeca" class="form-control" >
            <option value="0">-------- Seleccionar Metricas de Calidad Hechas --------</option>
            <option value="Ninguna metrica Realizada">NINGUNA METRICA REALIZADA</option>
            <option value="Operacion - Revision - Transicion">FACTORES QUE AFECTAN LA CALIDAD</option>
            <option value="Correccion - Mantenimiento - Facilidad de uso - Integridad">MEDIDA DE CALIDAD </option>
            <option value="Numero de Errores - Defectos Encontrados">EFICACIA DE LA ELIMINACION DE DEFECTOS</option>
        </select>
    </div>
</div>
<br>
<div class="row control-group">
    <div class="form-group col-xs-12 floating-label-form-group controls">
        <label>Actualizaciones</label>
        <input type="text" class="form-control"   name="txtacdo" placeholder="Actualizaciones"  >
        <p class="help-block text-danger"></p>
    </div>
</div>

<div id="success"></div>
<center>
    <div class="row">
        <div class="form-group col-xs-12">
            <input type="button" onclick="grabarControl('<%=request.getContextPath()%>')"value="grabar" class="btn btn-success btn-lg">
        </div>
        
    </div>
    <div class="row">
        <div class="form-group col-xs-12">
            <input type="button"  onclick="salir('<%=request.getContextPath()%>','ControldeCalidad',4)"value="salir" class="btn btn-success btn-lg">
        </div>
        
    </div> 
</center>

</form>
</div>
</div>
</div>
</body>
</html>

