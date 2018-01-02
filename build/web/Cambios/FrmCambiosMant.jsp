<%@page  import="java.util.ArrayList" %>
<%@page  import="BEAN.CambiosBean" %>

<%!
ArrayList<CambiosBean> lista=null;
%>
<%
lista=(ArrayList<CambiosBean>)request.getAttribute("lista"); 
%>
<html>
<head>        
    <script>
      paginacion();
  </script>                              
</head>
<body>
    <br>
    <div class=" animated zoomIn">
        <div class="panel ">
            <div class="panel-heading titulocontenedor">
                <h3 ><strong><center>Relacion de Cambios</center></strong></h3>  
                <hr class="star-primary">
            </div>
            <br>
            <input class="btn btn-success btn-lg" type="button" value="Nuevo" onclick="MenuOpciones('<%=request.getContextPath()%>','Cambios',2,'')" >              
            
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
                                    <th>FECHA</th>
                                    <th>PROPOSITO</th>
                                    <th>IMPORTANCIA</th>              
                                    <th> </th>
                                    <th> </th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                               <%  for (CambiosBean obj:lista){     %>
                               <tr >                 
                                <td><%=obj.getNUMERO()%></td>
                                <td><%=obj.getNOMBPROY()%></td>
                                <td><%=obj.getFECHA()%></td>
                                <td><%=obj.getPROPOSITO()%></td>
                                <td><%=obj.getIMPORTANCIA()%></td>
                                <td align="center"><input class="animated infinite pulse"type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getNUMERO()%>" onclick="cargar('<%=request.getContextPath()%>','Cambios',5,'cod='+<%= obj.getNUMERO()%>)"></td>
                                <td align="center"><input class="animated infinite pulse"type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir" value="<%=obj.getNUMERO()%>" onclick="eliminar('<%=request.getContextPath()%>','Cambios',7,'cod='+<%= obj.getNUMERO()%>)"></td>
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
