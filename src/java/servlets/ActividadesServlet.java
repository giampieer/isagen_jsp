
package servlets;

import BEAN.ActividadesBean;
import DAO.ActividadesDAO;
import DAO.ProyectoDAO;
import DAO.SolucionDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActividadesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
             response.setContentType("application/json");
         StringBuilder json=null;
        
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        int  numero;
        String actividad,duracion,responsable,numproy;
        String pagina = "";
        ActividadesDAO objProyDAO = null;
        ArrayList lista = null;
        ActividadesBean objProyBean = null;
        ProyectoDAO objDAO=null;
        switch(op)
        {
            case 1://Listar
            {
                objProyDAO = new ActividadesDAO();
                lista=objProyDAO.cargartablaactividades1();
                request.setAttribute("lista", lista);
                pagina = "/Actividades/FrmActividadesMant.jsp";
            }break;
            case 2://Pagina grabar
            {
                //cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/Actividades/FrmNuevoActividades.jsp";
            }break;
            case 3://Nuevo
            {
                objProyDAO = new ActividadesDAO();
                      
                    numero = Integer.parseInt(request.getParameter("txtnum"));
                    actividad = request.getParameter("txtact");
                    duracion = request.getParameter("txtdur");
                    responsable = request.getParameter("txtres");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
               objProyBean = new ActividadesBean();
               objProyBean.setNumero(numero);
               objProyBean.setActividad(actividad);
               objProyBean.setDuracion(duracion);
               objProyBean.setResponsable(responsable);
               objProyBean.setNUMPROY(proy);
               int i = objProyDAO.grabaractividades(objProyBean);
                 if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }                    
                     //cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                    pagina = "/Actividades/FrmNuevoActividades.jsp";
            }break;
            case 4://Salir
            {
                objProyDAO = new ActividadesDAO();
                lista = objProyDAO.cargartablaactividades1();
                request.setAttribute("lista", lista);
                pagina = "/Actividades/FrmActividadesMant.jsp";
            }break;
            case 5://Capturar Numero
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ActividadesDAO();
                objProyBean = new ActividadesBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarActividades(objProyBean);
                request.setAttribute("DATOS",  objProyBean);
                 //cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/Actividades/FrmModificarActividades.jsp";
            }break;
                   
            case 6://Modificar nuevos datos
            {
               numero = Integer.parseInt(request.getParameter("txtnum"));
                    actividad = request.getParameter("txtact");
                    duracion = request.getParameter("txtdur");
                    responsable = request.getParameter("txtres");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
               objProyBean = new ActividadesBean();
               objProyBean.setNumero(numero);
               objProyBean.setActividad(actividad);
               objProyBean.setDuracion(duracion);
               objProyBean.setResponsable(responsable);
               objProyBean.setNUMPROY(proy);
               
               objProyDAO=new ActividadesDAO();
                int i=objProyDAO.modificaractividades(objProyBean);
                lista=objProyDAO.cargartablaactividades1();
                request.setAttribute("lista", lista);
                if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                pagina = "/Actividades/FrmActividadesMant.jsp";
            }break;
            case 7://Eliminar
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ActividadesDAO();
                objProyBean = new ActividadesBean();
                objProyBean.setNumero(numero1[0]);
                int  i= objProyDAO.eliminaractividades(objProyBean);
                
                lista = objProyDAO.cargartablaactividades1();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                pagina = "/Actividades/FrmActividadesMant.jsp";
            }break;
            
             //PERSONAL
            case 8://mostrar tabla
            {
             numproy=request.getParameter("cod");
             int proy=Integer.parseInt(numproy);
                ActividadesBean objact=new ActividadesBean();
                objact=new ActividadesBean();
                objProyDAO=new ActividadesDAO();
               //mostrar tabla personal 
                objact.setNUMPROY(proy);
                lista=objProyDAO.cargartablaactividadesPersonal(objact);
               //capturar numero pryecto
               request.setAttribute("numproy", objact);
                request.setAttribute("lista",  lista);
                pagina = "/Actividades/FrmActividadesMantPersonal.jsp";
              }break;
              
              
              //redireccionar a grabar 
            case 9:{
                numproy=request.getParameter("cod");
                 int proy=Integer.parseInt(numproy);
                objProyBean=new ActividadesBean();
                objProyBean.setNUMPROY(proy);
                request.setAttribute("numproy", objProyBean);
                 pagina = "/Actividades/FrmNuevoActividadesPersonal.jsp";
            }break;
            
            //grabar  personal
            case 10:{
                    objProyDAO = new ActividadesDAO();
                    numero = Integer.parseInt(request.getParameter("txtnum"));
                    actividad = request.getParameter("txtact");
                    duracion = request.getParameter("txtdur");
                    responsable = request.getParameter("txtres");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
               objProyBean = new ActividadesBean();
               objProyBean.setNumero(numero);
               objProyBean.setActividad(actividad);
               objProyBean.setDuracion(duracion);
               objProyBean.setResponsable(responsable);
               objProyBean.setNUMPROY(proy);
                    int i = objProyDAO.grabaractividades(objProyBean);
                      if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }   
                    //cargar el numero del proyecto 
                    ActividadesBean objproy=null;
                    objproy=new ActividadesBean();
                    objproy.setNUMPROY(proy);
                         
                   request.setAttribute("numproy", objproy);
                    pagina = "/Actividades/FrmNuevoActividadesPersonal.jsp";
            }break;
            
            //modificar
            case 11:{
               objProyDAO = new ActividadesDAO();
                    numero = Integer.parseInt(request.getParameter("txtnum"));
                    actividad = request.getParameter("txtact");
                    duracion = request.getParameter("txtdur");
                    responsable = request.getParameter("txtres");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
               objProyBean = new ActividadesBean();
               objProyBean.setNumero(numero);
               objProyBean.setActividad(actividad);
               objProyBean.setDuracion(duracion);
               objProyBean.setResponsable(responsable);
               objProyBean.setNUMPROY(proy);
                int i=objProyDAO.modificaractividades(objProyBean);    
                  if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                //cargar proyecto
                ActividadesBean objnumproy=null;
                objnumproy=new ActividadesBean();
                objnumproy.setNUMPROY(proy);
                lista = objProyDAO.cargartablaactividadesPersonal(objnumproy);
                
                
                request.setAttribute("lista", lista);
            
                 request.setAttribute("numproy", objnumproy);
                pagina = "/Actividades/FrmActividadesMantPersonal.jsp";
            }break;
            
            //capturar numero y redireccionar a modificar
            case 12 :{
                 String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  num[]=new  int[numeroCad.length];
                for(int i=0;i<num.length;i++)
                {
                    num[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objProyDAO = new ActividadesDAO();
                objProyBean = new ActividadesBean();
                objProyBean.setNumero(num[0]);
                objProyBean=objProyDAO.CapturarActividades(objProyBean);
                request.setAttribute("DATOS",  objProyBean);
                
               
                pagina = "/Actividades/FrmModificarActividadesPersonal.jsp";
                
                
            }break;
            case 13 :{
              String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numeros[]=new  int[numeroCad.length];
                for(int i=0;i<numeros.length;i++)
                {
                    numeros[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objProyDAO= new ActividadesDAO();
                objProyBean = new ActividadesBean();
                ActividadesBean obj=new ActividadesBean();
                objProyBean.setNumero(numeros[0]);
                int  i= objProyDAO.eliminaractividades(objProyBean);
                 int codproyecto=Integer.parseInt(request.getParameter("codproy"));
                obj.setNUMPROY(codproyecto);
                
           lista=objProyDAO.cargartablaactividadesPersonal(obj);
          
                request.setAttribute("lista",  lista);
               
                request.setAttribute("numproy", obj);
                 request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
              
                   pagina = "/Actividades/FrmActividadesMantPersonal.jsp";
                
            }break;
            
            case 14:{
                
                 objProyDAO=new ActividadesDAO();
      lista=objProyDAO.cargartablaactividades1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"actividades\":[");
          for(int i=0;i<lista.size();i++)
          {
           ActividadesBean  obj=(ActividadesBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"numero\":\""+obj.getNumero()+"\",\"actividad\":\""+obj.getActividad()+"\",\"duracion\":\""+obj.getDuracion()+"\",\"reponsable\":\""+obj.getResponsable()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"}");   
               }
               else
               {
               json.append("{\"numero\":\""+obj.getNumero()+"\",\"actividad\":\""+obj.getActividad()+"\",\"duracion\":\""+obj.getDuracion()+"\",\"reponsable\":\""+obj.getResponsable()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
                
                
                
            }break;
            
                        //mostrar
              case 15:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objProyDAO=new ActividadesDAO();
                  
               lista=objProyDAO.cargartablaactividades1();
            out.println("{\"actividades\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 16:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();
                  objProyDAO = new ActividadesDAO();
                      
                    numero = Integer.parseInt(request.getParameter("txtnum"));
                    actividad = request.getParameter("txtact");
                    duracion = request.getParameter("txtdur");
                    responsable = request.getParameter("txtres");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
               objProyBean = new ActividadesBean();
               objProyBean.setNumero(numero);
               objProyBean.setActividad(actividad);
               objProyBean.setDuracion(duracion);
               objProyBean.setResponsable(responsable);
               objProyBean.setNUMPROY(proy);
               int i = objProyDAO.grabaractividades(objProyBean);
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
 numero = Integer.parseInt(request.getParameter("txtnum"));
                    actividad = request.getParameter("txtact");
                    duracion = request.getParameter("txtdur");
                    responsable = request.getParameter("txtres");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
               objProyBean = new ActividadesBean();
               objProyBean.setNumero(numero);
               objProyBean.setActividad(actividad);
               objProyBean.setDuracion(duracion);
               objProyBean.setResponsable(responsable);
               objProyBean.setNUMPROY(proy);
               
               objProyDAO=new ActividadesDAO();
                int i=objProyDAO.modificaractividades(objProyBean);
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
                objProyDAO= new ActividadesDAO();
                objProyBean = new ActividadesBean();
                objProyBean.setNumero(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objProyDAO.eliminaractividades(objProyBean);
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
