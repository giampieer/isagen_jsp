
package servlets;

import BEAN.InteresadosBean;
import DAO.InteresadosDAO;
import DAO.ProyectoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InteresadosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
              response.setContentType("application/json");
         StringBuilder json=null;
        
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        String nom,imp,nec,inte,numproy;
        int num;
        String pagina = "";
        ArrayList lista = null;
        InteresadosDAO objDAO = null;
        InteresadosBean  objBean = null;
        ProyectoDAO objProyDAO=null;
        switch(op)
        {
            case 1://Listar
            {
                objDAO = new InteresadosDAO();
                lista=objDAO.ListarInteresados1();
                request.setAttribute("lista", lista);               
                pagina="/Interesados/FrmInteresadosMant.jsp";
            }break;
            case 2://Pagina grabar
            {
                
                //cargra combobox
                objProyDAO=new ProyectoDAO();
                lista=objProyDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/Interesados/FrmNuevoInteresados.jsp";
            }break;
            case 3://Nuevo
            {
                    objDAO = new InteresadosDAO();
                    num = Integer.parseInt(request.getParameter("txtnum"));
                    nom = request.getParameter("txtnom");
                    imp = request.getParameter("txtimp");
                    nec = request.getParameter("txtnec");
                    inte = request.getParameter("txtinte");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    objBean = new InteresadosBean();
                    objBean.setNUMERO(num);
                    objBean.setNOMBRE(nom);
                    objBean.setIMPORTE(imp);
                    objBean.setNECESIDADES(nec);
                    objBean.setINTERES(inte);
                    objBean.setNUMPROY(proy);
                    int i = objDAO.InsertarInteresado(objBean);
                   if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    
                    
                    //cargra combobox
                objProyDAO=new ProyectoDAO();
                lista=objProyDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                
                    pagina = "/Interesados/FrmNuevoInteresados.jsp";
            }break;
            case 4://Salir
            {
                objDAO = new InteresadosDAO();
                lista = objDAO.ListarInteresados1();
                request.setAttribute("lista", lista);
                
                pagina = "/Interesados/FrmInteresadosMant.jsp";
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
                objDAO = new InteresadosDAO();
                objBean = new InteresadosBean();
                objBean.setNUMERO(numero[0]);
                objBean=objDAO.CapturarCodigo(objBean);
                request.setAttribute("DATOS",  objBean);
                //cargra combobox
                objProyDAO=new ProyectoDAO();
                lista=objProyDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/Interesados/FrmModificarInteresados.jsp";
            }break;
            case 6://Modificar
            {
                num = Integer.parseInt(request.getParameter("txtnum"));
                nom = request.getParameter("txtnom");
                imp = request.getParameter("txtimp");
                nec = request.getParameter("txtnec");
                inte = request.getParameter("txtinte");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
                objDAO = new InteresadosDAO();
                objBean = new InteresadosBean();
                objBean.setNUMERO(num);
                objBean.setNOMBRE(nom);
                objBean.setIMPORTE(imp);
                objBean.setNECESIDADES(nec);
                objBean.setINTERES(inte);
                objBean.setNUMPROY(proy);
                int i=objDAO.ModificarInteresados(objBean);
                objDAO = new InteresadosDAO();
                lista = objDAO.ListarInteresados1();
                request.setAttribute("lista", lista);
                if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                
                pagina = "/Interesados/FrmInteresadosMant.jsp";
            }break;
            case 7://Eliminar
            {
               String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objDAO = new InteresadosDAO();
                objBean = new InteresadosBean();
                objBean.setNUMERO(numero1[0]);
                int  i= objDAO.EliminarInteresados(objBean);
                objDAO = new InteresadosDAO();
                lista = objDAO.ListarInteresados1();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                
                pagina = "/Interesados/FrmInteresadosMant.jsp";
            }break;
            
            
            
             //PERSONAL
            case 8://mostrar tabla
            {
             numproy=request.getParameter("cod");
             int proy=Integer.parseInt(numproy);
                objBean=new InteresadosBean();
                objDAO=new InteresadosDAO();
               //mostrar tabla personal 
                objBean.setNUMPROY(proy);
                lista=objDAO.ListarInteresados1Personal(objBean);
               //capturar numero pryecto
               request.setAttribute("numproy", objBean);
                request.setAttribute("lista",  lista);
                pagina = "/Interesados/FrmInteresadosMantPersonal.jsp";
              }break;
              
              
              //redireccionar a grabar 
            case 9:{
                numproy=request.getParameter("cod");
                 int proy=Integer.parseInt(numproy);
                objBean=new InteresadosBean();
                objBean.setNUMPROY(proy);
                request.setAttribute("numproy", objBean);
                 pagina = "/Interesados/FrmNuevosInteresadosPersonal.jsp";
            }break;
            
            //grabar  personal
            case 10:{
                    objDAO = new InteresadosDAO();
                num = Integer.parseInt(request.getParameter("txtnum"));
                    nom = request.getParameter("txtnom");
                    imp = request.getParameter("txtimp");
                    nec = request.getParameter("txtnec");
                    inte = request.getParameter("txtinte");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    objBean = new InteresadosBean();
                    objBean.setNUMERO(num);
                    objBean.setNOMBRE(nom);
                    objBean.setIMPORTE(imp);
                    objBean.setNECESIDADES(nec);
                    objBean.setINTERES(inte);
                    objBean.setNUMPROY(proy);
                    int i = objDAO.InsertarInteresado(objBean);
                     if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    //cargar el numero del proyecto 
                    InteresadosBean objproy=null;
                    objproy=new  InteresadosBean();
                    objproy.setNUMPROY(proy);
                 
                   request.setAttribute("numproy", objproy);
                    pagina = "/Interesados/FrmNuevosInteresadosPersonal.jsp";
            }break;
            
            //modificar
            case 11:{
              num = Integer.parseInt(request.getParameter("txtnum"));
                nom = request.getParameter("txtnom");
                imp = request.getParameter("txtimp");
                nec = request.getParameter("txtnec");
                inte = request.getParameter("txtinte");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
                objDAO = new InteresadosDAO();
                objBean = new InteresadosBean();
                objBean.setNUMERO(num);
                objBean.setNOMBRE(nom);
                objBean.setIMPORTE(imp);
                objBean.setNECESIDADES(nec);
                objBean.setINTERES(inte);
                objBean.setNUMPROY(proy);
                int i=objDAO.ModificarInteresados(objBean);
                if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }                

//cargar proyecto
                InteresadosBean objnumproy=null;
                objnumproy=new InteresadosBean();
                objnumproy.setNUMPROY(proy);
                lista = objDAO.ListarInteresados1Personal(objnumproy);
                
                
                request.setAttribute("lista", lista);
            
                 request.setAttribute("numproy", objnumproy);
                pagina = "/Interesados/FrmInteresadosMantPersonal.jsp";
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
                objDAO = new InteresadosDAO();
                objBean = new InteresadosBean();
                objBean.setNUMERO(numero[0]);
                objBean=objDAO.CapturarCodigo(objBean);
                request.setAttribute("DATOS",  objBean);
                
               
                pagina = "/Interesados/FrmModificarInteresadosPersonal.jsp";
                
                
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
                objDAO = new InteresadosDAO();
                objBean = new InteresadosBean();
                InteresadosBean obj=null;
                obj=new InteresadosBean();
                
                objBean.setNUMERO(numero[0]);
               
                int  i= objDAO.EliminarInteresados(objBean);
                
 int codproyecto=Integer.parseInt(request.getParameter("codproy"));
                obj.setNUMPROY(codproyecto);
                
                 lista=objDAO.ListarInteresados1Personal(obj);
          
                request.setAttribute("lista",  lista);
               
                request.setAttribute("numproy", obj);                
               request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                request.setAttribute("numproy", objBean);
                          pagina = "/Interesados/FrmInteresadosMantPersonal.jsp";
            }break;
            
            
            
            case 14:{
                
                  
                 objDAO=new  InteresadosDAO();
      lista=objDAO.ListarInteresados1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"interesados\":[");
          for(int i=0;i<lista.size();i++)
          {
           InteresadosBean  obj=(InteresadosBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"NUMERO\":\""+obj.getNUMERO()+"\",\"NOMBRE\":\""+obj.getNOMBRE()+"\",\"IMPORTE\":\""+obj.getIMPORTE()+"\",\"NECESIDADES\":\""+obj.getNECESIDADES()+"\",\"INTERES\":\""+obj.getINTERES()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"}");   
               }
               else
               {
               json.append("{\"NUMERO\":\""+obj.getNUMERO()+"\",\"NOMBRE\":\""+obj.getNOMBRE()+"\",\"IMPORTE\":\""+obj.getIMPORTE()+"\",\"NECESIDADES\":\""+obj.getNECESIDADES()+"\",\"INTERES\":\""+obj.getINTERES()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
                
                
            }break;
            
                        //mostrar
              case 15:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objDAO=new InteresadosDAO();
                  
               lista=objDAO.ListarInteresados1();
            out.println("{\"interesados\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 16:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();

                objDAO = new InteresadosDAO();
                    num = Integer.parseInt(request.getParameter("txtnum"));
                    nom = request.getParameter("txtnom");
                    imp = request.getParameter("txtimp");
                    nec = request.getParameter("txtnec");
                    inte = request.getParameter("txtinte");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    objBean = new InteresadosBean();
                    objBean.setNUMERO(num);
                    objBean.setNOMBRE(nom);
                    objBean.setIMPORTE(imp);
                    objBean.setNECESIDADES(nec);
                    objBean.setINTERES(inte);
                    objBean.setNUMPROY(proy);
                    int i = objDAO.InsertarInteresado(objBean);
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
                nom = request.getParameter("txtnom");
                imp = request.getParameter("txtimp");
                nec = request.getParameter("txtnec");
                inte = request.getParameter("txtinte");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
                objDAO = new InteresadosDAO();
                objBean = new InteresadosBean();
                objBean.setNUMERO(num);
                objBean.setNOMBRE(nom);
                objBean.setIMPORTE(imp);
                objBean.setNECESIDADES(nec);
                objBean.setINTERES(inte);
                objBean.setNUMPROY(proy);
                int i=objDAO.ModificarInteresados(objBean);
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
                objDAO= new InteresadosDAO();
                objBean= new InteresadosBean();
                objBean.setNUMERO(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objDAO.EliminarInteresados(objBean);
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

