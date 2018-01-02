<%@page  import="java.util.ArrayList" %>
<%@page  import="BEAN.PersonalBean" %>

<%!
ArrayList<PersonalBean> lista=null;
%>
<%
lista=(ArrayList<PersonalBean>)request.getAttribute("lista"); 
%>
<html>
<head>        
    <script>
      paginacion();
  </script>                              
</head>
<body> <br>
   <div class="container animated zoomIn" >
    <div class="panel ">
      <div class="panel titulocontenedor" >
        <h3><strong><center>RELACION DEL PERSONAL</center></strong></h3>                            
        <hr class="star-primary">
    </div>
    <input class="btn btn-success btn-lg"  type="button" value="Nuevo" onclick="MenuOpciones('<%=request.getContextPath()%>','Personal',2,'')" >              
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
                            <th>PROYECTO</th>
                            <th>NOMBRE</th>
                            <th>CORREO</th>
                            <th>TELEFONO</th>
                            <th>H. LABORALES</th>
                            <th>D. LABORALES</th>
                            <th>ID</th>
                            <th>PASS</th>
                            <th> </th>
                            <th> </th>
                            
                            
                        </tr>
                    </thead>
                    <tbody>
                       <%  for(PersonalBean obj:lista){     %>
                       <tr >
                        
                        <td align="center"><%=obj.getCODPERSONAL()%></td>
                        <td align="center"><%=obj.getNOMBPROY()%></td>
                        <td align="center"><%=obj.getNOMBPERSONAL()%></td>
                        <td align="center"><%=obj.getEMAPERSONAL()%></td>
                        <td align="center"><%=obj.getTELFPERSONAL()%></td>
                        <td align="center"><%=obj.getHORAS()%></td>
                        <td align="center"><%=obj.getDIAS()%></td>
                        <td align="center"><%=obj.getID()%></td>
                        <td align="center"><%=obj.getPASS()%></td>
                        
                        
                        <td align="center"><input class="animated infinite pulse"type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getCODPERSONAL()%>" onclick="cargar('<%=request.getContextPath()%>','Personal',5,'cod='+<%= obj.getCODPERSONAL()%>)"></td>
                        <td align="center"><input class="animated infinite pulse"type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir" value="<%=obj.getCODPERSONAL()%>" onclick="eliminar('<%=request.getContextPath()%>','Personal',7,'cod='+<%= obj.getCODPERSONAL()%>)"></td>
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
