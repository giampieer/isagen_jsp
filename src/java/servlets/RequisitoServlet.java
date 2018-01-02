
package servlets;

import BEAN.ProyectoBean;
import BEAN.RequisitoBean;
import DAO.ProyectoDAO;
import DAO.RequisitoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisitoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
             response.setContentType("application/json");
         StringBuilder json=null;
        
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        int  num;
        String numero,alcance,personal,reunion,descripcion,numproy;
        String pagina = "";
        RequisitoDAO objProyDAO = null;
        ArrayList lista = null;
        RequisitoBean  objProyBean = null;
        ProyectoDAO objProyecDAO=null;
        ProyectoBean objProyectoBean=null;
        switch(op)
        {
            case 1://Listar
            {
            
                objProyDAO = new RequisitoDAO();
                lista=objProyDAO.cargartablarequisito();
                request.setAttribute("lista", lista);
              pagina = "/Requisito/FrmRequisitoprincipal.jsp";
            }break;
            case 2://Pagina grabar
            {
                //para cargar el combobox con los datos del proyecto    
                objProyecDAO = new ProyectoDAO();
                lista=objProyecDAO.ProyectodeRequisito();
                request.setAttribute("lista1", lista);
                
                pagina = "/Requisito/FrmNuevoRequisito.jsp";
            }break;
            case 3://Nuevo
            {
                   objProyDAO = new RequisitoDAO();
                   numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    alcance= request.getParameter("txtalc");
                   personal = request.getParameter("txtper");
                   int per=Integer.parseInt(personal);
                   reunion= request.getParameter("txtreu");
                   int re=Integer.parseInt(reunion);
                   descripcion= request.getParameter("txtdes");
                   
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new RequisitoBean();
                    objProyBean.setNumero(num);
               objProyBean.setAlcance(alcance);
               objProyBean.setPersonal(per);
               objProyBean.setReunion(re);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setNUMPROY(proy);

              //para cargar el combobox con los datos del proyecto    
               objProyecDAO = new ProyectoDAO();
                lista=objProyecDAO.ProyectodeRequisito();
                request.setAttribute("lista1", lista);
       
                    int i = objProyDAO.grabarRequisito(objProyBean);
                   if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente(Grabar obligatoriamente el problema general del proyecto creado)");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    pagina = "/Requisito/FrmNuevoRequisito.jsp";
            }break;
            case 4://Salir
            {
          
                
                objProyDAO = new RequisitoDAO();
                lista = objProyDAO.cargartablarequisito();
                request.setAttribute("lista", lista);
                pagina = "/Requisito/FrmRequisitoprincipal.jsp";
            }break;
            case 5://Capturar Numero
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                
                
                //para cargar el combobox con los datos del proyecto cuando redireccione al jspmodificar    
                  objProyecDAO = new ProyectoDAO();
                lista=objProyecDAO.ProyectodeRequisito();
                request.setAttribute("lista1", lista);
                
              
                
                objProyDAO= new RequisitoDAO();
                objProyBean = new RequisitoBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarRequisito(objProyBean);
                request.setAttribute("DATOS",  objProyBean);
                pagina = "/Requisito/FrmModificarRequisito.jsp";
            }break;
                   
        
   
    
            case 6://Modificar nuevos datos
            {
                           numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    alcance= request.getParameter("txtalc");
                   personal = request.getParameter("txtper");
                   int per=Integer.parseInt(personal);
                   reunion= request.getParameter("txtreu");
                   int re=Integer.parseInt(reunion);
                   descripcion= request.getParameter("txtdes");
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
               
                    objProyBean = new RequisitoBean();
                    objProyDAO=new RequisitoDAO();
                    objProyBean.setNumero(num);
               objProyBean.setAlcance(alcance);
               objProyBean.setPersonal(per);
               objProyBean.setReunion(re);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setNUMPROY(proy);
               int i=objProyDAO.modificarRequisito(objProyBean);
               if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
              
                    
               objProyDAO = new RequisitoDAO();
                lista=objProyDAO.cargartablarequisito();
                request.setAttribute("lista", lista);
         
                pagina = "/Requisito/FrmRequisitoprincipal.jsp";
            }break;
            case 7://Eliminar
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new RequisitoDAO();
                objProyBean = new RequisitoBean();
                objProyBean.setNumero(numero1[0]);
                int  i= objProyDAO.eliminarRrequisito(objProyBean);
                
                lista = objProyDAO.cargartablarequisito();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                pagina = "/Requisito/FrmRequisitoprincipal.jsp";
            }break;
            
            //JSON
            case 8:{
                 objProyDAO=new RequisitoDAO();
      lista=objProyDAO.cargartablarequisito();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"requisito\":[");
          for(int i=0;i<lista.size();i++)
          {
           RequisitoBean  obj=(RequisitoBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"NUMERO\":\""+obj.getNumero()+"\",\"ALCANCE\":\""+obj.getAlcance()+"\",\"PERSONAL\":\""+obj.getPersonal()+"\",\"REUNIONES\":\""+obj.getReunion()+"\",\"DESCRIPCION\":\""+obj.getDescripcion()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"}");   
               }
               else
               {
               json.append("{\"NUMERO\":\""+obj.getNumero()+"\",\"ALCANCE\":\""+obj.getAlcance()+"\",\"PERSONAL\":\""+obj.getPersonal()+"\",\"REUNIONES\":\""+obj.getReunion()+"\",\"DESCRIPCION\":\""+obj.getDescripcion()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
            }break;
            //mostrar
              case 9:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objProyDAO=new RequisitoDAO();
                  
               lista=objProyDAO.cargartablarequisito();
            out.println("{\"requisito\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 10:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();

                objProyDAO = new RequisitoDAO();
    
                   numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    alcance= request.getParameter("txtalc");
                   personal = request.getParameter("txtper");
                   int per=Integer.parseInt(personal);
                   reunion= request.getParameter("txtreu");
                   int re=Integer.parseInt(reunion);
                   descripcion= request.getParameter("txtdes");
                   
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new RequisitoBean();
                    objProyBean.setNumero(num);
               objProyBean.setAlcance(alcance);
               objProyBean.setPersonal(per);
               objProyBean.setReunion(re);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setNUMPROY(proy);

               int i = objProyDAO.grabarRequisito(objProyBean);
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
                objProyDAO = new RequisitoDAO();
                      
                    objProyDAO = new RequisitoDAO();
                   numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    alcance= request.getParameter("txtalc");
                   personal = request.getParameter("txtper");
                   int per=Integer.parseInt(personal);
                   reunion= request.getParameter("txtreu");
                   int re=Integer.parseInt(reunion);
                   descripcion= request.getParameter("txtdes");
                   
                   numproy=request.getParameter("txtnumproy");
                   int proy=Integer.parseInt(numproy);
             
                    
                    objProyBean = new RequisitoBean();
                    objProyBean.setNumero(num);
               objProyBean.setAlcance(alcance);
               objProyBean.setPersonal(per);
               objProyBean.setReunion(re);
               objProyBean.setDescripcion(descripcion);
               objProyBean.setNUMPROY(proy);
//cargar combobox con datos del proyecto
  Gson gson= new Gson();
         int i = objProyDAO.modificarRequisito(objProyBean);
                 
         json=new StringBuilder();
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
                objProyDAO= new RequisitoDAO();
                objProyBean = new RequisitoBean();
                objProyBean.setNumero(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objProyDAO.eliminarRrequisito(objProyBean);
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
              //GENERAR CODIGO DE PROYECTO ANDROID
          objProyDAO=new RequisitoDAO();
           int i=objProyDAO.generarCodigo();
           PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
               
                  
              
            out.println("{\"NUMERO\":\"" +gson.toJson(i)+"\"}");
       }break;
         case 14:{
              //COMBO DE Proyecto EN ANDROID
                 objProyectoBean=new ProyectoBean();
                 objProyecDAO=new ProyectoDAO();
                  
               lista=objProyecDAO.ProyectodeRequisito();

      
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
       
       case 15:{
           
           //MOSTRAR DATOS PDF PROYECTO ANDROID
            String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new RequisitoDAO();
                objProyBean = new RequisitoBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarRequisito(objProyBean);
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
               json.append("{\"NUMERO\":\""+objProyBean.getNumero()+"\",\"ALCANCE\":\""+objProyBean.getAlcance()+"\",\"PERSONAL\":\""+objProyBean.getPersonal()+"\",\"REUNIONES\":\""+objProyBean.getReunion()+"\",\"DESCRIPCION\":\""+objProyBean.getDescripcion()+"\",\"NUMPROY\":\""+objProyBean.getNUMPROY()+"\"},");   
               
       
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
