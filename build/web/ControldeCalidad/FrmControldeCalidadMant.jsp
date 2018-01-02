<%@page import="BEAN.ControldeCalidadBean"%>
<%@page  import="java.util.ArrayList" %>
<%@page  import="BEAN.RiesgosBean" %>

<%!
ArrayList<ControldeCalidadBean> lista=null;
%>
<%
lista=(ArrayList<ControldeCalidadBean>)request.getAttribute("lista");
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
        <h3 ><strong><center>Relacion de Control de Calidad</center></strong></h3>  
        <hr class="star-primary">
    </div>
    <br>
    <input class="btn btn-success btn-lg"  type="button" value="Nuevo" onclick="MenuOpciones('<%=request.getContextPath()%>','ControldeCalidad',2,'')" >              
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
                            <th>P. GESTION</th>
                            <th>P. MEJORA</th>
                            <th>METRICAS DE CALIDAD</th>
                            <th>ACTUALIZACIONES</th>                                
                            <th> </th>
                            <th> </th>
                            
                        </tr>
                    </thead>
                    <tbody>
                       <%  for(ControldeCalidadBean obj:lista){     %>
                       <tr >                   
                        <td><%=obj.getNumero()%></td>
                        <td><%=obj.getNOMBPROY()%></td>
                        <td><%=obj.getPlandegestion()%></td>
                        <td><%=obj.getPlandemejoradecalidad()%></td>
                        <td><%=obj.getMetricasdecalidad()%></td>
                        <td><%=obj.getActualizacionesdeladocumentacion()%></td>           
                        <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getNumero()%>" onclick="cargar('<%=request.getContextPath()%>','ControldeCalidad',5,'cod='+<%= obj.getNumero()%>)"></td>
                        <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir" value="<%=obj.getNumero()%>" onclick="eliminar('<%=request.getContextPath()%>','ControldeCalidad',7,'cod='+<%= obj.getNumero()%>)"></td>
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
