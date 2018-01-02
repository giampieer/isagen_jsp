<%@page  import="java.util.ArrayList" %>
<%@page  import="BEAN.ProyectoBean" %>

<%!
ArrayList<ProyectoBean> lista=null;
%>
<%
lista=(ArrayList<ProyectoBean>)request.getAttribute("lista");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script>
      paginacion();
  </script>
</head>
<body>
   <br>
   <div class="animated zoomIn"  >
    <div class="panel ">
        <div class="panel-heading titulocontenedor">
            <h3 ><strong><center>Relacion de los Proyectos</center></strong></h3>  
            <hr class="star-primary">
        </div>
        <br>
        <div class="btntabla">
            <input class="btn btn-success btn-lg" type="button" value="Nuevo" onclick="MenuOpciones('<%=request.getContextPath()%>','Proyecto',2,'')" >              
        </div>
        <div class="container-fluid">
            <div class="panel-body">                      
                <div class="form-group text-center">
                    <div class="table-responsive ">
                      
                        <% if(request.getAttribute("mensaje")!=null){
                        String mensaje = (String)request.getAttribute("mensaje");
                        %>
                        <div class="alert alert-success animated bounceInRight">
                          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                          <strong><%=mensaje%></strong>
                      </div> 
                      <%  } %>
                      <table class="table table-hover" id="tabla"cellspacing="0" width="100%" >                 
                        <thead >
                            <tr >
                                
                                <th>COD</th>
                                <th>COORDINADOR</th>
                                <th>TITULO</th>
                                <th>DURACION</th>
                                <th>DESCRIPCION</th>
                                <th>TIPO</th>
                                <th>FASES</th>
                                <th>F.INICIO</th>
                                <th>F.FIN</th>
                                <th>GASTOS</th>
                                <th> </th>
                                
                                <th> </th>
                                <th> </th>
                                
                            </tr>
                        </thead>
                        <tbody >
                           <%  for(ProyectoBean obj:lista){     %>
                           <tr >
                            
                            <td><%=obj.getNumero()%></td>
                            <td><%=obj.getNOMBJEFE()%></td>
                            <td><%=obj.getTitulo()%></td>
                            <td><%=obj.getDuracion()%></td>
                            <td><%=obj.getDescripcion()%></td>
                            <td><%=obj.getTipo()%></td>
                            <td><%=obj.getFases()%></td>
                            <td><%=obj.getInicio()%></td>
                            <td><%=obj.getFin()%></td>
                            <td><%=obj.getGastos()%></td>
                            
                            <td align="center"><input  class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/pdf.png" name="elegir" value="<%=obj.getNumero()%>" onclick="cargar('<%=request.getContextPath()%>','Proyecto',10,'cod='+<%= obj.getNumero()%>)"></td>                 
                            <td align="center"><input class="animated infinite pulse"type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getNumero()%>" onclick="cargar('<%=request.getContextPath()%>','Proyecto',5,'cod='+<%= obj.getNumero()%>)"></td>
                            <td align="center"><input class="animated infinite pulse"type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir" value="<%=obj.getNumero()%>" onclick="eliminar('<%=request.getContextPath()%>','Proyecto',7,'cod='+<%=obj.getNumero()%>)"></td>
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