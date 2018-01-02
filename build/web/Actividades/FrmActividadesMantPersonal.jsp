<%@page  import="java.util.ArrayList" %>
<%@page  import="BEAN.ActividadesBean" %>

<%!
ArrayList<ActividadesBean> lista=null;
%>
<%
lista=(ArrayList<ActividadesBean>)request.getAttribute("lista"); 
%>
<%! ActividadesBean obj=null;%>
<%obj=(ActividadesBean)request.getAttribute("numproy");%>
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
    <input class=" btn btn-success btn-lg"  type="button" value="Nuevo"onclick="cargar('<%=request.getContextPath()%>','Actividades',9,'cod='+<%=obj.getNUMPROY()%>)"   >              
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
                  <th>NUMERO DE LA ACTIVIDAD </th>    
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
                <td ><%=obj.getActividad()%></td>
                <td ><%=obj.getDuracion()%></td>
                <td ><%=obj.getResponsable()%></td>
                <td ><input type="image" class="animated infinite pulse" width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getNumero()%>" onclick="cargar('<%=request.getContextPath()%>','Actividades',12,'cod='+<%= obj.getNumero()%>)"></td>
                <td ><input type="image" class="animated infinite pulse" width="30px" src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir" value="<%=obj.getNumero()%>" onclick="eliminar('<%=request.getContextPath()%>','Actividades',13,'cod='+<%=obj.getNumero()%>+'&codproy='+<%= obj.getNUMPROY()%>)"></td>
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