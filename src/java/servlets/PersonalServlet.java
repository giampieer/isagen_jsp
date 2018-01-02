
package servlets;

import BEAN.ObjetivoBean;
import BEAN.PersonalBean;
import BEAN.ProblemaBean;
import BEAN.ProyectoBean;
import BEAN.RequisitoBean;
import DAO.ObjetivoDAO;
import DAO.PersonalDAO;
import DAO.ProblemaDAO;
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
import javax.servlet.http.HttpSession;
import modelo.Email;
import org.apache.commons.codec.digest.DigestUtils;


public class PersonalServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession respuesta = request.getSession(true);
         response.setContentType("application/json");
         StringBuilder json=null;
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        String nom,ema,tel,hor,dia,id,pass,numproy;
        int cod;
        String pagina = "";
        ArrayList lista = null;
        PersonalDAO objPersoDAO = null;
        PersonalBean  objPersoBean = null;
        ProyectoDAO objDAO=null;
        switch(op)
        {
            case 1://Listar
            {
                objPersoDAO = new PersonalDAO();
                lista=objPersoDAO.ListarPersonal1();
                request.setAttribute("lista", lista);               
                pagina="/personal/FrmPersonalMant.jsp";
            }break;
            case 2://Pagina grabar
            {
                //carga combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1",lista);
                pagina = "/personal/FrmNuevoPersonal.jsp";
            }break;
            case 3://Nuevo
            {
                objPersoDAO = new PersonalDAO();
                    cod = Integer.parseInt(request.getParameter("txtcod"));
                    nom = request.getParameter("txtnom");
                    ema = request.getParameter("txtema");
                    tel = request.getParameter("txttel");
                    hor = request.getParameter("txthor");
                    dia = request.getParameter("txtdia");
                     id = request.getParameter("txtid");
                      pass = request.getParameter("txtpass");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    
                    String passencriptado=DigestUtils.md5Hex(pass);
                    objPersoBean = new PersonalBean();
                    objPersoBean.setCODPERSONAL(cod);
                    objPersoBean.setNOMBPERSONAL(nom);
                    objPersoBean.setEMAPERSONAL(ema);
                    objPersoBean.setTELFPERSONAL(tel);
                    objPersoBean.setHORAS(hor);
                    objPersoBean.setDIAS(dia);
                    objPersoBean.setID(id);
                    objPersoBean.setPASS(passencriptado);
                    objPersoBean.setNUMPROY(proy);
                    
                    int i = objPersoDAO.InsertarPersonal(objPersoBean);
                   if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }                    
                    //cargar combobox
                    objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1",lista);
                
                    pagina = "/personal/FrmNuevoPersonal.jsp";
            }break;
            case 4://Salir
            {
                objPersoDAO = new PersonalDAO();
                lista = objPersoDAO.ListarPersonal1();
                request.setAttribute("lista", lista);
                
                pagina = "/personal/FrmPersonalMant.jsp";
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
                objPersoDAO = new PersonalDAO();
                objPersoBean = new PersonalBean();
                objPersoBean.setCODPERSONAL(numero[0]);
                objPersoBean=objPersoDAO.CapturarCodigo(objPersoBean);
                request.setAttribute("DATOS",  objPersoBean);
                
                //carga combobox
                objDAO=new ProyectoDAO();
                lista=objDAO.cargartablaproyecto();
                request.setAttribute("lista1",lista);
                
                pagina = "/personal/FrmModificarPersonal.jsp";
            }break;
            case 6://Modificar
            {
                cod = Integer.parseInt(request.getParameter("txtcod"));
                nom = request.getParameter("txtnom");
                ema = request.getParameter("txtema");
                tel = request.getParameter("txttel");
                hor = request.getParameter("txthor");
                dia = request.getParameter("txtdia");
                 id = request.getParameter("txtid");
                 pass = request.getParameter("txtpass");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
                
                objPersoDAO = new PersonalDAO();
                objPersoBean = new PersonalBean();
                objPersoBean.setCODPERSONAL(cod);
                objPersoBean.setNOMBPERSONAL(nom);
                objPersoBean.setEMAPERSONAL(ema);
                objPersoBean.setTELFPERSONAL(tel);
                objPersoBean.setHORAS(hor);
                objPersoBean.setDIAS(dia);
                
                  objPersoBean.setID(id);
                  objPersoBean.setPASS(pass);
                  objPersoBean.setNUMPROY(proy);
                int i=objPersoDAO.ModificarPersonal(objPersoBean);
                if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                objPersoDAO = new PersonalDAO();
                lista = objPersoDAO.ListarPersonal1();
                request.setAttribute("lista", lista);
                pagina = "/personal/FrmPersonalMant.jsp";
            }break;
            case 7://Eliminar
            {
                 String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objPersoDAO= new PersonalDAO();
                objPersoBean = new PersonalBean();
                objPersoBean.setCODPERSONAL(numero1[0]);
                int  i= objPersoDAO.EliminarPersonal(objPersoBean);
                
                lista = objPersoDAO.ListarPersonal1();
                request.setAttribute("lista", lista);
                request.setAttribute("ELIMINAR",""+i);
                
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
                 pagina = "/personal/FrmPersonalMant.jsp";
            }break;
            
            
            
             case 8:// login sin capturar sin seguridad
            {
                String usu=request.getParameter("txtcontra");
                String clave=request.getParameter("txtnombre").toUpperCase();
                PersonalBean objUsuBean=new PersonalBean();
                objUsuBean.setPASS(usu);
                objUsuBean.setID(clave);
                PersonalDAO
                objUsuDAO=new PersonalDAO();
               int estado=objUsuDAO.ValidarAcceso(objUsuBean);
                if(estado==1)
                {
                    
                    
                    pagina="/menu1ajax.jsp";
                    respuesta.setAttribute("usu", clave);
                }else
                {
                    pagina="/loginpersonalboot.jsp";
                    request.setAttribute("mensaje","Datos Incorrectos , vuelva Ingresar correctamente");
                }
            }break;
            

          //seguridad
            case 9:
            {
                
                String usu=request.getParameter("txtcontra");
                String clave=request.getParameter("txtnombre");
                PersonalBean objJefeBean1=new PersonalBean();
               objJefeBean1.setID(clave);
               objJefeBean1.setPASS(usu);
               
                PersonalDAO objUsuDAO=new PersonalDAO();
                
               objPersoBean=objUsuDAO.capturarDatosUsuario1(objJefeBean1);
             
                
                if(objPersoBean!=null)
                {
                    request.setAttribute("cargar", objPersoBean);
                    pagina="/inicio/menu1ajax.jsp";
                }else
                {
                    pagina="/Seguridad/loginpersonalboot.jsp";
                    request.setAttribute("mensaje","Datos Incorrectos , vuelva Ingresar correctamente");
                }
                }
                break;
                case 10://Capturar Numero para login
            {
                String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero[]=new  int[numeroCad.length];
                for(int i=0;i<numero.length;i++)
                {
                    numero[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objPersoDAO = new PersonalDAO();
                objPersoBean = new PersonalBean();
                objPersoBean.setCODPERSONAL(numero[0]);
                objPersoBean=objPersoDAO.CapturarCodigo(objPersoBean);
                request.setAttribute("DATOS",  objPersoBean);
                pagina = "/personal/FrmModifcarPersonalLogin.jsp";
            }break;
                case 11://Modificar el login de datos personales
            {
                cod = Integer.parseInt(request.getParameter("txtcod"));
                nom = request.getParameter("txtnom");
                ema = request.getParameter("txtema");
                tel = request.getParameter("txttel");
                hor = request.getParameter("txthoras");
                dia = request.getParameter("txtdias");
                 id = request.getParameter("txtid");
                 pass = request.getParameter("txtpass");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
                
                
                objPersoDAO = new PersonalDAO();
                objPersoBean = new PersonalBean();
                objPersoBean.setCODPERSONAL(cod);
                objPersoBean.setNOMBPERSONAL(nom);
                objPersoBean.setEMAPERSONAL(ema);
                objPersoBean.setTELFPERSONAL(tel);
                objPersoBean.setHORAS(hor);
                objPersoBean.setDIAS(dia);
                objPersoBean.setID(id);
                objPersoBean.setPASS(pass);
                objPersoBean.setNUMPROY(proy);
                
                int i= objPersoDAO.ModificarPersonal(objPersoBean);
                if(i == 1){
                request.setAttribute("mensaje","Informacion del Personal Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Informacion del Personal No Modificado");  
                }
                objPersoDAO = new PersonalDAO();
                  
                lista = objPersoDAO.ListarPersonal1();
                request.setAttribute("lista", lista);
                
               
                 request.setAttribute("DATOS",objPersoBean);
                pagina = "/personal/FrmModifcarPersonalLogin.jsp";
            }break;
                case 12 :{ //para redireccionar al proncipal
                    pagina="/inicio/carrusel.jsp";
           }break;
                
                
                case 13:{//modificar la clave del loginperosnal

                 String nuevo,actual;
                cod = Integer.parseInt(request.getParameter("txtcod"));
                nom = request.getParameter("txtnom");
                ema = request.getParameter("txtema");
                tel = request.getParameter("txttel");
                hor = request.getParameter("txthoras");
                dia = request.getParameter("txtdias");
                 id = request.getParameter("txtid");
                 pass = request.getParameter("txtpass");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
                actual=request.getParameter("txtactual");
                nuevo=request.getParameter("txtnuevo");
                
                        String nuevoencriptado=DigestUtils.md5Hex(nuevo);
                 String actualencriptado=DigestUtils.md5Hex(actual);
                objPersoDAO = new PersonalDAO();
                objPersoBean = new PersonalBean();
                objPersoBean.setCODPERSONAL(cod);
                objPersoBean.setNOMBPERSONAL(nom);
                objPersoBean.setEMAPERSONAL(ema);
                objPersoBean.setTELFPERSONAL(tel);
                objPersoBean.setHORAS(hor);
                objPersoBean.setDIAS(dia);
                objPersoBean.setNUMPROY(proy);
                  objPersoBean.setID(id);
                  objPersoBean.setPASS(nuevoencriptado);
                 int i=0;
              if(pass.equals(actualencriptado)){
                       i=objPersoDAO.ModificarPersonal(objPersoBean);
              if(i == 1){
                request.setAttribute("mensaje","Contraseña Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Contraseña  no Modificado");  
                }
                          request.setAttribute("DATOS",objPersoBean);
                pagina="/personal/FrmModificarClavePersonal.jsp";                   }
              else{
                        
         
               request.setAttribute("mensaje","Contraseña  no Modificado");  
                                  request.setAttribute("DATOS",objPersoBean);
                        pagina="/personal/FrmModificarClavePersonal.jsp";
                   }
        }break;
                
                case 14://Capturar codigo para modificar la clave
                {
                String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero[]=new  int[numeroCad.length];
                for(int i=0;i<numero.length;i++)
                {
                    numero[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objPersoDAO = new PersonalDAO();
                objPersoBean = new PersonalBean();
                objPersoBean.setCODPERSONAL(numero[0]);
                objPersoBean=objPersoDAO.CapturarCodigo(objPersoBean);
                request.setAttribute("DATOS",  objPersoBean);
                pagina = "/personal/FrmModificarClavePersonal.jsp";
            }break;
            //retroceder en el login
            case 15:{
        pagina = "/index.jsp";
    }break;
    //Informacion:
            case 16:{
                numproy=request.getParameter("cod");
                int proy=Integer.parseInt(numproy);
                
               
             objPersoBean=new PersonalBean();
             objPersoDAO=new PersonalDAO();
                objPersoBean.setNUMPROY(proy);
                objPersoBean=objPersoDAO.InformacionProyecto(objPersoBean);
                request.setAttribute("infoproy", objPersoBean);
                pagina="/Relacion/InformacionProyecto.jsp";
                
                
                
            }break;
            //login json
            case 17:{
                   
        PrintWriter out=response.getWriter();
       
        
                PersonalBean objPersoBean1=null;
      
         String contraseña=request.getParameter("txtcontra");
                String usuario=request.getParameter("txtnombre");
                
                String passencriptado=DigestUtils.md5Hex(contraseña);
                objPersoBean1=new PersonalBean();
                objPersoBean1.setID(usuario);
                objPersoBean1.setPASS(passencriptado);
                PersonalDAO objUsuDAO=new PersonalDAO();
                
               
                int i=objUsuDAO.ValidarAcceso(objPersoBean1);
                
              
                
                json=new StringBuilder();
                json.append("{\"personal\":\""+i+"\"}");
                out.print(json.toString());
           
         
            
            
            
        }break;
        
            case 18:{
                
                   objPersoDAO=new PersonalDAO();
      lista=objPersoDAO.ListarPersonal1();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"personal\":[");
          for(int i=0;i<lista.size();i++)
          {
           PersonalBean  obj=(PersonalBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"CODPERSONAL\":\""+obj.getCODPERSONAL()+"\",\"NOMBPERSONAL\":\""+obj.getNOMBPERSONAL()+"\",\"EMAPERSONAL\":\""+obj.getEMAPERSONAL()+"\",\"TELFPERSONAL\":\""+obj.getTELFPERSONAL()+"\",\"HORAS\":\""+obj.getHORAS()+"\",\"DIAS\":\""+obj.getDIAS()+"\",\"ID\":\""+obj.getID()+"\",\"PASS\":\""+obj.getPASS()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"}");   
               }
               else
               {
               json.append("{\"CODPERSONAL\":\""+obj.getCODPERSONAL()+"\",\"NOMBPERSONAL\":\""+obj.getNOMBPERSONAL()+"\",\"EMAPERSONAL\":\""+obj.getEMAPERSONAL()+"\",\"TELFPERSONAL\":\""+obj.getTELFPERSONAL()+"\",\"HORAS\":\""+obj.getHORAS()+"\",\"DIAS\":\""+obj.getDIAS()+"\",\"ID\":\""+obj.getID()+"\",\"PASS\":\""+obj.getPASS()+"\",\"NUMPROY\":\""+obj.getNUMPROY()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
            
                
            }break;
            case 19:{
                
            Email email = new Email();
            String contraseña=request.getParameter("txtpass");
            String de ="isagen24@gmail.com";
            String clave = "isagen2424";
            String para = request.getParameter("txtema");
          String mensaje = "RECORDAR QUE SU CONTRASEÑA DE PERSONAL ES :"+contraseña;
            String asunto = "SEGURIDAD ISAGEN";
             boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);
                         String bol=String.valueOf(resultado);

              cod = Integer.parseInt(request.getParameter("txtcod"));
                nom = request.getParameter("txtnom");
                ema = request.getParameter("txtema");
                tel = request.getParameter("txttel");
                hor = request.getParameter("txthoras");
                dia = request.getParameter("txtdias");
                 id = request.getParameter("txtid");
                 pass = request.getParameter("txtpass");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
               
                
                        
                objPersoBean = new PersonalBean();
                objPersoBean.setCODPERSONAL(cod);
                objPersoBean.setNOMBPERSONAL(nom);
                objPersoBean.setEMAPERSONAL(ema);
                objPersoBean.setTELFPERSONAL(tel);
                objPersoBean.setHORAS(hor);
                objPersoBean.setDIAS(dia);
                objPersoBean.setNUMPROY(proy);
                  objPersoBean.setID(id);
                  objPersoBean.setPASS(pass);
            
           request.setAttribute("DATOS",objPersoBean);
            if(bol.equals(false)){
                         
                request.setAttribute("mensaje","CORREO ELECTRONICO NO ENVIADO");
                


            }else{
                request.setAttribute("mensaje","CORREO ELECTRONICO ENVIADO SATISFACTORIAMENTE"); 
              
            }
                             pagina="/personal/FrmModificarClavePersonal.jsp";

            }break;
            
                        //mostrar
              case 20:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objPersoDAO=new PersonalDAO();
                  
               lista=objPersoDAO.ListarPersonal1();
            out.println("{\"personal\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 21:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();

 objPersoDAO = new PersonalDAO();
                    cod = Integer.parseInt(request.getParameter("txtcod"));
                    nom = request.getParameter("txtnom");
                    ema = request.getParameter("txtema");
                    tel = request.getParameter("txttel");
                    hor = request.getParameter("txthor");
                    dia = request.getParameter("txtdia");
                     id = request.getParameter("txtid");
                      pass = request.getParameter("txtpass");
                    numproy=request.getParameter("txtnumproy");
                    int proy=Integer.parseInt(numproy);
                    
                    objPersoBean = new PersonalBean();
                    objPersoBean.setCODPERSONAL(cod);
                    objPersoBean.setNOMBPERSONAL(nom);
                    objPersoBean.setEMAPERSONAL(ema);
                    objPersoBean.setTELFPERSONAL(tel);
                    objPersoBean.setHORAS(hor);
                    objPersoBean.setDIAS(dia);
                    objPersoBean.setID(id);
                    objPersoBean.setPASS(pass);
                    objPersoBean.setNUMPROY(proy);
                    
                    int i = objPersoDAO.InsertarPersonal(objPersoBean);
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se ingreso}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se ingreso}"));

                          }
                  out.print(json.toString());
                  //http://localhost:8084/ProyectoGestion/ProyectoServlet?op=11&txtnum=5&txttit=sadsa&txtdur=adsa&txtdes=ssds&txttip=asa&txtcan=sdsd&txtini=saas&txtfin=asas&txtpre=sds&txtcodjefe=4
              }break;
              
              //modificar
       case 22:{
           PrintWriter out = response.getWriter();
         json=new StringBuilder();   
                cod = Integer.parseInt(request.getParameter("txtcod"));
                nom = request.getParameter("txtnom");
                ema = request.getParameter("txtema");
                tel = request.getParameter("txttel");
                hor = request.getParameter("txthor");
                dia = request.getParameter("txtdia");
                 id = request.getParameter("txtid");
                 pass = request.getParameter("txtpass");
                numproy=request.getParameter("txtnumproy");
                int proy=Integer.parseInt(numproy);
                
                objPersoDAO = new PersonalDAO();
                objPersoBean = new PersonalBean();
                objPersoBean.setCODPERSONAL(cod);
                objPersoBean.setNOMBPERSONAL(nom);
                objPersoBean.setEMAPERSONAL(ema);
                objPersoBean.setTELFPERSONAL(tel);
                objPersoBean.setHORAS(hor);
                objPersoBean.setDIAS(dia);
                
                  objPersoBean.setID(id);
                  objPersoBean.setPASS(pass);
                  objPersoBean.setNUMPROY(proy);
                int i=objPersoDAO.ModificarPersonal(objPersoBean);
                Gson gson=new Gson();
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se modifico}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se modifico}"));

                  }
                  out.print(json.toString());
       }break;
       case 23:{
           PrintWriter out = response.getWriter();
            Gson gson=new Gson();
              String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objPersoDAO= new PersonalDAO();
                objPersoBean = new PersonalBean();
                objPersoBean.setCODPERSONAL(numero1[0]);
                int  i= objPersoDAO.EliminarPersonal(objPersoBean);
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
