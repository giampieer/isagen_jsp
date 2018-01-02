<%@page import="BEAN.RequisitoBean"%>
<%@page  import="java.util.ArrayList" %>
<%@page  import="BEAN.ProyectoBean" %>
<%!
ArrayList<RequisitoBean> lista=null;
%>
<%
lista=(ArrayList<RequisitoBean>)request.getAttribute("lista");
%>
<html>
<head>
  <script>
    paginacion();
  </script>
</head>
<body>
 <div class="animated zoomIn"  >
  <div class="panel ">
    <div class="panel-heading titulocontenedor">
      <h3 ><strong><center>Relacion de los Requisitos</center></strong></h3>  
      <hr class="star-primary">
    </div>
    <br>
    <div class="btntabla">
      <input class="btn btn-success btn-lg" type="button" value="Nuevo" onclick="MenuOpciones('<%=request.getContextPath()%>','Requisito',2,'')" >              
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
                  <th>NUMERO</th>
                  <th>PROYECTO ELEGIDO</th>
                  <th>ALCANCE</th>
                  <th>PERSONAL</th>
                  <th>REUNION</th>
                  <th>DESCRIPCION</th>
                  <th> </th>
                  <th> </th>          
                </tr>
              </thead>
              <tbody >
                <%  for(RequisitoBean obj:lista){    %>
                <tr  >                   
                  <td><%=obj.getNumero()%></td>
                  <td><%=obj.getNOMBPROY()%></td>
                  <td><%=obj.getAlcance()%></td>
                  <td><%=obj.getPersonal()%></td>
                  <td><%=obj.getReunion()%></td>
                  <td><%=obj.getDescripcion()%></td>
                  
                  <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getNumero()%>" onclick="cargar('<%=request.getContextPath()%>','Requisito',5,'cod='+<%= obj.getNumero()%>)"></td>
                  <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir" value="<%=obj.getNumero()%>" onclick="eliminar('<%=request.getContextPath()%>','Requisito',7,'cod='+<%= obj.getNumero()%>)"></td>
                  <%}%>
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
