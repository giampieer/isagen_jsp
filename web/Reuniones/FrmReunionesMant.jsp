<%@page  import="java.util.ArrayList" %>
<%@page  import="BEAN.ReunionesBean" %>

<%!
ArrayList<ReunionesBean> lista=null;
%>
<%
lista=(ArrayList<ReunionesBean>)request.getAttribute("lista");
%>
<html>
<head>        
  <script>
    paginacion();
  </script>                              
</head>
<body>
 <br>
 <div class="animated zoomIn">
  <div class="panel ">
   <div class="panel-heading titulocontenedor">
    <h3 ><strong><center>Relacion de Reuniones</center></strong></h3>  
    <hr class="star-primary">
  </div>
  <br>
  <input class="btn btn-success btn-lg" type="button" value="Nuevo" onclick="MenuOpciones('<%=request.getContextPath()%>','Reuniones',2,'')" >              
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
                <th>PROYECTO</th>
                <th>PERSONAL ASISTENTE</th>
                <th>FECHA</th>
                <th>ACUERDOS</th>
                <th>PROXIMA REUNION</th>
                <th>DURACION</th>
                <th> </th>
                <th> </th>
              </tr>
            </thead>
            <tbody>
              <% for(ReunionesBean obj:lista){ %>
              <tr >
                <td><%=obj.getNUMERO()%></td>
                <td><%=obj.getNOMBPROY()%></td>
                <td><%=obj.getPERSONAL()%></td>
                <td><%=obj.getFECHA()%></td>
                <td><%=obj.getACUERDOS()%></td>
                <td><%=obj.getREUNION()%></td>
                <td><%=obj.getDURACION()%></td>
                <td align="center"><input class="animated infinite pulse" type="image"width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getNUMERO()%>" onclick="cargar('<%=request.getContextPath()%>','Reuniones',5,'cod='+<%= obj.getNUMERO()%>)"></td>
                <td align="center"><input  class="animated infinite pulse"type="image" width="30px"src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir" value="<%=obj.getNUMERO()%>" onclick="eliminar('<%=request.getContextPath()%>','Reuniones',7,'cod='+<%= obj.getNUMERO()%>)"></td>
                
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