<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.JefeBean"%>
<%@page import="BEAN.ProyectoBean"%>
<%!
ProyectoBean objCubBean=null;
%>
<%
objCubBean=(ProyectoBean)request.getAttribute("DATOS");
%>

<%!
ArrayList<JefeBean>lista=null;

%>
<%
lista=(ArrayList<JefeBean>)request.getAttribute("lista1");
%>
<html lang="en">
<head>
   <script>
          //calendario
          $('#txtini').bootstrapMaterialDatePicker({ weekStart : 0, time: false });
          $('#txtfin').bootstrapMaterialDatePicker({ weekStart : 0, time: false });
          
      </script>
  </head>
  <body>
    <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px;">
        <div class="row" style="background-color: #009688">
            <div class="col-lg-12 text-center">
                <h3>MODIFICAR PROYECTO</h3>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
               <form name="form" id="contactForm" novalidate>
                  <input class="form-control" placeholder="Codigo" name="txtnum"   readonly="readonly"type ="hidden"   value="<%=objCubBean.getNumero()%>">
                  <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Titulo del Proyecto</label>
                        <input type="text" class="form-control" name="txttit" placeholder="Titulo del Proyecto" value="<%=objCubBean.getTitulo()%>">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <br>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                      
                        <select name="txtcodjefe" id="txtcodjefe" class="form-control">
                            <option value="<%=objCubBean.getCODJEFE()%>"><%=objCubBean.getNOMBJEFE()%></option>
                            <%for(JefeBean obj:lista){%>
                            <option value="<%=obj.getCODJEFE()%>"><%=obj.getNOMBJEFE()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Duracion</label>
                        <input type="text" class="form-control" name="txtdur" placeholder="Duracion" value="<%=objCubBean.getDuracion()%>">
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
                        <label>Fecha Inicio</label>
                        <input type="text" class="form-control" name="txtini" id="txtini" placeholder="Fecha Inicio"value="<%=objCubBean.getInicio()%>" >
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <label>Fecha Fin</label>
                        <input type="text" class="form-control" name="txtfin" id="txtfin" placeholder="Fecha Fin"value="<%=objCubBean.getFin()%>">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <br>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <select  name="txttip" id="txttip" class="form-control" >
                         <% if(objCubBean.getTipo().equals("Publicos")){ %>
                         <option value="Publicos" selected>PUBLICOS</option>
                         <option value="Privados">PRIVADOS</option>
                         <option value="Experimentales">EXPERIMENTALES</option>
                         <option value="Normalizados">NORMALIZADOS</option>
                         <option value="Productivos">PRODUCTIVOS</option>
                         <option value="Sociales">SOCIALES</option>
                         <option value="Investigacion">INVESTIGACION</option>
                         <%}else{
                         if(objCubBean.getTipo().equals("Privados")){%> 
                         <option value="Publicos" >PUBLICOS</option>
                         <option value="Privados" selected>PRIVADOS</option>
                         <option value="Experimentales">EXPERIMENTALES</option>
                         <option value="Normalizados">NORMALIZADOS</option>
                         <option value="Productivos">PRODUCTIVOS</option>
                         <option value="Sociales">SOCIALES</option>
                         <option value="Investigacion">INVESTIGACION</option>
                         
                         
                         
                         <%}else{
                         if(objCubBean.getTipo().equals("Normalizados")){%> 
                         <option value="Publicos" >PUBLICOS</option>
                         <option value="Privados" >PRIVADOS</option>
                         <option value="Experimentales">EXPERIMENTALES</option>
                         <option value="Normalizados" selected>NORMALIZADOS</option>
                         <option value="Productivos">PRODUCTIVOS</option>
                         <option value="Sociales">SOCIALES</option>
                         <option value="Investigacion">INVESTIGACION</option>
                         
                         <%}else{
                         if(objCubBean.getTipo().equals("Experimentales")){%> 
                         <option value="Publicos" >PUBLICOS</option>
                         <option value="Privados" >PRIVADOS</option>
                         <option value="Experimentales" selected>EXPERIMENTALES</option>
                         <option value="Normalizados" >NORMALIZADOS</option>
                         <option value="Productivos">PRODUCTIVOS</option>
                         <option value="Sociales">SOCIALES</option>
                         <option value="Investigacion">INVESTIGACION</option>
                         <%}else{
                         if(objCubBean.getTipo().equals("Productivos")){%> 
                         <option value="Publicos" >PUBLICOS</option>
                         <option value="Privados" >PRIVADOS</option>
                         <option value="Experimentales" >EXPERIMENTALES</option>
                         <option value="Normalizados" >NORMALIZADOS</option>
                         <option value="Productivos" selected>PRODUCTIVOS</option>
                         <option value="Sociales">SOCIALES</option>
                         <option value="Investigacion">INVESTIGACION</option>
                         <%}else{
                         if(objCubBean.getTipo().equals("Sociales")){%> 
                         <option value="Publicos" >PUBLICOS</option>
                         <option value="Privados" >PRIVADOS</option>
                         <option value="Experimentales" >EXPERIMENTALES</option>
                         <option value="Normalizados" >NORMALIZADOS</option>
                         <option value="Productivos">PRODUCTIVOS</option>
                         <option value="Sociales" selected>SOCIALES</option>
                         <option value="Investigacion">INVESTIGACION</option>
                         <%}else{
                         if(objCubBean.getTipo().equals("Investigacion")){%> 
                         <option value="Publicos" >PUBLICOS</option>
                         <option value="Privados" >PRIVADOS</option>
                         <option value="Experimentales" >EXPERIMENTALES</option>
                         <option value="Normalizados" >NORMALIZADOS</option>
                         <option value="Productivos">PRODUCTIVOS</option>
                         <option value="Sociales">SOCIALES</option>
                         <option value="Investigacion" selected>INVESTIGACION</option>
                         
                         
                         <%}}}}}}}%>
                     </select>
                 </div>
             </div>
             <div class="row control-group">
                <div class="form-group col-xs-12 floating-label-form-group controls">
                    <label>Fases</label>
                    <input type="number" class="form-control"name="txtcan" placeholder="Fases" value="<%=objCubBean.getFases()%>">
                    <p class="help-block text-danger"></p>
                </div>
            </div>
            <div class="row control-group">
                <div class="form-group col-xs-12 floating-label-form-group controls">
                    <label>Presupuesto</label>
                    <input type="text" class="form-control"name="txtpre" placeholder="Presupuesto" value="<%=objCubBean.getGastos()%>">
                    <p class="help-block text-danger"></p>
                </div>
            </div>
            
            <br>
            <div id="success"></div>
            <center>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <input type="button" onclick="modificarProyecto('<%=request.getContextPath()%>')" value="modificar" class="btn btn-success btn-lg">
                    </div>
                    
                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <input type="button" onclick="salir('<%=request.getContextPath()%>','Proyecto',4)" value="salir" class="btn btn-success btn-lg">
                    </div>
                    
                </div> 
            </center>

        </form>
    </div>
</div>
</div>
</body>
</html>

