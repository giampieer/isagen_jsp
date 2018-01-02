<%@page import="BEAN.ProyectoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.ReunionesBean"%>;
<%!
ReunionesBean objReunionesBean=null;
%>
<%
objReunionesBean=(ReunionesBean)request.getAttribute("DATOS");
%>

<%!
ArrayList<ProyectoBean>lista=null;

%>
<%
lista=(ArrayList<ProyectoBean>)request.getAttribute("lista1");
%>

<html>
<head>
    <script>
                         //calendario
                         $('#txtfec').bootstrapMaterialDatePicker({ weekStart : 0, time: false });
                         $('#txtreu').bootstrapMaterialDatePicker({ weekStart : 0, time: false });
                         
                     </script>
                 </head>
                 <body>
                   
                  <div class="container animated zoomIn" style="max-width: 500px;width: 100%;background-color: white;border-radius: 7px">
                    <div class="row titulocontenedor" >
                        <div class="col-lg-12 text-center" >
                            <h3>MODIFICAR   REUNION</h3>
                            <hr class="star-primary">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-lg-offset-2">
                         <form name="form" ><br>
                            <div class="row control-group">
                              <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Codigo</label>
                                <input type="text" class="form-control" placeholder="Codigo" name="txtnum" value="<%=objReunionesBean.getNUMERO()%>" readonly="readonly" >
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Personal Asistente</label>
                                <input type="text" class="form-control" name="txtper" placeholder="Personal Asistente" value="<%=objReunionesBean.getPERSONAL()%>">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <br>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                             <select  name="txtnumproy" id="txtnumproy" class="form-control">
                                <option value="<%=objReunionesBean.getNUMPROY()%>"><%=objReunionesBean.getNOMBPROY()%></option>
                                <option value="0">-----------------</option>
                                <%for(ProyectoBean obj:lista){%>
                                <option value="<%=obj.getNumero()%>"><%=obj.getTitulo()%></option>
                                <%}%>
                            </select>   
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Fecha</label>
                            <input type="text" class="form-control"  name="txtfec" id="txtfec"placeholder="Fecha " value="<%=objReunionesBean.getFECHA()%>" >
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Acuerdos</label>
                            <input type="text"  class="form-control " name="txtacu" placeholder="Acuerdos" value="<%=objReunionesBean.getACUERDOS()%>" >
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Fecha Proxima</label>
                            <input type="text"  class="form-control " name="txtreu"  id="txtreu"placeholder="Fecha Proxima"  value="<%=objReunionesBean.getREUNION()%>">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Duracion</label>
                            <input type="text"  class="form-control " name="txtdur" placeholder="Duracion" value="<%=objReunionesBean.getDURACION()%>" >
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <br>
                    <div id="success"></div>
                    <center>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <input type="button"onclick="modificarReunion('<%=request.getContextPath()%>')" value="modificar" class="btn btn-success btn-lg">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <input type="button"  onclick="salir('<%=request.getContextPath()%>','Reuniones',4)"value="salir" class="btn btn-success btn-lg">
                            </div>
                        </div> 
                    </center>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

