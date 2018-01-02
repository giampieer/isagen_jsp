
package servlets;

import BEAN.JefeBean;
import BEAN.ProyectoBean;
import DAO.JefeDAO;
import DAO.ProyectoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProyectoServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     response.setContentType("application/json");
         StringBuilder json=null;
        
        
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        int  num;
        String numero,titulo,duracion,descripcion,tipo,fases,inicio,fin,gastos,codjefe;
        String pagina = "";
        ProyectoDAO objProyDAO = null;
        ArrayList lista = null;
        ProyectoBean  objProyBean = null;
        JefeDAO objJefeDAO=null;
        
        
               
       
                
        
        switch(op)
        {
            case 1://Listar
            {
                objProyDAO = new ProyectoDAO();
                lista=objProyDAO.cargartablaproyecto();
                request.setAttribute("lista", lista);
                pagina = "/Relacion/FrmRelacionprincipal.jsp";
              
            }break;
            case 2://Pagina grabar
            {
                //cargar combobox con datos del proyecto
                objJefeDAO=new JefeDAO();
                lista=objJefeDAO.ListarJefedeProyecto();
                    request.setAttribute("lista1", lista);
                    
                pagina = "/Relacion/FrmNuevoRelacion.jsp";
            }break;
            case 3://Nuevo
            {
                objProyDAO = new ProyectoDAO();
                      
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    titulo= request.getParameter("txttit");
                   duracion = request.getParameter("txtdur");
                   descripcion= request.getParameter("txtdes");
                   tipo= request.getParameter("txttip");
                   fases= request.getParameter("txtcan");
                 inicio= request.getParameter("txtini");
                 fin= request.getParameter("txtfin");
                 gastos= request.getParameter("txtpre");
                 codjefe=request.getParameter("txtcodjefe");
                 int jefe=Integer.parseInt(codjefe);
             
                    
                    objProyBean = new ProyectoBean();
                    objProyBean.setNumero(num);
               objProyBean.setTitulo(titulo);
               objProyBean.setDuracion(duracion);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setTipo(tipo);
               objProyBean.setFases(fases);
               objProyBean.setInicio(inicio);
               objProyBean.setFin(fin);
               objProyBean.setGastos(gastos);
               objProyBean.setCODJEFE(jefe);
               
               //cargar combobox con datos del proyecto
                objJefeDAO=new JefeDAO();
                lista=objJefeDAO.ListarJefedeProyecto();
                    request.setAttribute("lista1", lista);
       
                    int i = objProyDAO.grabarproyecto(objProyBean);
                     if(i == 1){
                request.setAttribute("mensaje","Se Grabo Correctamente (Grabar obligatoriamente los requsitos del proyecto creado)");
                }else{
                request.setAttribute("mensaje","Error al Grabar");  
                }
                    pagina = "/Relacion/FrmNuevoRelacion.jsp";
            }break;
            case 4://Salir
            {
                objProyDAO = new ProyectoDAO();
                lista = objProyDAO.cargartablaproyecto();
                request.setAttribute("lista", lista);
                pagina = "/Relacion/FrmRelacionprincipal.jsp";
            }break;
            case 5://Capturar Numero
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ProyectoDAO();
                objProyBean = new ProyectoBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarProyecto(objProyBean);
                
                
                //cargar combobox con datos del proyecto
                objJefeDAO=new JefeDAO();
                lista=objJefeDAO.ListarJefedeProyecto();
                    request.setAttribute("lista1", lista);
                
                request.setAttribute("DATOS",  objProyBean);
                pagina = "/Relacion/FrmModificarRelacion.jsp";
            }break;
                   
        
   
    
            case 6://Modificar nuevos datos
            {
                 numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                titulo= request.getParameter("txttit");
                duracion = request.getParameter("txtdur");
                   descripcion= request.getParameter("txtdes");
                   tipo= request.getParameter("txttip");
                   fases= request.getParameter("txtcan");
                 inicio= request.getParameter("txtini");
                 fin= request.getParameter("txtfin");
                 gastos= request.getParameter("txtpre");
                 codjefe=request.getParameter("txtcodjefe");
                 int jefe=Integer.parseInt(codjefe);
                
              objProyBean = new ProyectoBean();
                 objProyDAO=new ProyectoDAO();
                 objProyBean.setNumero(num);
               objProyBean.setTitulo(titulo);
               objProyBean.setDuracion(duracion);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setTipo(tipo);
               objProyBean.setFases(fases);
               objProyBean.setInicio(inicio);
               objProyBean.setFin(fin);
               objProyBean.setGastos(gastos);
               objProyBean.setCODJEFE(jefe);
                int i=objProyDAO.modificarproyecto(objProyBean);
                lista=objProyDAO.cargartablaproyecto();
                 if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                request.setAttribute("lista", lista);
                pagina = "/Relacion/FrmRelacionprincipal.jsp";
            }break;
            case 7://Eliminar
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ProyectoDAO();
                objProyBean = new ProyectoBean();
                objProyBean.setNumero(numero1[0]);
                int  i= objProyDAO.eliminarproyecto(objProyBean);
                
                lista = objProyDAO.cargartablaproyecto();
                request.setAttribute("lista", lista);
                 if(i == 1){
                request.setAttribute("mensaje","Registro Eliminado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Eliminado");  
                }
                pagina = "/Relacion/FrmRelacionprincipal.jsp";
            }break;
            case 8:{
                
                 objProyDAO=new ProyectoDAO();
      lista=objProyDAO.cargartablaproyecto1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"proy\":[");
          for(int i=0;i<lista.size();i++)
          {
           ProyectoBean  obj=(ProyectoBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"NUMERO\":\""+obj.getNumero()+"\",\"TITULO\":\""+obj.getTitulo()+"\",\"DURACION\":\""+obj.getDuracion()+"\",\"DESCRIPCION\":\""
                       + ""+obj.getDescripcion()+"\",\"TIPO\":\""+obj.getTipo()+"\",\"FASES\":\""+obj.getFases()+"\",\"INICIO\":\""+obj.getInicio()+"\",\"FIN\":\""+obj.getFin()+"\",\"GASTOS\":\""
                               + ""+obj.getGastos()+"\",\"CODJEFE\":\""+obj.getCODJEFE()+"\"}");   
               }
               else
               {
              json.append("{\"NUMERO\":\""+obj.getNumero()+"\",\"TITULO\":\""+obj.getTitulo()+"\",\"DURACION\":\""+obj.getDuracion()+"\",\"DESCRIPCION\":\""
                      + ""+obj.getDescripcion()+"\",\"TIPO\":\""+obj.getTipo()+"\",\"FASES\":\""+obj.getFases()+"\",\"INICIO\":\""+obj.getInicio()+"\",\"FIN\":\""+obj.getFin()+"\",\"GASTOS\":\""
                              + ""+obj.getGastos()+"\",\"CODJEFE\":\""+obj.getCODJEFE()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
            }break;
            case 9:{/*dirogir a info para reportes
                  String report=request.getParameter("cod");
               
                
                request.setAttribute("DATOS", report);
                pagina = "/pdf.jsp";
                
                */
                
            };break;
              case 10:{//dirogir a info para reportes
                  String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ProyectoDAO();
                objProyBean = new ProyectoBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarProyecto(objProyBean);
                
                
                //cargar combobox con datos del proyecto
                objJefeDAO=new JefeDAO();
                lista=objJefeDAO.ListarJefedeProyecto();
                    request.setAttribute("lista1", lista);
                
                request.setAttribute("DATOS",  objProyBean);
                pagina = "/Relacion/FrmInfo.jsp";
   
    }break;

              case 11:{
                  pagina = "/Relacion/Extras.jsp";    
              }break;
              //mostrar
              case 12:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objProyDAO=new ProyectoDAO();
                  
               lista=objProyDAO.cargartablaproyecto1();
            out.println("{\"proy\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 13:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();

                objProyDAO = new ProyectoDAO();
                      
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    titulo= request.getParameter("txttit");
                   duracion = request.getParameter("txtdur");
                   descripcion= request.getParameter("txtdes");
                   tipo= request.getParameter("txttip");
                   fases= request.getParameter("txtcan");
                 inicio= request.getParameter("txtini");
                 fin= request.getParameter("txtfin");
                 gastos= request.getParameter("txtpre");
                 codjefe=request.getParameter("txtcodjefe");
                 int jefe=Integer.parseInt(codjefe);
                 
                 objProyBean = new ProyectoBean();
                    objProyBean.setNumero(num);
               objProyBean.setTitulo(titulo);
               objProyBean.setDuracion(duracion);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setTipo(tipo);
               objProyBean.setFases(fases);
               objProyBean.setInicio(inicio);
               objProyBean.setFin(fin);
               objProyBean.setGastos(gastos);
               objProyBean.setCODJEFE(jefe);

               int i = objProyDAO.grabarproyecto(objProyBean);
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
       case 14:{
           PrintWriter out = response.getWriter();
         json=new StringBuilder();   
                objProyDAO = new ProyectoDAO();
                      
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    titulo= request.getParameter("txttit");
                   duracion = request.getParameter("txtdur");
                   descripcion= request.getParameter("txtdes");
                   tipo= request.getParameter("txttip");
                   fases= request.getParameter("txtcan");
                 inicio= request.getParameter("txtini");
                 fin= request.getParameter("txtfin");
                 gastos= request.getParameter("txtpre");
                 codjefe=request.getParameter("txtcodjefe");
                 int jefe=Integer.parseInt(codjefe);
                 
                 objProyBean = new ProyectoBean();
                    objProyBean.setNumero(num);
               objProyBean.setTitulo(titulo);
               objProyBean.setDuracion(duracion);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setTipo(tipo);
               objProyBean.setFases(fases);
               objProyBean.setInicio(inicio);
               objProyBean.setFin(fin);
               objProyBean.setGastos(gastos);
               objProyBean.setCODJEFE(jefe);
//cargar combobox con datos del proyecto
  Gson gson= new Gson();
         int i = objProyDAO.modificarproyecto(objProyBean);
                json.append("{\"NUMERO\":\""+i+"\"}");
                out.print(json.toString());
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se modifico}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se modifico}"));

                  }
                  
       }break;
       case 15:{
               String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ProyectoDAO();
                objProyBean = new ProyectoBean();
                objProyBean.setNumero(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objProyDAO.eliminarproyecto(objProyBean);
                json.append("{\"NUMERO\":\""+i+"\"}");
                out.print(json.toString());
         
         
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se elimino}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se elimino}"));

                          }

       }break;
       
       
       case 16:{
           
         
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
            objJefeDAO=new JefeDAO();
                lista=objJefeDAO.ListarJefedeProyecto();
                    request.setAttribute("lista1", lista);
            out.println("{\"jefes\":" +gson.toJson(lista)+"}");
             
                  
        
           
       }break;
       case 17:{
           
                //cargar combobox con datos del proyecto
                objJefeDAO=new JefeDAO();
                lista=objJefeDAO.ListarJefedeProyecto();
                    
                    
                    
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"jefe\":[");
          for(int i=0;i<lista.size();i++)
          {
           JefeBean  obj=(JefeBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"CODJEFE\":\""+obj.getCODJEFE()+"\"}");   
               }
               else
               {
              json.append("{\"CODJEFE\":\""+obj.getCODJEFE()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
           
           
       }break;
       
       case 18:{
           //GENERAR CODIGO DE PROYECTO ANDROID
           objProyDAO=new  ProyectoDAO();
           int i=objProyDAO.generarCodigo();
           PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
               
                  
              
            out.println("{\"NUMERO\":\"" +gson.toJson(i)+"\"}");
            
       }break;
       case 19:{
         //COMBO DE JEFE EN ANDROID
                  objJefeDAO=new JefeDAO();
                  
               lista=objJefeDAO.ListarJefedeProyecto();

      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"proy\":[");
          for(int i=0;i<lista.size();i++)
          {
              JefeBean  obj=(JefeBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"CODJEFE\":\""+String.valueOf(obj.getCODJEFE())+"\",\"NOMBJEFE\":\""+obj.getNOMBJEFE()+"\"}");   
               }
               else
               {
              json.append("{\"CODJEFE\":\""+String.valueOf(obj.getCODJEFE())+"\",\"NOMBJEFE\":\""+obj.getNOMBJEFE()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());    
       }break;
       
      
       case 20:{
           
           //MOSTRAR DATOS PDF PROYECTO ANDROID
            String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new ProyectoDAO();
                objProyBean = new ProyectoBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarProyecto(objProyBean);
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
         
        
        

    
              json.append("{\"NUMERO\":\""+objProyBean.getNumero()+"\",\"TITULO\":\""+objProyBean.getTitulo()+"\",\"DURACION\":\""+objProyBean.getDuracion()+"\",\"DESCRIPCION\":\""
                      + ""+objProyBean.getDescripcion()+"\",\"TIPO\":\""+objProyBean.getTipo()+"\",\"FASES\":\""+objProyBean.getFases()+"\",\"INICIO\":\""+objProyBean.getInicio()+"\",\"FIN\":\""+objProyBean.getFin()+"\",\"GASTOS\":\""
                              + ""+objProyBean.getGastos()+"\",\"CODJEFE\":\""+objProyBean.getCODJEFE()+"\"},");   
               
          
        
        out.print(json.toString());
       }break;
          
       case 21:{
           String nomb=request.getParameter("nombproy");
            objProyBean = new ProyectoBean();
                objProyBean.setTitulo(nomb);
         
                 objProyDAO=new ProyectoDAO();
      lista=objProyDAO.buscartablaproyecto1(objProyBean);
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"proy\":[");
          for(int i=0;i<lista.size();i++)
          {
           ProyectoBean  obj=(ProyectoBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"NUMERO\":\""+obj.getNumero()+"\",\"TITULO\":\""+obj.getTitulo()+"\",\"DURACION\":\""+obj.getDuracion()+"\",\"DESCRIPCION\":\""
                       + ""+obj.getDescripcion()+"\",\"TIPO\":\""+obj.getTipo()+"\",\"FASES\":\""+obj.getFases()+"\",\"INICIO\":\""+obj.getInicio()+"\",\"FIN\":\""+obj.getFin()+"\",\"GASTOS\":\""
                               + ""+obj.getGastos()+"\",\"CODJEFE\":\""+obj.getCODJEFE()+"\"}");   
               }
               else
               {
              json.append("{\"NUMERO\":\""+obj.getNumero()+"\",\"TITULO\":\""+obj.getTitulo()+"\",\"DURACION\":\""+obj.getDuracion()+"\",\"DESCRIPCION\":\""
                      + ""+obj.getDescripcion()+"\",\"TIPO\":\""+obj.getTipo()+"\",\"FASES\":\""+obj.getFases()+"\",\"INICIO\":\""+obj.getInicio()+"\",\"FIN\":\""+obj.getFin()+"\",\"GASTOS\":\""
                              + ""+obj.getGastos()+"\",\"CODJEFE\":\""+obj.getCODJEFE()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
            }break;
       case 22:{
            objJefeDAO = new JefeDAO();
                lista=objJefeDAO.ListarJefe();
                request.setAttribute("lista", lista);
                pagina = "/login.jsp";
           break;
       }
     
       
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
