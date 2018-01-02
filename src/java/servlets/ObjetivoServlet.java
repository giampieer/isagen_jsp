
package servlets;

import BEAN.ObjetivoBean;
import BEAN.ProyectoBean;
import DAO.ObjetivoDAO;
import DAO.ProyectoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ObjetivoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
           response.setContentType("application/json");
         StringBuilder json=null;
        
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        int  num;
        String numero,nivel,descripcion,finalidad,numproy;
        String pagina = "";
        ObjetivoDAO objProyDAO = null;
        ArrayList lista = null;
        ObjetivoBean objProyBean = null;
        ProyectoDAO objDAO  =null;
        ProyectoBean objProyectoBean=null;
        switch(op)
        {
            case 1://Listar
            {
                
                objProyDAO = new ObjetivoDAO();
                lista=objProyDAO.cargartablaobjetivo1();
                request.setAttribute("lista", lista);
                pagina = "/Objetivo/FrmObjetivoprincipal.jsp";
            }break;
            case 2://Pagina grabar
            {
                objDAO=new ProyectoDAO();
                lista=objDAO.ProyectodeObjetivo();
                request.setAttribute("lista1", lista);
                pagina = "/Objetivo/FrmNuevoObjetivo.jsp";
            }break;
            case 3://Nuevo
            {
                objProyDAO = new ObjetivoDAO();
                      
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel= request.getParameter("txtnivel");
                   descripcion = request.getParameter("txtdes");
                   finalidad= request.getParameter("txtfin");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new ObjetivoBean();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setFinalidad(finalidad);
               objProyBean.setNUMPROY(proy);
               int i = objProyDAO.grabarobjetivo(objProyBean);
                  if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente ");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }                    
                    objDAO=new ProyectoDAO();
                lista=objDAO.ProyectodeObjetivo();
                request.setAttribute("lista1", lista);
                    pagina = "/Objetivo/FrmNuevoObjetivo.jsp";
            }break;
            case 4://Salir
            {
                objProyDAO = new ObjetivoDAO();
                lista = objProyDAO.cargartablaobjetivo1();
                request.setAttribute("lista", lista);
                pagina = "/Objetivo/FrmObjetivoprincipal.jsp";
            }break;
            case 5://Capturar Numero
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ObjetivoDAO();
                objProyBean = new ObjetivoBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarObjetivo(objProyBean);
                request.setAttribute("DATOS",  objProyBean);
                //cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.ProyectodeObjetivo();
                request.setAttribute("lista1", lista);
                
                pagina = "/Objetivo/FrmModificarObjetivo.jsp";
            }break;
                   
        
   
    
            case 6://Modificar nuevos datos
            {
                numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel= request.getParameter("txtnivel");
                   descripcion = request.getParameter("txtdes");
                   finalidad= request.getParameter("txtfin");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new ObjetivoBean();
                    objProyDAO=new ObjetivoDAO();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setFinalidad(finalidad);
               objProyBean.setNUMPROY(proy);
               
                int i=objProyDAO.modificarObjetivo(objProyBean);
                if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                lista=objProyDAO.cargartablaobjetivo1();
                request.setAttribute("lista", lista);
                pagina = "/Objetivo/FrmObjetivoprincipal.jsp";
            }break;
            case 7://Eliminar
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ObjetivoDAO();
                objProyBean = new ObjetivoBean();
                objProyBean.setNumero(numero1[0]);
                int  i= objProyDAO.eliminarobjetivo(objProyBean);
                
                lista = objProyDAO.cargartablaobjetivo1();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                pagina = "/Objetivo/FrmObjetivoprincipal.jsp";
            }break;
            case 8:{
                
                objProyDAO=new ObjetivoDAO();
      lista=objProyDAO.cargartablaobjetivo1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"objetivo\":[");
          for(int i=0;i<lista.size();i++)
          {
           ObjetivoBean  obj=(ObjetivoBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"NUMERO\":\""+obj.getNumero()+"\",\"NIVEL\":\""+obj.getNivel()+"\",\"DESCRIPCION\":\""+obj.getDescripcion()+"\",\"FINALIDAD\":\""+obj.getFinalidad()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"}");   
               }
               else
               {
               json.append("{\"NUMERO\":\""+obj.getNumero()+"\",\"NIVEL\":\""+obj.getNivel()+"\",\"DESCRIPCION\":\""+obj.getDescripcion()+"\",\"FINALIDAD\":\""+obj.getFinalidad()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
            }break;
            
             case 9:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objProyDAO=new ObjetivoDAO();
                  
               lista=objProyDAO.cargartablaobjetivo1();
            out.println("{\"´objetivo\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 10:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();
                  objProyDAO = new ObjetivoDAO();
                      
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel= request.getParameter("txtnivel");
                   descripcion = request.getParameter("txtdes");
                   finalidad= request.getParameter("txtfin");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new ObjetivoBean();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setFinalidad(finalidad);
               objProyBean.setNUMPROY(proy);
               int i = objProyDAO.grabarobjetivo(objProyBean);
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
                   finalidad= request.getParameter("txtfin");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new ObjetivoBean();
                    objProyDAO=new ObjetivoDAO();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setFinalidad(finalidad);
               objProyBean.setNUMPROY(proy);
               Gson gson=new Gson();
                int i=objProyDAO.modificarObjetivo(objProyBean);
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
           json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ObjetivoDAO();
                objProyBean = new ObjetivoBean();
                objProyBean.setNumero(numero1[0]);
                int  i= objProyDAO.eliminarobjetivo(objProyBean);
                
                Gson gson= new Gson();
                
                 
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
