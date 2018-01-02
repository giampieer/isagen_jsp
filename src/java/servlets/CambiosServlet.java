
package servlets;

import BEAN.CambiosBean;
import DAO.CambiosDAO;
import DAO.ProyectoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CambiosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             response.setContentType("application/json");
         StringBuilder json=null;
        response.setContentType("text/html;charset=UTF-8");
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        String fec,pro,imp,numproy;
        int num;
        String pagina = "";
        ArrayList lista = null;
        CambiosDAO objDAO = null;
        CambiosBean  objBean = null;
        ProyectoDAO objProyDAO=null;
        switch(op)
        {
            case 1://Listar
            {
                objDAO = new CambiosDAO();
                lista=objDAO.listarCambios1();
                request.setAttribute("lista", lista);               
                pagina="/Cambios/FrmCambiosMant.jsp";
            }break;
            case 2://Pagina grabar
            {
                //cargar combobox
                objProyDAO=new ProyectoDAO();
                lista=objProyDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/Cambios/FrmNuevoCambios.jsp";
            }break;
            case 3://Nuevo
            {
                objDAO = new CambiosDAO();
                    num = Integer.parseInt(request.getParameter("txtnum"));
                    fec = request.getParameter("txtfec");
                    pro = request.getParameter("txtpro");
                    imp = request.getParameter("txtimp");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    objBean = new CambiosBean();
                    objBean.setNUMERO(num);
                    objBean.setFECHA(fec);
                    objBean.setPROPOSITO(pro);
                    objBean.setIMPORTANCIA(imp);
                    objBean.setNUMPROY(proy);
                    int i = objDAO.grabarCambios(objBean);
                   if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    
                    //cargar combobox
                objProyDAO=new ProyectoDAO();
                lista=objProyDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                    
                    pagina = "/Cambios/FrmNuevoCambios.jsp";
            }break;
            case 4://Salir
            {
                objDAO = new CambiosDAO();
                lista=objDAO.listarCambios1();
                request.setAttribute("lista", lista);               
                pagina="/Cambios/FrmCambiosMant.jsp";
            }break;
            case 5://Capturar Numero
            {
                String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero[]=new  int[numeroCad.length];
                for(int i=0;i<numero.length;i++)
                {
                    numero[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objDAO = new CambiosDAO();
                objBean = new CambiosBean();
                objBean.setNUMERO(numero[0]);
                objBean=objDAO.CapturarCodigo(objBean);
                request.setAttribute("DATOS",  objBean);
                //cargar combobox
                objProyDAO=new ProyectoDAO();
                lista=objProyDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/Cambios/FrmModificarCambios.jsp";
            }break;
            case 6://Modificar
            {num = Integer.parseInt(request.getParameter("txtnum"));
                fec = request.getParameter("txtfec");
                pro = request.getParameter("txtpro");
                imp = request.getParameter("txtimp");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
                objDAO = new CambiosDAO();
                objBean = new CambiosBean();
                objBean.setNUMERO(num);
                objBean.setFECHA(fec);
                objBean.setPROPOSITO(pro);
                objBean.setIMPORTANCIA(imp);
                objBean.setNUMPROY(proy);
                int i=objDAO.modificarCambio(objBean);
                 lista=objDAO.listarCambios1();
                request.setAttribute("lista", lista);
                 if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
               
             
                
                pagina = "/Cambios/FrmCambiosMant.jsp";
            }break;
            case 7://Eliminar
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objDAO = new CambiosDAO();
                objBean = new CambiosBean();
                objBean.setNUMERO(numero1[0]);
                int  i= objDAO.eliminarCambios(objBean);
                objDAO = new CambiosDAO();
                lista = objDAO.listarCambios1();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                
                pagina = "/Cambios/FrmCambiosMant.jsp";
            }break;
            
            
            //PERSONAL
            case 8://mostrar tabla
            {
             numproy=request.getParameter("cod");
             int proy=Integer.parseInt(numproy);
                objBean=new CambiosBean();
                objDAO=new CambiosDAO();
               //mostrar tabla personal 
                objBean.setNUMPROY(proy);
                lista=objDAO.listarCambiosPersonal(objBean);
               //capturar numero pryecto
               request.setAttribute("numproy", objBean);
                request.setAttribute("lista",  lista);
                pagina = "/Cambios/FrmCambiosMantPersonal.jsp";
              }break;
              
              
              //redireccionar a grabar 
            case 9:{
                numproy=request.getParameter("cod");
                 int proy=Integer.parseInt(numproy);
                objBean=new CambiosBean();
                objBean.setNUMPROY(proy);
                request.setAttribute("numproy", objBean);
                 pagina = "/Cambios/FrmNuevoCambiosPersonal.jsp";
            }break;
            
            //grabar  personal
            case 10:{
                    objDAO = new CambiosDAO();
                num = Integer.parseInt(request.getParameter("txtnum"));
                    fec = request.getParameter("txtfec");
                    pro = request.getParameter("txtpro");
                    imp = request.getParameter("txtimp");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    objBean = new CambiosBean();
                    objBean.setNUMERO(num);
                    objBean.setFECHA(fec);
                    objBean.setPROPOSITO(pro);
                    objBean.setIMPORTANCIA(imp);
                    objBean.setNUMPROY(proy);
                    int i = objDAO.grabarCambios(objBean);
                     if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    //cargar el numero del proyecto 
                    CambiosBean objproy=null;
                    objproy=new  CambiosBean();
                    objproy.setNUMPROY(proy);
                 
                   request.setAttribute("numproy", objproy);
                    pagina = "/Cambios/FrmNuevoCambiosPersonal.jsp";
            }break;
            
            //modificar
            case 11:{
               num = Integer.parseInt(request.getParameter("txtnum"));
                fec = request.getParameter("txtfec");
                pro = request.getParameter("txtpro");
                imp = request.getParameter("txtimp");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
                objDAO = new CambiosDAO();
                objBean = new CambiosBean();
                objBean.setNUMERO(num);
                objBean.setFECHA(fec);
                objBean.setPROPOSITO(pro);
                objBean.setIMPORTANCIA(imp);
                objBean.setNUMPROY(proy);
                int i=objDAO.modificarCambio(objBean);
                 if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                
                //cargar proyecto
                CambiosBean objnumproy=null;
                objnumproy=new CambiosBean();
                objnumproy.setNUMPROY(proy);
                lista = objDAO.listarCambiosPersonal(objnumproy);
                
                
                request.setAttribute("lista", lista);
              
                 request.setAttribute("numproy", objnumproy);
                pagina = "/Cambios/FrmCambiosMantPersonal.jsp";
            }break;
            
            //capturar numero y redireccionar a modificar
            case 12 :{
                 String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero[]=new  int[numeroCad.length];
                for(int i=0;i<numero.length;i++)
                {
                    numero[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objDAO = new CambiosDAO();
                objBean = new CambiosBean();
                objBean.setNUMERO(numero[0]);
                objBean=objDAO.CapturarCodigo(objBean);
                request.setAttribute("DATOS",  objBean);
                
               
                pagina = "/Cambios/FrmModificarCambiosPersonal.jsp";
                
                
            }break;
            //eliminar
            case 13:{
                
                String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero[]=new  int[numeroCad.length];
                for(int i=0;i<numero.length;i++)
                {
                    numero[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objDAO = new CambiosDAO();
                objBean = new CambiosBean();
                CambiosBean obj=null;
                obj=new CambiosBean();
                
                objBean.setNUMERO(numero[0]);
              
                int  i= objDAO.eliminarCambios(objBean);
              int codproyecto=Integer.parseInt(request.getParameter("codproy"));
                obj.setNUMPROY(codproyecto);
                
                 lista=objDAO.listarCambiosPersonal(obj);
          
                request.setAttribute("lista",  lista);
               
                request.setAttribute("numproy", obj);
                
                   request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
              
                pagina = "/Cambios/FrmCambiosMantPersonal.jsp";
            }break;
            case 14:{
                objDAO=new CambiosDAO();
      lista=objDAO.listarCambios1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"cambios\":[");
          for(int i=0;i<lista.size();i++)
          {
           CambiosBean  obj=(CambiosBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"NUMERO\":\""+obj.getNUMERO()+"\",\"FECHA\":\""+obj.getFECHA()+"\",\"PROPOSITO\":\""+obj.getPROPOSITO()+"\",\"IMPORTANCIA\":\""+obj.getIMPORTANCIA()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"}");   
               }
               else
               {
               json.append("{\"NUMERO\":\""+obj.getNUMERO()+"\",\"FECHA\":\""+obj.getFECHA()+"\",\"PROPOSITO\":\""+obj.getPROPOSITO()+"\",\"IMPORTANCIA\":\""+obj.getIMPORTANCIA()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
                
                
                
                
            }break;
                        //mostrar
              case 15:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objDAO=new CambiosDAO();
                  
               lista=objDAO.listarCambios1();
            out.println("{\"cambios\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 16:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();
objDAO = new CambiosDAO();
                    num = Integer.parseInt(request.getParameter("txtnum"));
                    fec = request.getParameter("txtfec");
                    pro = request.getParameter("txtpro");
                    imp = request.getParameter("txtimp");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    objBean = new CambiosBean();
                    objBean.setNUMERO(num);
                    objBean.setFECHA(fec);
                    objBean.setPROPOSITO(pro);
                    objBean.setIMPORTANCIA(imp);
                    objBean.setNUMPROY(proy);
                    int i = objDAO.grabarCambios(objBean);
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
       num = Integer.parseInt(request.getParameter("txtnum"));
                fec = request.getParameter("txtfec");
                pro = request.getParameter("txtpro");
                imp = request.getParameter("txtimp");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
                objDAO = new CambiosDAO();
                objBean = new CambiosBean();
                objBean.setNUMERO(num);
                objBean.setFECHA(fec);
                objBean.setPROPOSITO(pro);
                objBean.setIMPORTANCIA(imp);
                objBean.setNUMPROY(proy);
                int i=objDAO.modificarCambio(objBean);
               Gson gson=new Gson();
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
                objDAO= new CambiosDAO();
                objBean = new CambiosBean();
                objBean.setNUMERO(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objDAO.eliminarCambios(objBean);
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se elimino}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se elimino}"));

                          }
               out.print(json.toString());
       }break;
            
        }
        
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
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

   