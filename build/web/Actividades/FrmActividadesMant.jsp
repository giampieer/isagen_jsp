<%@page  import="java.util.ArrayList" %>
<%@page  import="BEAN.ActividadesBean" %>

<%!
ArrayList<ActividadesBean> lista=null;
%>
<%
lista=(ArrayList<ActividadesBean>)request.getAttribute("lista"); 
%>
<html>
<head>
  <script>
    paginacion();
  </script>                
  
</head>
<body >

 <br>
 <div class="animated zoomIn">
  <div class="panel ">
   <div class="panel-heading titulocontenedor">
    <h3 ><strong><center>Relacion de Actividades</center></strong></h3>  
    <hr class="star-primary">
  </div>
  <br>
  <input class=" btn btn-success btn-lg"  type="button" value="Nuevo" onclick="MenuOpciones('<%=request.getContextPath()%>','Actividades',2,'')" >              
  <div class="container-fluid">
    <div class="panel-body">                      
      <div class="form-group text-center">
        <div class="table-responsive">
          
          <% if(request.getAttribute("mensaje")!=null){
          String mensaje = (String)request.getAttribute("mensaje");
          %>
          <div class="alert alert-success animated bounceInRight">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong><%=mensaje%></strong>

          </div> 
          <%  }   %>
          
            <table class="table table-hover" id="tabla"cellspacing="0" width="100%" >               
            <thead class="table-hover">
              <tr >
                
                <th>NUMERO</th>
                <th>PROYECTO ELEGIDO</th>                  
                <th>ACTIVIDAD</th>
                <th>DURACION</th>
                <th>RESPONSABLE</th>              
                <th> </th>
                <th> </th>
                
              </tr>
            </thead>
            <tbody>
             <%  for(ActividadesBean obj:lista){     %>
             <tr >                  
              <td ><%=obj.getNumero()%></td>
              <td ><%=obj.getNOMBPROY()%></td>
              <td ><%=obj.getActividad()%></td>
              <td ><%=obj.getDuracion()%></td>
              <td ><%=obj.getResponsable()%></td>
              <td align="center"><input class="animated infinite pulse"type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getNumero()%>" onclick="cargar('<%=request.getContextPath()%>','Actividades',5,'cod='+<%= obj.getNumero()%>)"></td>
              <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir" value="<%=obj.getNumero()%>" onclick="eliminar('<%=request.getContextPath()%>','Actividades',7,'cod='+<%=obj.getNumero()%>)"></td>
              <%    }   %> 
            </tr>
          </tbody>
        </table>
      </div>
      
    </div>
  </div>
</div>   
</div>
</div>
</body>
</html>