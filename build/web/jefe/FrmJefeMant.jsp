<%@page  import="java.util.ArrayList" %>
<%@page  import="BEAN.JefeBean" %>

<%!
ArrayList<JefeBean> lista=null;
%>
<%
lista=(ArrayList<JefeBean>)request.getAttribute("lista"); 
%>
<html>
<head>        
    <script>
      paginacion();
  </script>                              
</head>
<body>
   <br>
   <div  class="animated zoomIn">
    <div class="panel ">
        <div class="panel titulocontenedor" >
            <h3><strong><center>Relacion de los Jefes</center></strong></h3>                            
            <hr class="star-primary">
        </div>
        
        <div class="btntabla">
            <input class="btn btn-success btn-lg" type="button" value="Nuevo" onclick="MenuOpciones('<%=request.getContextPath()%>','Jefe',2,'')" >              
        </div>
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
                                
                                <th>CODIGO</th>
                                <th>NOMBRE</th>
                                <th>CORREO</th>
                                <th>TELEFONO</th>
                                <th>AREA</th>  
                                <th>ID</th>  
                                <th>PASS</th>  
                                <th> </th>
                                <th> </th>
                                
                            </tr>
                        </thead>
                        <tbody>
                           <%  for(JefeBean obj:lista){     %>
                           <tr >
                            <td><%=obj.getCODJEFE()%></td>
                            <td><%=obj.getNOMBJEFE()%></td>
                            <td><%=obj.getEMAJEFE()%></td>
                            <td><%=obj.getTELFJEFE()%></td>
                            <td><%=obj.getAREAJEFE()%></td>
                            <td><%=obj.getID()%></td>
                            <td><%=obj.getPASS()%></td>
                            <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getCODJEFE()%>" onclick="cargar('<%=request.getContextPath()%>','Jefe',5,'cod='+<%= obj.getCODJEFE()%>)"></td>
                            <td align="center"><input class="animated infinite pulse"type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir" value="<%=obj.getCODJEFE()%>" onclick="eliminar('<%=request.getContextPath()%>','Jefe',7,'cod='+<%= obj.getCODJEFE()%>)"></td>
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