
package servlets;

import BEAN.ActividadesBean;
import BEAN.ControldeCalidadBean;
import DAO.ControldeCalidadDAO;
import DAO.ProyectoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControldeCalidadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
             response.setContentType("application/json");
         StringBuilder json=null;
        
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        int  num;
        String numero,plandegestion,plandemejoradecalidad,metricasdecalidad,actualizacionesdeladocumentacion,numproy;
        String pagina = "";
        ControldeCalidadDAO objProyDAO = null;
        ArrayList lista = null;
        ControldeCalidadBean  objProyBean = null;
        ProyectoDAO objDAO=null;
        switch(op)
        {
            case 1://Listar
            {
                objProyDAO = new ControldeCalidadDAO();
                lista=objProyDAO.cargartablacontrolcalidad1();
                request.setAttribute("lista", lista);
                pagina = "/ControldeCalidad/FrmControldeCalidadMant.jsp";
            }break;
            case 2://Pagina grabar
            {
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/ControldeCalidad/FrmNuevoControldeCalidad.jsp";
            }break;
            case 3://Nuevo
            {
                objProyDAO = new ControldeCalidadDAO();
                      
                    numero = request.getParameter("txtcod");
                    num=Integer.parseInt(numero);
                    plandegestion = request.getParameter("txtplge");
                    plandemejoradecalidad = request.getParameter("txtplca");
                    metricasdecalidad = request.getParameter("txtmeca");
                    actualizacionesdeladocumentacion = request.getParameter("txtacdo");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
               objProyBean = new ControldeCalidadBean();
               objProyBean.setNumero(num);
               objProyBean.setPlandegestion(plandegestion);
               objProyBean.setPlandemejoradecalidad(plandemejoradecalidad);
               objProyBean.setMetricasdecalidad(metricasdecalidad);
               objProyBean.setNUMPROY(proy);
               objProyBean.setActualizacionesdeladocumentacion(actualizacionesdeladocumentacion);
               int i = objProyDAO.grabarcontrolcalidad(objProyBean);
                     if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    
                    objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                    pagina = "/ControldeCalidad/FrmNuevoControldeCalidad.jsp";
            }break;
            case 4://Salir
            {
                objProyDAO = new ControldeCalidadDAO();
                lista = objProyDAO.cargartablacontrolcalidad1();
                request.setAttribute("lista", lista);
                pagina = "/ControldeCalidad/FrmControldeCalidadMant.jsp";
            }break;
            case 5://Capturar Numero
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ControldeCalidadDAO();
                objProyBean = new ControldeCalidadBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarControlCalidad(objProyBean);
                request.setAttribute("DATOS",  objProyBean);
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/ControldeCalidad/FrmModificarControldeCalidad.jsp";
            }break;

            case 6://Modificar nuevos datos
            {
                numero = request.getParameter("txtcod");
                num=Integer.parseInt(numero);
                plandegestion = request.getParameter("txtplge");
                plandemejoradecalidad = request.getParameter("txtplca");
                metricasdecalidad = request.getParameter("txtmeca");
                actualizacionesdeladocumentacion = request.getParameter("txtacdo");   
                 numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
                    
               objProyBean = new ControldeCalidadBean();
               objProyDAO=new ControldeCalidadDAO();
               objProyBean.setNumero(num);
               objProyBean.setPlandegestion(plandegestion);
               objProyBean.setPlandemejoradecalidad(plandemejoradecalidad);
               objProyBean.setMetricasdecalidad(metricasdecalidad);
               objProyBean.setNUMPROY(proy);
               objProyBean.setActualizacionesdeladocumentacion(actualizacionesdeladocumentacion);
               
               int i= objProyDAO.modificarcontrolcalidad(objProyBean);
                lista=objProyDAO.cargartablacontrolcalidad1();
                if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                request.setAttribute("lista", lista);
                pagina = "/ControldeCalidad/FrmControldeCalidadMant.jsp";
            }break;
            case 7://Eliminar
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ControldeCalidadDAO();
                objProyBean = new ControldeCalidadBean();
                objProyBean.setNumero(numero1[0]);
                int  i= objProyDAO.eliminarcontrolcalidad(objProyBean);
                
                lista = objProyDAO.cargartablacontrolcalidad1();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                pagina = "/ControldeCalidad/FrmControldeCalidadMant.jsp";
            }break;
            
            
            
            
            //PERSONAL
            case 8://mostrar tabla
            {
             numproy=request.getParameter("cod");
             int proy=Integer.parseInt(numproy);
                objProyBean=new ControldeCalidadBean();
                objProyDAO=new ControldeCalidadDAO();
               //mostrar tabla personal 
                objProyBean.setNUMPROY(proy);
                lista=objProyDAO.cargartablacontrolcalidadPersonal(objProyBean);
               //capturar numero pryecto
               request.setAttribute("numproy", objProyBean);
                request.setAttribute("lista",  lista);
                pagina = "/ControldeCalidad/FrmControldeCalidadMantPersonal.jsp";
              }break;
              
              
              //redireccionar a grabar 
            case 9:{
                numproy=request.getParameter("cod");
                 int proy=Integer.parseInt(numproy);
                objProyBean=new ControldeCalidadBean();
                objProyBean.setNUMPROY(proy);
                request.setAttribute("numproy", objProyBean);
                 pagina = "/ControldeCalidad/FrmNuevoControldeCalidadPersonal.jsp";
            }break;
            
            //grabar  personal
            case 10:{
                    objProyDAO = new ControldeCalidadDAO();
                      
                    numero = request.getParameter("txtcod");
                    num=Integer.parseInt(numero);
                    plandegestion = request.getParameter("txtplge");
                    plandemejoradecalidad = request.getParameter("txtplca");
                    metricasdecalidad = request.getParameter("txtmeca");
                    actualizacionesdeladocumentacion = request.getParameter("txtacdo");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
            
                    
               objProyBean = new ControldeCalidadBean();
               objProyBean.setNumero(num);
               objProyBean.setPlandegestion(plandegestion);
               objProyBean.setPlandemejoradecalidad(plandemejoradecalidad);
               objProyBean.setMetricasdecalidad(metricasdecalidad);
               objProyBean.setNUMPROY(proy);
                objProyBean.setActualizacionesdeladocumentacion(actualizacionesdeladocumentacion);
                    int i = objProyDAO.grabarcontrolcalidad(objProyBean);
                     if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    //cargar el numero del proyecto 
                    ControldeCalidadBean objproy=null;
                    objproy=new ControldeCalidadBean();
                    objproy.setNUMPROY(proy);
                    
                   request.setAttribute("numproy", objproy);
                    pagina = "/ControldeCalidad/FrmNuevoControldeCalidadPersonal.jsp";
            }break;
            
            //modificar
            case 11:{
              numero = request.getParameter("txtcod");
                num=Integer.parseInt(numero);
                plandegestion = request.getParameter("txtplge");
                plandemejoradecalidad = request.getParameter("txtplca");
                metricasdecalidad = request.getParameter("txtmeca");
                actualizacionesdeladocumentacion = request.getParameter("txtacdo");   
                 numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
                    
               objProyBean = new ControldeCalidadBean();
               objProyDAO=new ControldeCalidadDAO();
               objProyBean.setNumero(num);
               objProyBean.setPlandegestion(plandegestion);
               objProyBean.setPlandemejoradecalidad(plandemejoradecalidad);
               objProyBean.setMetricasdecalidad(metricasdecalidad);
               objProyBean.setNUMPROY(proy);
               objProyBean.setActualizacionesdeladocumentacion(actualizacionesdeladocumentacion);
                int i=objProyDAO.modificarcontrolcalidad(objProyBean);
                
                //cargar proyecto
                ControldeCalidadBean objnumproy=null;
                objnumproy=new ControldeCalidadBean();
                objnumproy.setNUMPROY(proy);
                lista = objProyDAO.cargartablacontrolcalidadPersonal(objnumproy);
                
                
                request.setAttribute("lista", lista);
               if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                 request.setAttribute("numproy", objnumproy);
                pagina = "/ControldeCalidad/FrmControldeCalidadMantPersonal.jsp";
            }break;
            
            //capturar numero y redireccionar a modificar
            case 12 :{
                 String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numeros[]=new  int[numeroCad.length];
                for(int i=0;i<numeros.length;i++)
                {
                    numeros[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objProyDAO = new ControldeCalidadDAO();
                objProyBean = new ControldeCalidadBean();
                objProyBean.setNumero(numeros[0]);
                objProyBean=objProyDAO.CapturarControlCalidad(objProyBean);
                request.setAttribute("DATOS",  objProyBean);
                
               
                pagina = "/ControldeCalidad/FrmModificarControldeCalidadPersonal.jsp";
                
                
            }break;
            
            case 13:{
                
                String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numeros[]=new  int[numeroCad.length];
                for(int i=0;i<numeros.length;i++)
                {
                    numeros[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objProyDAO = new ControldeCalidadDAO();
                objProyBean = new ControldeCalidadBean();
                ControldeCalidadBean obj=new ControldeCalidadBean();
                
                objProyBean.setNumero(numeros[0]);
             
                int  i= objProyDAO.eliminarcontrolcalidad(objProyBean);
                 int codproyecto=Integer.parseInt(request.getParameter("codproy"));
                obj.setNUMPROY(codproyecto);
                
               lista=objProyDAO.cargartablacontrolcalidadPersonal(objProyBean);
          
                request.setAttribute("lista",  lista);
               
                request.setAttribute("numproy", obj);
                  request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
            
                 pagina = "/ControldeCalidad/FrmControldeCalidadMantPersonal.jsp";
            }break;
            case 14:{
                
                
                 objProyDAO=new ControldeCalidadDAO();
      lista=objProyDAO.cargartablacontrolcalidad1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"controldecalidad\":[");
          for(int i=0;i<lista.size();i++)
          {
           ControldeCalidadBean  obj=(ControldeCalidadBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"numero\":\""+obj.getNumero()+"\",\"plandegestion\":\""+obj.getPlandegestion()+"\",\"plandemejoradecalidad\":\""+obj.getPlandemejoradecalidad()+"\",\"metricasdecalidad\":\""+obj.getMetricasdecalidad()+"\",\"actualizacionesdeladocumentacion\":\""+obj.getActualizacionesdeladocumentacion()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"}");   
               }
               else
               {
               json.append("{\"numero\":\""+obj.getNumero()+"\",\"plandegestion\":\""+obj.getPlandegestion()+"\",\"plandemejoradecalidad\":\""+obj.getPlandemejoradecalidad()+"\",\"metricasdecalidad\":\""+obj.getMetricasdecalidad()+"\",\"actualizacionesdeladocumentacion\":\""+obj.getActualizacionesdeladocumentacion()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
                
                
            }break;
            
            
                        //mostrar
              case 15:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objProyDAO=new ControldeCalidadDAO();
                  
               lista=objProyDAO.cargartablacontrolcalidad1();
            out.println("{\"controldecalidad\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 16:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();
 objProyDAO = new ControldeCalidadDAO();
                      
                    numero = request.getParameter("txtcod");
                    num=Integer.parseInt(numero);
                    plandegestion = request.getParameter("txtplge");
                    plandemejoradecalidad = request.getParameter("txtplca");
                    metricasdecalidad = request.getParameter("txtmeca");
                    actualizacionesdeladocumentacion = request.getParameter("txtacdo");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
               objProyBean = new ControldeCalidadBean();
               objProyBean.setNumero(num);
               objProyBean.setPlandegestion(plandegestion);
               objProyBean.setPlandemejoradecalidad(plandemejoradecalidad);
               objProyBean.setMetricasdecalidad(metricasdecalidad);
               objProyBean.setNUMPROY(proy);
               objProyBean.setActualizacionesdeladocumentacion(actualizacionesdeladocumentacion);
               int i = objProyDAO.grabarcontrolcalidad(objProyBean);
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se ingreso}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se ingreso}"));

                          }
                  out.print(json.toString());
                  //http://localhost:8084/ProyectoGestion/ProyectoServlet?op=11&txtnum=5&txttit=sadsa&txtdur=adsa&txtdes=ssds&txttip=asa&txtcan=sdsd&txtini=saas&txtfin=asas&txtpre=sds&txtcodjefe=4
              }break;
              
              //modificar
       case 17:{
           PrintWriter out = response.getWriter();
         json=new StringBuilder();   
                numero = request.getParameter("txtcod");
                num=Integer.parseInt(numero);
                plandegestion = request.getParameter("txtplge");
                plandemejoradecalidad = request.getParameter("txtplca");
                metricasdecalidad = request.getParameter("txtmeca");
                actualizacionesdeladocumentacion = request.getParameter("txtacdo");   
                 numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
                    
               objProyBean = new ControldeCalidadBean();
               objProyDAO=new ControldeCalidadDAO();
               objProyBean.setNumero(num);
               objProyBean.setPlandegestion(plandegestion);
               objProyBean.setPlandemejoradecalidad(plandemejoradecalidad);
               objProyBean.setMetricasdecalidad(metricasdecalidad);
               objProyBean.setNUMPROY(proy);
               objProyBean.setActualizacionesdeladocumentacion(actualizacionesdeladocumentacion);
               
               int i= objProyDAO.modificarcontrolcalidad(objProyBean);
//cargar combobox con datos del proyecto
  Gson gson= new Gson();
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se modifico}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se modifico}"));

                  }
                  out.print(json.toString());
       }break;
       case 18:{
               String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ControldeCalidadDAO();
                objProyBean = new ControldeCalidadBean();
                objProyBean.setNumero(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objProyDAO.eliminarcontrolcalidad(objProyBean);
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se elimino}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se elimino}"));

                          }
               out.print(json.toString());
       }break;
            
             
    }
        getServletContext().getRequestDispatcher(pagina).forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
