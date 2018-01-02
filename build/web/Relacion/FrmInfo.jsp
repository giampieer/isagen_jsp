<%@page import="BEAN.ProyectoBean"%>
<%!
ProyectoBean objCubBean=null;
%>
<%
objCubBean=(ProyectoBean)request.getAttribute("DATOS");
%>
<!DOCTYPE html>
<html  lang="en">
<head>
</head>
<body >
  <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: #006699;border-radius: 7px">
    <div class="row titulocontenedor" >
      <div class="col-lg-12 text-center" >
        <h3>PDF PROYECTO</h3>
        <hr class="star-primary">
      </div>
    </div>
    <div class="row">
      <div class="col-lg-8 col-lg-offset-2">
        <form name="form"  action="ReporteServlet">	
          <div class="row control-group"> 
            <div><center>PROYECTO<br> 
              <input type="image"    width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_nuevo.png"   name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
              <br>       
            </center></div></div>
          </form>
          
          <form name="form"  action="ReporteRequsitoServlet">	
           <div class="row control-group" > 
            <div><center>REQUISITO<br> 
              <input type="image"  width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_requisito.png"  name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
              <br>        
            </center></div></div>
          </form><br> 
          
          
          
          <form name="form"   action="ReporteProblemaServlet">
           <div class="row control-group">
            <div><center>PROBLEMA<br> 
              <input type="image"  width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_problema.png"    name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
              <br>      
            </center></div>
          </div>
        </form>              
        <form name="form" action="ReporteObjetivoServlet">
          <div class="row control-group" >
           <div><center>OBJETIVO<br> 
            <input type="image" width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_objetivo.png"    name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
            <br>         
          </center></div></div>
        </form>
      </div>
    </div></div>
    
    
    <br>
    
    <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: #006699;border-radius: 7px">
      <div class="row titulocontenedor" >
        <div class="col-lg-12 text-center" >
          <h3>PDF SEGUIMIENTO</h3>
          <hr class="star-primary">
        </div>
      </div>
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          
          <form name="form"  action="ReporteReunionesServlet">	
            <div class="row control-group"> 
              <div><center>REUNIONES<br> 
                <input type="image"    width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_reunion.png"   name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
                <br>       
              </center></div></div>
            </form>
            
            
            
            <form name="form"  action="ReporteCambiosServlet">	
             <div class="row control-group" > 
              <div><center>CAMBIOS<br> 
                <input type="image"  width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_cambios.png"  name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
                <br>        
              </center></div></div>
            </form><br> 
            
            
            
            <form name="form"   action="ReporteInteresServlet">
             <div class="row control-group">
              <div><center>INTERESADOS<br> 
                <input type="image"  width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_interesados.png"    name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
                <br>      
              </center></div>
              
            </div>
          </form>              
          <form name="form" action="ReporteRiesgoServlet">
            <div class="row control-group" >
             <div><center>RIESGOS<br> 
              <input type="image" width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_riesgos.png"    name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
              <br>         
            </center></div></div>
          </form>
        </div>
      </div></div>
      
      <br>
      <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: #006699;border-radius: 7px">
        <div class="row titulocontenedor" >
          <div class="col-lg-12 text-center" >
            <h3>PDF PERSONAL</h3>
            <hr class="star-primary">
          </div>
        </div>
        <div class="row">
          <div class="col-lg-8 col-lg-offset-2">
           <form name="form"  action="ReporteJefeServlet">	
            <div class="row control-group"> 
              <div><center>ADMINISTRADOR<br> 
                <input type="image"    width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_admin.png""   name="txtproy" value="<%=objCubBean.getCODJEFE()%>"   formtarget="_blank" class="enviarfor">
                <br>       
              </center></div></div>
            </form>
            
            
            
            <form name="form"  action="ReportePersonalServlet">	
             <div class="row control-group" > 
              <div><center>PERSONAL<br> 
                <input type="image"  width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_personal.png"  name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
                <br>        
              </center></div></div>
            </form><br> 
            
          </div>
        </div></div>
        <br>
        <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: #006699;border-radius: 7px">
          <div class="row titulocontenedor" >
            <div class="col-lg-12 text-center" >
              <h3>PDF CRONOGRAMA</h3>
              <hr class="star-primary">
            </div>
          </div>
          <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
              <form name="form"  action="ReporteActividadServlet">	
                <div class="row control-group"> 
                  <div><center>ACTIVIDADES<br> 
                    <input type="image"    width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_actividades.png""   name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
                    <br>       
                  </center></div></div>
                </form>
                
                <form name="form"  action="ReporteControlServlet">	
                 <div class="row control-group" > 
                  <div><center>CONTROL  DE CALIDAD<br> 
                    <input type="image"  width="100px" height="100px"  src=" <%=request.getContextPath()%>/imagenes/report_control.png"  name="txtproy" value="<%=objCubBean.getNumero()%>"   formtarget="_blank" class="enviarfor">
                    <br>        
                  </center></div></div>
                </form><br> 
                
              </div>
            </div></div>
            <br>
          </body>
          </html>
