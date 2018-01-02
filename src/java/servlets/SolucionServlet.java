package servlets;

import BEAN.RiesgosBean;
import BEAN.SolucionBean;
import DAO.ProyectoDAO;
import DAO.RiesgosDAO;
import DAO.SolucionDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SolucionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        
             response.setContentType("application/json");
         StringBuilder json=null;
        int  num;
        String numero,nivel,descripcion,numriesgo,numproy;
        String pagina = "";
        SolucionDAO objProyDAO = null;
        ArrayList lista = null;
        SolucionBean  objProyBean = null;
        RiesgosDAO objRiesgoDAO=null;
        switch(op)
        {
            case 1://Listar
            {
                objProyDAO = new SolucionDAO();
                lista=objProyDAO.cargartablasolucion1();
                request.setAttribute("lista", lista);
                pagina = "/Solucion/FrmSolucionprincipal.jsp";
               
            }break;
            case 2://Pagina grabar
            {
                //CARGAR COMBOBOX DE  RIESGO
                objRiesgoDAO=new  RiesgosDAO();
                lista=objRiesgoDAO.cargartablariesgos1();
                request.setAttribute("lista1", lista);
               
                pagina = "/Solucion/FrmNuevoSolucion.jsp";
            }break;
            case 3://Nuevo
            {
                objProyDAO = new SolucionDAO();
                      
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel = request.getParameter("txtniv");
                    descripcion = request.getParameter("txtdes");
                    numriesgo=request.getParameter("txtnumriesgo");
                    int ries=Integer.parseInt(numriesgo);
               objProyBean = new SolucionBean();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripción(descripcion);
               objProyBean.setNUMRIESGO(ries);
               
                    int i = objProyDAO.grabarsolucion(objProyBean);
                   if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }
                    
                   //CARGAR COMBOBOX DE  RIESGO
                objRiesgoDAO=new  RiesgosDAO();
                lista=objRiesgoDAO.cargartablariesgos1();
                request.setAttribute("lista1", lista);
                    pagina = "/Solucion/FrmNuevoSolucion.jsp";
            }break;
            case 4://Salir
            {
                objProyDAO = new SolucionDAO();
                lista = objProyDAO.cargartablasolucion1();
                request.setAttribute("lista", lista);
                pagina = "/Solucion/FrmSolucionprincipal.jsp";
            }break;
            case 5://Capturar Numero
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new SolucionDAO();
                objProyBean = new SolucionBean();
                objProyBean.setNumero(numero1[0]);
                objProyBean=objProyDAO.CapturarSolucion(objProyBean);
                request.setAttribute("DATOS",  objProyBean);
                
                //CARGAR COMBOBOX DE  RIESGO
                objRiesgoDAO=new  RiesgosDAO();
                lista=objRiesgoDAO.cargartablariesgos1();
                request.setAttribute("lista1", lista);
                
                pagina = "/Solucion/FrmModificarSolucion.jsp";
            }break;
                   
            case 6://Modificar nuevos datos
            {
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel = request.getParameter("txtniv");
                    descripcion = request.getParameter("txtdes");
                    numriesgo=request.getParameter("txtnumriesgo");
                    int ries=Integer.parseInt(numriesgo);
                    objProyBean = new SolucionBean();
                    objProyDAO=new SolucionDAO();
                    objProyBean.setNumero(num);
                    objProyBean.setNivel(nivel);
                    objProyBean.setDescripción(descripcion);
                    objProyBean.setNUMRIESGO(ries);
                 
                int i=objProyDAO.modificarsolucion(objProyBean);
                lista=objProyDAO.cargartablasolucion1();
                request.setAttribute("lista", lista);
                 if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                pagina = "/Solucion/FrmSolucionprincipal.jsp";
            }break;
            case 7://Eliminar
            {
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new SolucionDAO();
                objProyBean = new SolucionBean();
                objProyBean.setNumero(numero1[0]);
                int  i= objProyDAO.eliminarsolucion(objProyBean);
                
                lista = objProyDAO.cargartablasolucion1();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                pagina = "/Solucion/FrmSolucionprincipal.jsp";
            }break;
            
            
            //PERSONAL
            case 8://mostrar tabla
            {
             numproy=request.getParameter("cod");
             int proy=Integer.parseInt(numproy);
                objProyBean=new SolucionBean();
                objProyDAO=new SolucionDAO();
               //mostrar tabla personal 
                objProyBean.setNUMPROY(proy);
                lista=objProyDAO.cargartablasolucion1Personal(objProyBean);
               //capturar numero pryecto
               request.setAttribute("numproy", objProyBean);
                request.setAttribute("lista",  lista);
                pagina = "/Solucion/FrmSolucionMantPersonal.jsp";
              }break;
              
            case 9:{
                
                 objProyDAO=new SolucionDAO();
      lista=objProyDAO.cargartablasolucion1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"solucion\":[");
          for(int i=0;i<lista.size();i++)
          {
           SolucionBean  obj=(SolucionBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"numero\":\""+obj.getNumero()+"\",\"nivel\":\""+obj.getNivel()+"\",\"descripcion\":\""+obj.getDescripción()+"\",\"NUMRIESGO\":\""+obj.getNUMRIESGO()+"\"}");   
               }
               else
               {
               json.append("{\"numero\":\""+obj.getNumero()+"\",\"nivel\":\""+obj.getNivel()+"\",\"descripcion\":\""+obj.getDescripción()+"\",\"NUMRIESGO\":\""+obj.getNUMRIESGO()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
                
                
                
            }break;
              
              
                          //mostrar
              case 10:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objProyDAO=new SolucionDAO();
                  
               lista=objProyDAO.cargartablasolucion1();
            out.println("{\"solucion\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 11:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();
  objProyDAO = new SolucionDAO();
                      
                    numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel = request.getParameter("txtniv");
                    descripcion = request.getParameter("txtdes");
                    numriesgo=request.getParameter("txtnumriesgo");
                    int ries=Integer.parseInt(numriesgo);
               objProyBean = new SolucionBean();
               objProyBean.setNumero(num);
               objProyBean.setNivel(nivel);
               objProyBean.setDescripción(descripcion);
               objProyBean.setNUMRIESGO(ries);
               
                    int i = objProyDAO.grabarsolucion(objProyBean);
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se ingreso}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se ingreso}"));

                          }
                  out.print(json.toString());
                  //http://localhost:8084/ProyectoGestion/ProyectoServlet?op=11&txtnum=5&txttit=sadsa&txtdur=adsa&txtdes=ssds&txttip=asa&txtcan=sdsd&txtini=saas&txtfin=asas&txtpre=sds&txtcodjefe=4
              }break;
              
              //modificar
       case 12:{
           PrintWriter out = response.getWriter();
         json=new StringBuilder();   
                numero = request.getParameter("txtnum");
                    num=Integer.parseInt(numero);
                    nivel = request.getParameter("txtniv");
                    descripcion = request.getParameter("txtdes");
                    numriesgo=request.getParameter("txtnumriesgo");
                    int ries=Integer.parseInt(numriesgo);
                    objProyBean = new SolucionBean();
                    objProyDAO=new SolucionDAO();
                    objProyBean.setNumero(num);
                    objProyBean.setNivel(nivel);
                    objProyBean.setDescripción(descripcion);
                    objProyBean.setNUMRIESGO(ries);
                 
                int i=objProyDAO.modificarsolucion(objProyBean);
//cargar combobox con datos del proyecto
  Gson gson= new Gson();
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se modifico}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se modifico}"));

                  }
                  out.print(json.toString());
       }break;
       case 13:{
               String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objProyDAO= new SolucionDAO();
                objProyBean = new SolucionBean();
                objProyBean.setNumero(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objProyDAO.eliminarsolucion(objProyBean);
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
