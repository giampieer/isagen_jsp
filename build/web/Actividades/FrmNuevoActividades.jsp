<%@page import="DAO.ActividadesDAO"%>
<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%!
ArrayList<ProyectoBean>lista=null;

%>
<%
lista=(ArrayList<ProyectoBean>)request.getAttribute("lista1");
%>
<%!   
ActividadesDAO obj=new ActividadesDAO();

%>
<html>
<head>
 <script>    
    
    function enfocar(){
        document.form.txtNum.focus();
    }
    
</script>
</head>
<body onload="enfocar()">
    <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
        <div class="row titulocontenedor" >
            <div class="col-lg-12 text-center" >
                <h3>REGISTRAR  ACTIVIDAD</h3>
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


        
        <br>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <select name="txtnumproy" id="txtnumproy" class="form-control">
                    <option value="0">------ Seleccionar Proyecto ------</option>
                    <%for(ProyectoBean obj:lista){%>
                    <option value="<%=obj.getNumero()%>"><%=obj.getTitulo()%></option>
                    <%}%>
                </select> 
            </div>
        </div>
        <br>

        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Actividad</label>
                <input type="text" class="form-control"  name="txtact" placeholder="Actividad"  >
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Duracion</label>
                <input type="text" class="form-control"  name="txtdur" placeholder="Duracion" >
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
                <label>Responsable</label>
                <input type="text" class="form-control"  name="txtres" placeholder="Responsable" >
                <p class="help-block text-danger"></p>
            </div>
        </div>
        <div id="success"></div>
        <center>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button"onclick="grabarActividad('<%=request.getContextPath()%>')"value="grabar" class="btn btn-success btn-lg">
                </div>
                
            </div>
            <div class="row">
                <div class="form-group col-xs-12">
                    <input type="button"  onclick="salir('<%=request.getContextPath()%>','Actividades',4)"  value="salir" class="btn btn-success btn-lg">
                </div>
            </div> 
        </center>
    </form>
</div>
</div>
</div>
</body>
</html>

