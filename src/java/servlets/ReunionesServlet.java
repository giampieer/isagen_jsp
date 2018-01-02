
package servlets;

import BEAN.ReunionesBean;
import DAO.ProyectoDAO;
import DAO.ReunionesDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReunionesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
         StringBuilder json=null;
        
         String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        String per,fec,acu,reu,dur,numproy;
        int num;
        String pagina = "";
        ArrayList lista = null;
        ReunionesDAO objReunionesDAO = null;
        ReunionesBean  objReunionesBean = null;
        ProyectoDAO objDAO=new ProyectoDAO();
        switch(op)
        {
            case 1://Listar
            {
                objReunionesDAO = new ReunionesDAO();
                lista=objReunionesDAO.ListarReuniones1();
                request.setAttribute("lista", lista);               
                pagina="/Reuniones/FrmReunionesMant.jsp";
            }break;
            case 2://Pagina grabar
            {
                //cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/Reuniones/FrmNuevoReuniones.jsp";
            }break;
            case 3://Nuevo
            {
                objReunionesDAO = new ReunionesDAO();
                    num = Integer.parseInt(request.getParameter("txtnum"));
                    per = request.getParameter("txtper");
                    fec = request.getParameter("txtfec");
                    acu = request.getParameter("txtacu");
                    reu = request.getParameter("txtreu");
                    dur = request.getParameter("txtdur");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    
                    objReunionesBean = new ReunionesBean();
                    objReunionesBean.setNUMERO(num);
                    objReunionesBean.setPERSONAL(per);
                    objReunionesBean.setFECHA(fec);
                    objReunionesBean.setACUERDOS(acu);
                    objReunionesBean.setREUNION(reu);
                    objReunionesBean.setDURACION(dur);
                    objReunionesBean.setNUMPROY(proy);
                    int i = objReunionesDAO.InsertarReuniones(objReunionesBean);
                    if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    
                    
                    //cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                    pagina = "/Reuniones/FrmNuevoReuniones.jsp";
            }break;
            case 4://Salir
            {
                objReunionesDAO = new ReunionesDAO();
                lista = objReunionesDAO.ListarReuniones1();
                request.setAttribute("lista", lista);
                
                pagina = "/Reuniones/FrmReunionesMant.jsp";
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
                objReunionesDAO = new ReunionesDAO();
                objReunionesBean = new ReunionesBean();
                objReunionesBean.setNUMERO(numero[0]);
                objReunionesBean=objReunionesDAO.CapturarCodigo(objReunionesBean);
                request.setAttribute("DATOS",  objReunionesBean);
                
                //cargar combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1", lista);
                pagina = "/Reuniones/FrmModificarReuniones.jsp";
            }break;
            case 6://Modificar
            {
                num = Integer.parseInt(request.getParameter("txtnum"));
                per = request.getParameter("txtper");
                fec = request.getParameter("txtfec");
                acu = request.getParameter("txtacu");
                reu = request.getParameter("txtreu");
                dur = request.getParameter("txtdur");
                 numproy=request.getParameter("txtnumproy");
                 int proy=Integer.parseInt(numproy);
                objReunionesDAO = new ReunionesDAO();
                objReunionesBean = new ReunionesBean();
                objReunionesBean.setNUMERO(num);
                objReunionesBean.setPERSONAL(per);
                objReunionesBean.setFECHA(fec);
                objReunionesBean.setACUERDOS(acu);
                objReunionesBean.setREUNION(reu);
                objReunionesBean.setDURACION(dur);
                objReunionesBean.setNUMPROY(proy);
                int i=objReunionesDAO.ModificarReuniones(objReunionesBean);
                objReunionesDAO = new ReunionesDAO();
                lista = objReunionesDAO.ListarReuniones1();
                request.setAttribute("lista", lista);
               if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                pagina = "/Reuniones/FrmReunionesMant.jsp";
            }break;
            case 7://Eliminar
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objReunionesDAO = new ReunionesDAO();
                objReunionesBean = new ReunionesBean();
                objReunionesBean.setNUMERO(numero1[0]);
                int  i= objReunionesDAO.EliminarReuniones(objReunionesBean);
                objReunionesDAO = new ReunionesDAO();
                lista = objReunionesDAO.ListarReuniones1();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                
                pagina = "/Reuniones/FrmReunionesMant.jsp";
            }break;
            
            
            
            //PERSONAL
            case 8://mostrar tabla
            {
             numproy=request.getParameter("cod");
             int proy=Integer.parseInt(numproy);
                objReunionesBean=new ReunionesBean();
                objReunionesDAO=new ReunionesDAO();
               //mostrar tabla personal 
                objReunionesBean.setNUMPROY(proy);
                lista=objReunionesDAO.ListarReuniones1Personal(objReunionesBean);
               //capturar numero pryecto
               request.setAttribute("numproy", objReunionesBean);
                request.setAttribute("lista",  lista);
                pagina = "/Reuniones/FrmReunionesMantPersonal.jsp";
              }break;
              
              
              //redireccionar a grabar 
            case 9:{
                numproy=request.getParameter("cod");
                 int proy=Integer.parseInt(numproy);
                objReunionesBean=new ReunionesBean();
                objReunionesBean.setNUMPROY(proy);
                request.setAttribute("numproy", objReunionesBean);
                 pagina = "/Reuniones/FrmNuevoReunionesPersonal.jsp";
            }break;
            
            //grabar  personal
            case 10:{
                    objReunionesDAO = new ReunionesDAO();
                    num = Integer.parseInt(request.getParameter("txtnum"));
                    per = request.getParameter("txtper");
                    fec = request.getParameter("txtfec");
                    acu = request.getParameter("txtacu");
                    reu = request.getParameter("txtreu");
                    dur = request.getParameter("txtdur");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    
                    objReunionesBean = new ReunionesBean();
                    objReunionesBean.setNUMERO(num);
                    objReunionesBean.setPERSONAL(per);
                    objReunionesBean.setFECHA(fec);
                    objReunionesBean.setACUERDOS(acu);
                    objReunionesBean.setREUNION(reu);
                    objReunionesBean.setDURACION(dur);
                    objReunionesBean.setNUMPROY(proy);
                    int i = objReunionesDAO.InsertarReuniones(objReunionesBean);
                      if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    //cargar el numero del proyecto 
                    ReunionesBean objproy=null;
                    objproy=new ReunionesBean();
                    objproy.setNUMPROY(proy);
                   
                   request.setAttribute("numproy", objproy);
                    pagina = "/Reuniones/FrmNuevoReunionesPersonal.jsp";
            }break;
            
            //modificar
            case 11:{
                num = Integer.parseInt(request.getParameter("txtnum"));
                per = request.getParameter("txtper");
                fec = request.getParameter("txtfec");
                acu = request.getParameter("txtacu");
                reu = request.getParameter("txtreu");
                dur = request.getParameter("txtdur");
                 numproy=request.getParameter("txtnumproy");
                 int proy=Integer.parseInt(numproy);
                objReunionesDAO = new ReunionesDAO();
                objReunionesBean = new ReunionesBean();
                objReunionesBean.setNUMERO(num);
                objReunionesBean.setPERSONAL(per);
                objReunionesBean.setFECHA(fec);
                objReunionesBean.setACUERDOS(acu);
                objReunionesBean.setREUNION(reu);
                objReunionesBean.setDURACION(dur);
                objReunionesBean.setNUMPROY(proy);
                int i=objReunionesDAO.ModificarReuniones(objReunionesBean);
                  if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                //cargar proyecto
                ReunionesBean objnumproy=null;
                objnumproy=new ReunionesBean();
                objnumproy.setNUMPROY(proy);
                lista = objReunionesDAO.ListarReuniones1Personal(objnumproy);
           request.setAttribute("lista", lista);
               
                 request.setAttribute("numproy", objnumproy);
                pagina = "/Reuniones/FrmReunionesMantPersonal.jsp";
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
                objReunionesDAO = new ReunionesDAO();
                objReunionesBean = new ReunionesBean();
                objReunionesBean.setNUMERO(numero[0]);
                objReunionesBean=objReunionesDAO.CapturarCodigo(objReunionesBean);
                request.setAttribute("DATOS",  objReunionesBean);
                
               
                pagina = "/Reuniones/FrmModificarReunionesPersonal.jsp";
                
                
            }break;
            
            case 13:{
                
                String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero[]=new  int[numeroCad.length];
                for(int i=0;i<numero.length;i++)
                {
                    numero[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objReunionesDAO = new ReunionesDAO();
                objReunionesBean = new ReunionesBean();
                ReunionesBean obj=null;
                obj=new ReunionesBean();
                
                objReunionesBean.setNUMERO(numero[0]);
              
                int  i= objReunionesDAO.EliminarReuniones(objReunionesBean);
                
                int codproyecto=Integer.parseInt(request.getParameter("codproy"));
                obj.setNUMPROY(codproyecto);
                
                 lista=objReunionesDAO.ListarReuniones1Personal(obj);
          
                request.setAttribute("lista",  lista);
               
                request.setAttribute("numproy", obj);
                 request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                pagina = "/Reuniones/FrmReunionesMantPersonal.jsp";
            }break;
            //mostrar json
            case 14:{
                 objReunionesDAO=new ReunionesDAO();
      lista=objReunionesDAO.ListarReuniones1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"reuniones\":[");
          for(int i=0;i<lista.size();i++)
          {
           ReunionesBean  obj=(ReunionesBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"NUMERO\":\""+obj.getNUMERO()+"\",\"PERSONAL\":\""+obj.getPERSONAL()+"\",\"FECHA\":\""+obj.getFECHA()+"\",\"ACUERDOS\":\""+obj.getACUERDOS()+"\",\"REUNION\":\""+obj.getREUNION()+"\",\"DURACION\":\""+obj.getDURACION()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"}");   
               }
               else
               {
               json.append("{\"NUMERO\":\""+obj.getNUMERO()+"\",\"PERSONAL\":\""+obj.getPERSONAL()+"\",\"FECHA\":\""+obj.getFECHA()+"\",\"ACUERDOS\":\""+obj.getACUERDOS()+"\",\"REUNION\":\""+obj.getREUNION()+"\",\"DURACION\":\""+obj.getDURACION()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
            
                
                
            }break;
            
                        //mostrar
              case 15:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objReunionesDAO=new ReunionesDAO();
                  
               lista=objReunionesDAO.ListarReuniones1();
            out.println("{\"reuniones\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 16:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();

                 objReunionesDAO = new ReunionesDAO();
                    num = Integer.parseInt(request.getParameter("txtnum"));
                    per = request.getParameter("txtper");
                    fec = request.getParameter("txtfec");
                    acu = request.getParameter("txtacu");
                    reu = request.getParameter("txtreu");
                    dur = request.getParameter("txtdur");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    
                    objReunionesBean = new ReunionesBean();
                    objReunionesBean.setNUMERO(num);
                    objReunionesBean.setPERSONAL(per);
                    objReunionesBean.setFECHA(fec);
                    objReunionesBean.setACUERDOS(acu);
                    objReunionesBean.setREUNION(reu);
                    objReunionesBean.setDURACION(dur);
                    objReunionesBean.setNUMPROY(proy);
                    int i = objReunionesDAO.InsertarReuniones(objReunionesBean);
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
                per = request.getParameter("txtper");
                fec = request.getParameter("txtfec");
                acu = request.getParameter("txtacu");
                reu = request.getParameter("txtreu");
                dur = request.getParameter("txtdur");
                 numproy=request.getParameter("txtnumproy");
                 int proy=Integer.parseInt(numproy);
                objReunionesDAO = new ReunionesDAO();
                objReunionesBean = new ReunionesBean();
                objReunionesBean.setNUMERO(num);
                objReunionesBean.setPERSONAL(per);
                objReunionesBean.setFECHA(fec);
                objReunionesBean.setACUERDOS(acu);
                objReunionesBean.setREUNION(reu);
                objReunionesBean.setDURACION(dur);
                objReunionesBean.setNUMPROY(proy);
                int i=objReunionesDAO.ModificarReuniones(objReunionesBean);
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
                objReunionesDAO= new ReunionesDAO();
                objReunionesBean = new ReunionesBean();
                objReunionesBean.setNUMERO(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objReunionesDAO.EliminarReuniones(objReunionesBean);
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

