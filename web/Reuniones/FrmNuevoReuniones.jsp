
<%@page import="DAO.ReunionesDAO"%>
<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>

<%!   
ReunionesDAO obj=new ReunionesDAO();
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
        function enfocar(){
            document.form.txtnum.focus();
        }
             //calendario
             $('#txtfec').bootstrapMaterialDatePicker({ weekStart : 0, time: false });
             $('#txtreu').bootstrapMaterialDatePicker({ weekStart : 0, time: false });
             
         </script>
     </head>
     
     <body onload="enfocar()">
       <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
        <div class="row titulocontenedor" >
            <div class="col-lg-12 text-center" >
                <h3>REGISTRAR  REUNION</h3>
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
               <% int i=obj.generarCodigo();
               if(i==0){i=1;}
               else{i=obj.generarCodigo();}%>
               <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Codigo</label>
                <input type="text" class="form-control" placeholder="Codigo" name="txtnum" value="<%=i%>" readonly="readonly" >
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Personal Asistente</label>
                <input type="text" class="form-control" name="txtper" placeholder="Personal Asistente">
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
                <label>Fecha</label>
                <input type="text" class="form-control"  name="txtfec" id="txtfec"placeholder="Fecha " >
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Acuerdos</label>
                <input type="text"  class="form-control " name="txtacu" placeholder="Acuerdos"  >
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Fecha Proxima</label>
                <input type="text"  class="form-control " name="txtreu"  id="txtreu"placeholder="Fecha Proxima">
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Duracion</label>
                <input type="text"  class="form-control " name="txtdur" placeholder="Duracion"  >
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <br>
        <div id="success"></div>
        <center>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button"onclick="grabarReunion('<%=request.getContextPath()%>')" value="grabar" class="btn btn-success btn-lg">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button"  onclick="salir('<%=request.getContextPath()%>','Reuniones',4)" value="salir" class="btn btn-success btn-lg">
                </div>
                
            </div> 
        </center>

    </form>
</div>
</div>
</div>

</body>
</html>

