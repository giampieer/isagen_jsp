
package servlets;

import BEAN.RiesgosBean;
import DAO.ProyectoDAO;
import DAO.RiesgosDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RiesgosServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
             response.setContentType("application/json");
         StringBuilder json=null;
        
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        int  num;
        String numero,nivel,descripcion,numproy;
        String pagina = "";
        RiesgosDAO objProyDAO = null;
        ArrayList lista = null;
        RiesgosBean  objProyBean = null;
        ProyectoDAO objDAO=null;
        switch(op)
        {
            case 1://Listar
            {
                objProyDAO = new RiesgosDAO();
                lista=objProyDAO.cargartablariesgos1();
                request.setAttribute("lista", lista);
                pagina = "/Riesgos/FrmRiesgosprincipal.jsp";
            }break;
            case 2://Pagina grabar
            {
                //cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/Riesgos/FrmNuevoRiesgos.jsp";
            }break;
            case 3://Nuevo
            {
                objProyDAO = new RiesgosDAO();
                      
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel = request.getParameter("txtniv");
                    descripcion= request.getParameter("txtdes");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
               objProyBean = new RiesgosBean();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripción(descripcion);
               objProyBean.setNUMPROY(proy);
       
                    int i = objProyDAO.grabarriesgos(objProyBean);
                    if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    
                    //cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                    
                    pagina = "/Riesgos/FrmNuevoRiesgos.jsp";
            }break;
            case 4://Salir
            {
                objProyDAO = new RiesgosDAO();
                lista = objProyDAO.cargartablariesgos1();
                request.setAttribute("lista", lista);
                pagina = "/Riesgos/FrmRiesgosprincipal.jsp";
            }break;
            case 5://Capturar Numero
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new RiesgosDAO();
                objProyBean = new RiesgosBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarRiesgos(objProyBean);
                request.setAttribute("DATOS",  objProyBean);
                
                //cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                
                pagina = "/Riesgos/FrmModificarRiesgos.jsp";
            }break;
    
            case 6://Modificar nuevos datos
            {
                 numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                 nivel = request.getParameter("txtniv");
                 descripcion= request.getParameter("txtdes");
                numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
               objProyBean = new RiesgosBean();
               objProyDAO=new RiesgosDAO();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripción(descripcion);
               objProyBean.setNUMPROY(proy);
                int i=objProyDAO.modificarriesgos(objProyBean);
                lista=objProyDAO.cargartablariesgos1();
                request.setAttribute("lista", lista);
                 if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                pagina = "/Riesgos/FrmRiesgosprincipal.jsp";
            }break;
            case 7://Eliminar
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new RiesgosDAO();
                objProyBean = new RiesgosBean();
                objProyBean.setNumero(numero1[0]);
                int  i= objProyDAO.eliminarriesgos(objProyBean);
                
                lista = objProyDAO.cargartablariesgos1();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                pagina = "/Riesgos/FrmRiesgosprincipal.jsp";
            }  break;
            
            //PERSONAL
            case 8://mostrar tabla
            {
             numproy=request.getParameter("cod");
             int proy=Integer.parseInt(numproy);
                objProyBean=new RiesgosBean();
                objProyDAO=new RiesgosDAO();
               //mostrar tabla personal 
                objProyBean.setNUMPROY(proy);
                lista=objProyDAO.cargartablariesgos1Personal(objProyBean);
               //capturar numero pryecto
               request.setAttribute("numproy", objProyBean);
                request.setAttribute("lista",  lista);
                pagina = "/Riesgos/FrmRiesgosMantPersonal.jsp";
              }break;
              
              
              //redireccionar a grabar 
            case 9:{
                numproy=request.getParameter("cod");
                 int proy=Integer.parseInt(numproy);
                objProyBean=new RiesgosBean();
                objProyBean.setNUMPROY(proy);
                request.setAttribute("numproy", objProyBean);
                 pagina = "/Riesgos/FrmNuevoRiesgosPersonal.jsp";
            }break;
            
            //grabar  personal
            case 10:{
                    objProyDAO = new RiesgosDAO();
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel = request.getParameter("txtniv");
                    descripcion= request.getParameter("txtdes");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
               objProyBean = new RiesgosBean();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripción(descripcion);
               objProyBean.setNUMPROY(proy);
       
                    int i = objProyDAO.grabarriesgos(objProyBean);
                     if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    //cargar el numero del proyecto 
                    RiesgosBean objproy=null;
                    objproy=new RiesgosBean();
                    objproy.setNUMPROY(proy);
                    request.setAttribute("GRABAR",""+i);
                   request.setAttribute("numproy", objproy);
                    pagina = "/Riesgos/FrmNuevoRiesgosPersonal.jsp";
            }break;
            
            //modificar
            case 11:{
              numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                 nivel = request.getParameter("txtniv");
                 descripcion= request.getParameter("txtdes");
                numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
               objProyBean = new RiesgosBean();
               objProyDAO=new RiesgosDAO();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripción(descripcion);
               objProyBean.setNUMPROY(proy);
                int i=objProyDAO.modificarriesgos(objProyBean);
                 if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                //cargar proyecto
                RiesgosBean objnumproy=null;
                objnumproy=new RiesgosBean();
                objnumproy.setNUMPROY(proy);
                lista = objProyDAO.cargartablariesgos1Personal(objnumproy);
                
                
                request.setAttribute("lista", lista);
               
                 request.setAttribute("numproy", objnumproy);
                pagina = "/Riesgos/FrmRiesgosMantPersonal.jsp";
            }break;
            
            //capturar numero y redireccionar a modificar
            case 12 :{
                 String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new RiesgosDAO();
                objProyBean = new RiesgosBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarRiesgos(objProyBean);
                request.setAttribute("DATOS",  objProyBean);
                
               
                pagina = "/Riesgos/FrmModificarRiesgosPersonal.jsp";
                
                
            }break;
            
            case 13:{
              String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO = new RiesgosDAO();
                objProyBean= new RiesgosBean();
                RiesgosBean obj=null;
                obj=new RiesgosBean();
                
                objProyBean.setNumero(numero1[0]);
                
                int  i= objProyDAO.eliminarriesgos(objProyBean);
                
                 int codproyecto=Integer.parseInt(request.getParameter("codproy"));
                obj.setNUMPROY(codproyecto);
                
                   lista=objProyDAO.cargartablariesgos1Personal(obj);
          
                request.setAttribute("lista",  lista);
               
                request.setAttribute("numproy", obj);
                 request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
               
                pagina = "/Riesgos/FrmRiesgosMantPersonal.jsp";
            }break;
            case 14:{
                
                 objProyDAO=new RiesgosDAO();
      lista=objProyDAO.cargartablariesgos1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"riesgos\":[");
          for(int i=0;i<lista.size();i++)
          {
           RiesgosBean  obj=(RiesgosBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"numero\":\""+obj.getNumero()+"\",\"nivel\":\""+obj.getNivel()+"\",\"descripcion\":\""+obj.getDescripción()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"}");   
               }
               else
               {
               json.append("{\"numero\":\""+obj.getNumero()+"\",\"nivel\":\""+obj.getNivel()+"\",\"descripcion\":\""+obj.getDescripción()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
                
                
            }break;
            
            
                        //mostrar
              case 15:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objProyDAO=new RiesgosDAO();
                  
               lista=objProyDAO.cargartablariesgos1();
            out.println("{\"riesgos\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 16:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();
objProyDAO = new RiesgosDAO();
                      
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel = request.getParameter("txtniv");
                    descripcion= request.getParameter("txtdes");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
               objProyBean = new RiesgosBean();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripción(descripcion);
               objProyBean.setNUMPROY(proy);
       
                    int i = objProyDAO.grabarriesgos(objProyBean);
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
               numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                 nivel = request.getParameter("txtniv");
                 descripcion= request.getParameter("txtdes");
                numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
               objProyBean = new RiesgosBean();
               objProyDAO=new RiesgosDAO();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripción(descripcion);
               objProyBean.setNUMPROY(proy);
                int i=objProyDAO.modificarriesgos(objProyBean);
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
                objProyDAO= new RiesgosDAO();
                objProyBean = new RiesgosBean();
                objProyBean.setNumero(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objProyDAO.eliminarriesgos(objProyBean);
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
