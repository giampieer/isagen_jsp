
<%@page import="BEAN.PersonalBean"%>
<%!PersonalBean obj1=null;%>
<% obj1=(PersonalBean)request.getAttribute("infoproy");%>
<html>
<head>
</head>
<body onload="enfocar()" >
 <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
  <div class="row titulocontenedor" >
    <div class="col-lg-12 text-center" >
      <h3>INFORMACION</h3>
      <hr class="star-primary">
    </div>
  </div>
  <div class="row">
    <div class="col-lg-8 col-lg-offset-2">
      <form name="form" ><br>
        <div class="row control-group">
          <div class="form-group col-xs-12 floating-label-form-group controls">
           <h4>PROYECTO</h4>
           <h6>ADMINISTRADOR  : <%=obj1.getNOMBJEFE()%></h6> 
           <h6>TITULO  :<%=obj1.getTitulo()%></h6> 
           <h6>DURACION  :<%=obj1.getDuracion()%></h6> 
           <h6>DESCRIPCION  :<%=obj1.getDescripcion()%></h6> 
           <h6>TIPO  :<%=obj1.getTipo()%></h6> 
           <h6> FASES  :<%=obj1.getFases()%></h6> 
           <h6>INICIO  :<%=obj1.getInicio()%></h6> 
           <h6>CONCLUSION  :<%=obj1.getFin()%></h6> 
           <h6>GASTOS  :<%=obj1.getGastos()%></h6> 
           <p class="help-block text-danger"></p>
         </div>
       </div>
       <br>
       
       <div class="row control-group">
        <div class="form-group col-xs-12 floating-label-form-group controls">
         <h4>REQUISITOS</h4>
         <h6>NUMERO  :<%=obj1.getNumeror()%></h6> 
         <h6>ALCANCE  :<%=obj1.getAlcance()%></h6>  
         <h6>CANTIDAD DEL PERSONAL  :<%=obj1.getPersonal()%></h6> 
         <h6>CANTIDAD DE REUNIONES  :<%=obj1.getReunion()%></h6> 
         <h6>DESCRIPCION  :<%=obj1.getDescripcion()%></h6> 
         <p class="help-block text-danger"></p>
       </div>
     </div>
     <div class="row control-group">
      <div class="form-group col-xs-12 floating-label-form-group controls">
        <h4>PROBLEMA GENERAL</h4>
        <h6>NUMERO  :<%=obj1.getNumeropro()%></h6> 
        <h6>NIVEL DE GRAVEDAD  :<%=obj1.getNivel()%></h6> 
        <h6>DESCRIPCION  :<%=obj1.getDescripcionpro()%></h6> 
        <h6>PERJUDICADOS  :<%=obj1.getPerjudicado()%></h6> 
        <p class="help-block text-danger"></p>
      </div>
    </div>

    <div class="row control-group">
      <div class="form-group col-xs-12 floating-label-form-group controls">
       <h4>OBJETIVO GENERAL</h4>
       <h6>NUMERO  :<%=obj1.getNumeroobj()%></h6> 
       <h6>NIVEL  :<%=obj1.getNivelobj()%></h6> 
       <h6>DESCRIPCION GENERAL  :<%=obj1.getDescripcionobj()%></h6> 
       <h6>FINALIDAD GENERAL  :<%=obj1.getFinalidad()%></h6> 
       <p class="help-block text-danger"></p>
     </div>
   </div>
 </form>
</div>
</div>
</div>
</body>
</html>
