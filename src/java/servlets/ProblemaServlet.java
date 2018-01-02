
package servlets;

import BEAN.ProblemaBean;
import BEAN.ProyectoBean;
import DAO.ProblemaDAO;
import DAO.ProyectoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProblemaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    response.setContentType("application/json");
         StringBuilder json=null;
        
         String opcad=request.getParameter("op");
         
        int op=Integer.parseInt(opcad);
        int  num;
        
        String numero,nivel,descripcion,perjudicado,numproy;
        String pagina = "";
        ProblemaDAO objProyDAO = null;
        ArrayList lista = null;
        ProblemaBean  objProyBean = null;
        ProyectoBean objProyectoBean=null;
        ProyectoDAO objDAO=null;
        switch(op)
        {
            case 1://Listar
            {
                objProyDAO = new ProblemaDAO();
                lista=objProyDAO.cargartablaproblema1();
                request.setAttribute("lista", lista);
                pagina = "/Problema/FrmProblemaprincipal.jsp";
            }break;
            case 2://Pagina grabar
            {
                //para cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.ProyectodeProblema();
                request.setAttribute("lista1", lista);
                pagina = "/Problema/FrmNuevoProblema.jsp";
               
            }break;
            case 3://Nuevo
            {
                objProyDAO = new ProblemaDAO();
                 
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel= request.getParameter("txtnivel");
                   descripcion = request.getParameter("txtdes");
                   perjudicado= request.getParameter("txtper");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new ProblemaBean();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setPerjudicado(perjudicado);
               objProyBean.setNUMPROY(proy);
               int i = objProyDAO.grabarproblema(objProyBean);
                     if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente (Grabar obligatoriamente el objetivo general del proyecto creado)");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    //para cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.ProyectodeProblema();
                request.setAttribute("lista1", lista);
                        pagina = "/Problema/FrmNuevoProblema.jsp";
            }break;
            case 4://Salir
            {
                objProyDAO = new ProblemaDAO();
                lista = objProyDAO.cargartablaproblema1();
                request.setAttribute("lista", lista);
                pagina = "/Problema/FrmProblemaprincipal.jsp";
            }break;
            case 5://Capturar Numero
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ProblemaDAO();
                objProyBean = new ProblemaBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarProblema(objProyBean);
                request.setAttribute("DATOS",  objProyBean);
                
                //para cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.ProyectodeProblema();
                request.setAttribute("lista1", lista);
                pagina = "/Problema/FrmModificarProblema.jsp";
            }break;
                   
        
   
    
            case 6://Modificar nuevos datos
            {
                numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel= request.getParameter("txtnivel");
                   descripcion = request.getParameter("txtdes");
                   perjudicado= request.getParameter("txtper");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new ProblemaBean();
                    objProyDAO=new ProblemaDAO();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setPerjudicado(perjudicado);
               objProyBean.setNUMPROY(proy);
               
                int i=objProyDAO.modificarproblema(objProyBean);
                if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                lista=objProyDAO.cargartablaproblema1();
                request.setAttribute("lista", lista);
                
                
                pagina = "/Problema/FrmProblemaprincipal.jsp";
            }break;
            case 7://Eliminar
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ProblemaDAO();
                objProyBean = new ProblemaBean();
                objProyBean.setNumero(numero1[0]);
                int  i= objProyDAO.eliminarproblema(objProyBean);
                
                lista = objProyDAO.cargartablaproblema1();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                pagina = "/Problema/FrmProblemaprincipal.jsp";
            }break;
            case 8:{
                objProyDAO=new ProblemaDAO();
      lista=objProyDAO.cargartablaproblema1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"problema\":[");
          for(int i=0;i<lista.size();i++)
          {
           ProblemaBean  obj=(ProblemaBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"NUMERO\":\""+obj.getNumero()+"\",\"NIVEL\":\""+obj.getNivel()+"\",\"DESCRIPCION\":\""+obj.getDescripcion()+"\",\"PERJUDICADO\":\""+obj.getPerjudicado()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"}");   
               }
               else
               {
               json.append("{\"NUMERO\":\""+obj.getNumero()+"\",\"NIVEL\":\""+obj.getNivel()+"\",\"DESCRIPCION\":\""+obj.getDescripcion()+"\",\"PERJUDICADO\":\""+obj.getPerjudicado()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
            }break;
                //mostrar
              case 9:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objProyDAO=new ProblemaDAO();
                  
               lista=objProyDAO.cargartablaproblema1();
            out.println("{\"´problema\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 10:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();

             objProyDAO = new ProblemaDAO();
                 
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel= request.getParameter("txtnivel");
                   descripcion = request.getParameter("txtdes");
                   perjudicado= request.getParameter("txtper");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new ProblemaBean();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setPerjudicado(perjudicado);
               objProyBean.setNUMPROY(proy);
               int i = objProyDAO.grabarproblema(objProyBean);
               json.append("{\"NUMERO\":\""+i+"\"}");
                out.print(json.toString());
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se ingreso}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se ingreso}"));

                          }
                  out.print(json.toString());
                  //http://localhost:8084/ProyectoGestion/ProyectoServlet?op=11&txtnum=5&txttit=sadsa&txtdur=adsa&txtdes=ssds&txttip=asa&txtcan=sdsd&txtini=saas&txtfin=asas&txtpre=sds&txtcodjefe=4
              }break;
              
              //modificar
       case 11:{
           PrintWriter out = response.getWriter();
         json=new StringBuilder();   
     numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel= request.getParameter("txtnivel");
                   descripcion = request.getParameter("txtdes");
                   perjudicado= request.getParameter("txtper");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new ProblemaBean();
                    objProyDAO=new ProblemaDAO();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setPerjudicado(perjudicado);
               objProyBean.setNUMPROY(proy);
                Gson gson= new Gson();
                int i=objProyDAO.modificarproblema(objProyBean);
                json.append("{\"NUMERO\":\""+i+"\"}");
                out.print(json.toString());
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se modifico}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se modifico}"));

                  }
                  out.print(json.toString());
       }break;
       case 12:{
               String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ProblemaDAO();
                objProyBean = new ProblemaBean();
                objProyBean.setNumero(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objProyDAO.eliminarproblema(objProyBean);
         json.append("{\"NUMERO\":\""+i+"\"}");
                out.print(json.toString());
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se elimino}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se elimino}"));

                          }
               out.print(json.toString());
       }break;
       
       
       case 13:{
              //COMBO DE Proyecto EN ANDROID
                 objProyectoBean=new ProyectoBean();
                 objDAO=new ProyectoDAO();
                  
               lista=objDAO.ProyectodeRequisito();

      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"proy\":[");
          for(int i=0;i<lista.size();i++)
          {
              ProyectoBean  obj=(ProyectoBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"NUMERO\":\""+String.valueOf(obj.getNumero())+"\",\"TITULO\":\""+obj.getTitulo()+"\"}");   
               }
               else
               {
              json.append("{\"NUMERO\":\""+String.valueOf(obj.getNumero())+"\",\"TITULO\":\""+obj.getTitulo()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());    
       }break;
       
        case 14:{
              //GENERAR CODIGO DE PROYECTO ANDROID
              objProyDAO=new ProblemaDAO();
              int i=objProyDAO.generarCodigo();
           PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
               
                  
              
            out.println("{\"NUMERO\":\"" +gson.toJson(i)+"\"}");
       }break;
       
       
         case 15:{
           
           //MOSTRAR DATOS PDF PROYECTO ANDROID
            String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ProblemaDAO();
                objProyBean = new ProblemaBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarProblema(objProyBean);
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
         json.append("{\"NUMERO\":\""+objProyBean.getNumero()+"\",\"NIVEL\":\""+objProyBean.getNivel()+"\",\"DESCRIPCION\":\""+objProyBean.getDescripcion()+"\",\"PERJUDICADO\":\""+objProyBean.getPerjudicado()+"\",\"NUMPROY\":\""+objProyBean.getNUMPROY()+"\"},");
        out.print(json.toString());
       }break;
       
       
        }getServletContext().getRequestDispatcher(pagina).forward(request,response);
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
