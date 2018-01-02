<%@page import="BEAN.RiesgosBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.SolucionBean"%>
<%!
SolucionBean objCubBean=null;
%>
<%
objCubBean=(SolucionBean)request.getAttribute("DATOS");
%>

<%!
ArrayList<RiesgosBean>lista2=null;

%>
<%
lista2=(ArrayList<RiesgosBean>)request.getAttribute("lista1");
%>
<html>
<head>
</head>
<body>
 <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
    <div class="row titulocontenedor" >
        <div class="col-lg-12 text-center" >
            <h3>MODIFICAR  SOLUCION</h3>
            <hr class="star-primary">
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <form name="form" ><br>
            <div class="row control-group">
                <div class="form-group col-xs-12 floating-label-form-group controls">
                    <label>Codigo</label>
                    <input type="text" class="form-control" placeholder="Codigo" name="txtnum"  value="<%=objCubBean.getNumero()%>"readonly="readonly" >
                    <p class="help-block text-danger"></p>
                </div>
            </div>
            <br>
            <div class="row control-group">
                <div class="form-group col-xs-12 floating-label-form-group controls">
                    <select  name="txtnumriesgo" id="txtnumriesgo" class="form-control">
                      <option value="<%=objCubBean.getNUMRIESGO()%>"><%=objCubBean.getNOMBRIESGO()%></option>
                      <option value="0">-----------------</option>
                      <%for(RiesgosBean obj:lista2){%>
                      <option value="<%=obj.getNumero()%>"><%=obj.getDescripción()%></option>
                      <%}%>
                  </select>
              </div>
          </div>
          <br>
          <div class="row control-group">
            <div class="form-group col-xs-12 floating-label-form-group controls">
               <select name="txtniv" id="txtniv" class="form-control">
                <% if(objCubBean.getNivel().equals("Facil")){ %>
                <option value="Facil" selected>FACIL</option>
                <option value="Intermedio">INTERMEDIO</option>
                <option value="Complejo ">COMPLEJO (DIFICIL)</option>
                <%}else{
                if(objCubBean.getNivel().equals("Intermedio")){%> 
                <option value="Facil">FACIL</option>
                <option value="Intermedio" selected>INTERMEDIO</option>
                <option value="Complejo ">COMPLEJO (DIFICIL)</option>
                <%}else{
                if(objCubBean.getNivel().equals("Complejo")){%> 
                <option value="Facil">FACIL</option>
                <option value="Intermedio">INTERMEDIO</option>
                <option value="Complejo" selected>COMPLEJO (DIFICIL)</option>
                <%}}}%>
            </select>
        </div>
    </div>
    <div class="row control-group">
        <div class="form-group col-xs-12 floating-label-form-group controls">
            <label>Descripcion</label>
            <input type="text" class="form-control"  name="txtdes" placeholder="Descripcion" value="<%=objCubBean.getDescripción()%>" >
            <p class="help-block text-danger"></p>
        </div>
    </div>
    <div id="success"></div>
    <center>
        <div class="row">
            <div class="form-group col-xs-12">
                <input type="button" onclick="modificarSolucion('<%=request.getContextPath()%>')"value="modificar" class="btn btn-success btn-lg">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-xs-12">
                <input type="button"  onclick="salir('<%=request.getContextPath()%>','Solucion',4)"  value="salir" class="btn btn-success btn-lg">
            </div>
        </div> 
    </center>
</form>
</div>
</div>
</div>
</body>
</html>

