
package servlets;

import BEAN.JefeBean;
import BEAN.PersonalBean;
import DAO.JefeDAO;
import DAO.PersonalDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.Email;
import org.apache.commons.codec.digest.DigestUtils;


public class JefeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession respuesta=request.getSession();
         response.setContentType("application/json");
         StringBuilder json=null;
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        String nom,ema,tel,are,id,pass,codi;
        int cod;
        String pagina = "";
        ArrayList lista = null;
        JefeDAO objJefeDAO = null;
        JefeBean  objJefeBean = null;
        switch(op)
        {
            case 1://Listar
            {
                objJefeDAO = new JefeDAO();
                lista=objJefeDAO.ListarJefe();
                request.setAttribute("lista", lista);               
                pagina="/jefe/FrmJefeMant.jsp";
            }break;
            case 2://Pagina grabar
            {
                pagina = "/jefe/FrmNuevoJefe.jsp";
            }break;
            case 3://Nuevo
            {
                objJefeDAO = new JefeDAO();
                    cod = Integer.parseInt(request.getParameter("txtcod"));
                    nom = request.getParameter("txtnom");
                    ema = request.getParameter("txtema");
                    tel = request.getParameter("txttel");
                    are = request.getParameter("txtare");
                    id=request.getParameter("txtid");
                    pass=request.getParameter("txtpass");
                   String passencriptado=DigestUtils.md5Hex(pass);
                   
                    objJefeBean = new JefeBean();
                    objJefeBean.setCODJEFE(cod);
                    objJefeBean.setNOMBJEFE(nom);
                    objJefeBean.setEMAJEFE(ema);
                    objJefeBean.setTELFJEFE(tel);
                    objJefeBean.setAREAJEFE(are);
                    objJefeBean.setID(id);
                    objJefeBean.setPASS(passencriptado);
                    
                    int i = objJefeDAO.InsertarJefe(objJefeBean);
                   if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                    }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                    }                    
                    pagina = "/jefe/FrmNuevoJefe.jsp";
            }break;
            case 4://Salir
            {
                objJefeDAO = new JefeDAO();
                lista = objJefeDAO.ListarJefe();
                request.setAttribute("lista", lista);
                
                pagina = "/jefe/FrmJefeMant.jsp";
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
                objJefeDAO = new JefeDAO();
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(numero[0]);
                objJefeBean=objJefeDAO.CapturarCodigo(objJefeBean);
                request.setAttribute("DATOS",  objJefeBean);
                pagina = "/jefe/FrmModificarJefe.jsp";
            }break;
            case 6://Modificar
            {
                cod = Integer.parseInt(request.getParameter("txtcod"));
                nom = request.getParameter("txtnom");
                ema = request.getParameter("txtema");
                tel = request.getParameter("txttel");
                are = request.getParameter("txtare");
                id=request.getParameter("txtid");
                pass=request.getParameter("txtpass");
                                  // String passencriptado=DigestUtils.md5Hex(pass);

                objJefeDAO = new JefeDAO();
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(cod);
                objJefeBean.setNOMBJEFE(nom);
                objJefeBean.setEMAJEFE(ema);
                objJefeBean.setTELFJEFE(tel);
                objJefeBean.setAREAJEFE(are);
                objJefeBean.setID(id);
                objJefeBean.setPASS(pass);
                
                
                int i=objJefeDAO.ModificarJefe(objJefeBean);
                if(i == 1){
                request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Registro No Modificado");  
                }
                objJefeDAO = new JefeDAO();
                lista = objJefeDAO.ListarJefe();
                request.setAttribute("lista", lista);
                pagina = "/jefe/FrmJefeMant.jsp";
            }break;
            case 7://Eliminar
            {
                 String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objJefeDAO= new JefeDAO();
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(numero1[0]);
                int  i= objJefeDAO.EliminarJefe(objJefeBean);
                
                lista = objJefeDAO.ListarJefe();
                request.setAttribute("lista", lista);
                request.setAttribute("mensaje","Registro Eliminado Sastisfactoriamente");
              
                pagina = "/jefe/FrmJefeMant.jsp";
            }break;
        
            case 8:// login sin capturar sin seguridad
            { 
            }break;
      //seguridad
            case 9:
            {
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
                objJefeDAO = new JefeDAO();
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(numero[0]);
                objJefeBean=objJefeDAO.CapturarCodigo(objJefeBean);
                request.setAttribute("DATOS",  objJefeBean);
                pagina = "/jefe/FrmModifcarJefeLogin.jsp";
            }break;
                case 11://Modificar el login
            {
                codi = request.getParameter("txtcod");
                int cod1=Integer.parseInt(codi);

                nom = request.getParameter("txtnom");
                ema = request.getParameter("txtema");
                tel = request.getParameter("txttel");
                are = request.getParameter("txtare");
                id=request.getParameter("txtid");
                pass=request.getParameter("txtpass");
                objJefeDAO = new JefeDAO();
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(cod1);
                objJefeBean.setNOMBJEFE(nom);
                objJefeBean.setEMAJEFE(ema);
                objJefeBean.setTELFJEFE(tel);
                objJefeBean.setAREAJEFE(are);
                objJefeBean.setID(id);
                objJefeBean.setPASS(pass);
                
                
                int i=objJefeDAO.ModificarJefe(objJefeBean);
                objJefeDAO = new JefeDAO();
                lista = objJefeDAO.ListarJefe();
                request.setAttribute("lista", lista);
                if(i == 1){
                request.setAttribute("mensaje","Informacion del Administrador Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Informacion del Administrador No Modificado");  
                }
                 request.setAttribute("DATOS",objJefeBean);
                pagina = "/jefe/FrmModifcarJefeLogin.jsp";
            }break;
                case 12 :{ //para redireccionar al proncipal
                    pagina="/inicio/carrusel.jsp";
           }break;
                case 13:{
                    
                    
                String nuevo,actual;
             codi = request.getParameter("txtcod");
                int cod1=Integer.parseInt(codi);

                nom = request.getParameter("txtnom");
                ema = request.getParameter("txtema");
                tel = request.getParameter("txttel");
                are = request.getParameter("txtare");
                id=request.getParameter("txtid");
                pass=request.getParameter("txtpass");
                nuevo=request.getParameter("txtnuevo");
                actual=request.getParameter("txtactual");
                
                String nuevoencriptado=DigestUtils.md5Hex(nuevo);
                 String actualencriptado=DigestUtils.md5Hex(actual);
                objJefeDAO = new JefeDAO();
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(cod1);
                objJefeBean.setNOMBJEFE(nom);
                objJefeBean.setEMAJEFE(ema);
                objJefeBean.setTELFJEFE(tel);
                objJefeBean.setAREAJEFE(are);
                objJefeBean.setID(id);
                objJefeBean.setPASS(nuevoencriptado);
                 int i=0;
               if(pass.equals(actualencriptado)){
                     
                   i=objJefeDAO.ModificarJefe(objJefeBean);
                if(i == 1){
                request.setAttribute("mensaje","Contraseña Modificado Satisfactoriamente");
                }else{
                request.setAttribute("mensaje","Contraseña  no Modificado");  
                }
                          request.setAttribute("DATOS",objJefeBean);
                           pagina="/jefe/FrmModifcarClaveJefe.jsp";
                   }else{
                       
                request.setAttribute("mensaje","Contraseña  no Modificado");  
                
                          request.setAttribute("DATOS",objJefeBean);
                           pagina="/jefe/FrmModifcarClaveJefe.jsp";
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
                objJefeDAO = new JefeDAO();
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(numero[0]);
                objJefeBean=objJefeDAO.CapturarCodigo(objJefeBean);
                request.setAttribute("DATOS",  objJefeBean);
                pagina = "/jefe/FrmModifcarClaveJefe.jsp";
            }break;
        
        
        //retriceder en el login
        case 15:{
        pagina = "/index.jsp";
    }break;
    
    
    //login json
        case 16:{
 PrintWriter out=response.getWriter();
       
        
        JefeBean objJefeBean1=null;
      
       
                 String contraseña=request.getParameter("txtcontra");
                String usuario=request.getParameter("txtnombre");
                
                String passencriptado=DigestUtils.md5Hex(contraseña);
                
                objJefeBean1=new JefeBean();
                objJefeBean1.setID(usuario);
                objJefeBean1.setPASS(passencriptado);
                JefeDAO objUsuDAO=new JefeDAO();
                
               
                int i=objUsuDAO.ValidarAcceso(objJefeBean1);
      json=new StringBuilder();
                json.append("{\"jefe\":\""+i+"\"}");
                out.print(json.toString());
 }break;
 //mostrar json
        case 17:{
               objJefeDAO=new JefeDAO();
      lista=objJefeDAO.ListarJefe();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"jefe\":[");
          for(int i=0;i<lista.size();i++)
          {
           JefeBean  obj=(JefeBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"CODJEFE\":\""+obj.getCODJEFE()+"\",\"NOMBJEFE\":\""+obj.getNOMBJEFE()+"\",\"EMAJEFE\":\""+obj.getEMAJEFE()+"\",\"TELFJEFE\":\""+obj.getTELFJEFE()+"\",\"AREAJEFE\":\""+obj.getAREAJEFE()+"\",\"ID\":\""+obj.getID()+"\",\"PASS\":\""+obj.getPASS()+"\"}");   
               }
               else
               {
               json.append("{\"CODJEFE\":\""+obj.getCODJEFE()+"\",\"NOMBJEFE\":\""+obj.getNOMBJEFE()+"\",\"EMAJEFE\":\""+obj.getEMAJEFE()+"\",\"TELFJEFE\":\""+obj.getTELFJEFE()+"\",\"AREAJEFE\":\""+obj.getAREAJEFE()+"\",\"ID\":\""+obj.getID()+"\",\"PASS\":\""+obj.getPASS()+"\"},");   
               }
          }
        json.append("]}");
        out.print(json.toString());
            }break;
            
        case 18:{
            //cqrgar la pagina con los datos 
 
                
            
            Email email = new Email();
            String contraseña=request.getParameter("txtpass");
            String de ="isagen24@gmail.com";
            String clave = "isagen2424";
            String para = request.getParameter("txtema");
            String mensaje = "RECORDAR QUE SU CONTRASEÑA DE ADMINISTRADOR ES :"+contraseña;
            String asunto = "SEGURIDAD ISAGEN";
             boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);
            String bol=String.valueOf(resultado);
            
            
              codi = request.getParameter("txtcod");
                int cod1=Integer.parseInt(codi);

                nom = request.getParameter("txtnom");
                ema = request.getParameter("txtema");
                tel = request.getParameter("txttel");
                are = request.getParameter("txtare");
                id=request.getParameter("txtid");
                pass=request.getParameter("txtpass");
              
                
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(cod1);
                objJefeBean.setNOMBJEFE(nom);
                objJefeBean.setEMAJEFE(ema);
                objJefeBean.setTELFJEFE(tel);
                objJefeBean.setAREAJEFE(are);
                objJefeBean.setID(id);
                objJefeBean.setPASS(pass);
                  request.setAttribute("DATOS",objJefeBean);
            if(bol.equals(false)){
                         
                request.setAttribute("mensaje","CORREO ELECTRONICO NO ENVIADO");
                


            }else{
                request.setAttribute("mensaje","CORREO ELECTRONICO ENVIADO SATISFACTORIAMENTE"); 
              
            }
             pagina="/jefe/FrmModifcarClaveJefe.jsp";
            
        }break;
        
                    //mostrar
              case 19:{
                    PrintWriter out = response.getWriter();
                   Gson gson= new Gson();
                  objJefeDAO=new JefeDAO();
                  
               lista=objJefeDAO.ListarJefe();
            out.println("{\"jefe\":" +gson.toJson(lista)+"}");
             
                  
              }break;
              //grabar
              case 20:{
                        json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
                                  Gson gson= new Gson();

               objJefeDAO = new JefeDAO();
                    cod = Integer.parseInt(request.getParameter("txtcod"));
                    nom = request.getParameter("txtnom");
                    ema = request.getParameter("txtema");
                    tel = request.getParameter("txttel");
                    are = request.getParameter("txtare");
                    id=request.getParameter("txtid");
                    pass=request.getParameter("txtpass");
                    
                    objJefeBean = new JefeBean();
                    objJefeBean.setCODJEFE(cod);
                    objJefeBean.setNOMBJEFE(nom);
                    objJefeBean.setEMAJEFE(ema);
                    objJefeBean.setTELFJEFE(tel);
                    objJefeBean.setAREAJEFE(are);
                    objJefeBean.setID(id);
                    objJefeBean.setPASS(pass);
                    
                    int i = objJefeDAO.InsertarJefe(objJefeBean);
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se ingreso}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se ingreso}"));

                          }
                  out.print(json.toString());
                  //http://localhost:8084/ProyectoGestion/ProyectoServlet?op=11&txtnum=5&txttit=sadsa&txtdur=adsa&txtdes=ssds&txttip=asa&txtcan=sdsd&txtini=saas&txtfin=asas&txtpre=sds&txtcodjefe=4
              }break;
              
              //modificar
       case 21:{
           PrintWriter out = response.getWriter();
         json=new StringBuilder();   
               cod = Integer.parseInt(request.getParameter("txtcod"));
                nom = request.getParameter("txtnom");
                ema = request.getParameter("txtema");
                tel = request.getParameter("txttel");
                are = request.getParameter("txtare");
                id=request.getParameter("txtid");
                pass=request.getParameter("txtpass");
                
                objJefeDAO = new JefeDAO();
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(cod);
                objJefeBean.setNOMBJEFE(nom);
                objJefeBean.setEMAJEFE(ema);
                objJefeBean.setTELFJEFE(tel);
                objJefeBean.setAREAJEFE(are);
                objJefeBean.setID(id);
                objJefeBean.setPASS(pass);
                
                
                int i=objJefeDAO.ModificarJefe(objJefeBean);
//cargar combobox con datos del proyecto
  Gson gson= new Gson();
           json.append("{\"NUMERO\":\""+i+"\"}");
           out.println(json);
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se modifico}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se modifico}"));

                  }
                  
       }break;
       //elimnar en android
       case 22:{
               String   numeroCad[] =request.getParameterValues("cod");
                int  numero1[]=new  int[numeroCad.length];
                for(int i=0;i<numero1.length;i++)
                {
                    numero1[i]=Integer.parseInt(numeroCad[i]);
                }
                objJefeDAO= new JefeDAO();
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(numero1[0]);
                Gson gson= new Gson();
                
                 json=new StringBuilder();   
                   PrintWriter out = response.getWriter();
         int i = objJefeDAO.EliminarJefe(objJefeBean);
                  if(i==1){
                    out.println(gson.toJson("{Mensaje: se elimino}"));
                  } else{
                   out.println(gson.toJson("{Mensaje: No se elimino}"));

                          }
               out.print(json.toString());
       }break;
       
       //login dual
       case 23:{
           //trycatch para redireccionamiento al login
           try {
                              String selec=request.getParameter("txtseleccion");
             String contraseña=request.getParameter("txtcontra");
                String usuario=request.getParameter("txtnombre");
                                  String passencriptado=DigestUtils.md5Hex(contraseña);

                 JefeBean objJefeBean1=new JefeBean();
                objJefeBean1.setID(usuario);
                objJefeBean1.setPASS(passencriptado);
                JefeDAO objUsuDAO=new JefeDAO();
                objJefeBean=objUsuDAO.capturarDatosUsuario(objJefeBean1);
                
                 PersonalBean objJefeBean11=new PersonalBean();
                    PersonalBean  objPersoBean = null;
               objJefeBean11.setID(usuario);
               objJefeBean11.setPASS(passencriptado);
               PersonalDAO objUsuDAO1=new PersonalDAO();
               objPersoBean=objUsuDAO1.capturarDatosUsuario1(objJefeBean11);
               
                if(objJefeBean!=null&& selec.equals("ADMINISTRADOR")){
                    request.setAttribute("cargar", objJefeBean);
                    pagina="/inicio/menu2ajax.jsp";
                     }else{
                         if(objPersoBean!=null&&selec.equals("PERSONAL")) {
                             request.setAttribute("cargar", objPersoBean);
                    pagina="/inicio/menu1ajax.jsp";
                         }else{
                               request.setAttribute("mensaje","Datos Incorrectos , vuelva Ingresar correctamente");
                              pagina="/index.jsp";
                         }
                }
           } catch (Exception e) {
                request.setAttribute("mensaje","Loguearse por favor");
                              pagina="/index.jsp";
           }

                
           } 
                break;
       
       case 24:{
                String contraseña=request.getParameter("txtcontra");
                String usuario=request.getParameter("txtnombre");
                
                String passencriptado=DigestUtils.md5Hex(contraseña);
                
                JefeBean objJefeBean1=new JefeBean();
                objJefeBean1.setID(usuario);
                objJefeBean1.setPASS(passencriptado);
                JefeDAO objUsuDAO=new JefeDAO();
                
                JefeBean objJefe=new JefeBean();
                objJefeBean=objUsuDAO.capturarDatosUsuario(objJefeBean1);
               PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        

    
              json.append("{\"CODJEFE\":\""+objJefeBean.getCODJEFE()+"\",\"NOMBJEFE\":\""+objJefeBean.getNOMBJEFE()+"\",\"EMAJEFE\":\""+objJefeBean.getEMAJEFE()+"\",\"TELFJEFE\":\""
                      + ""+objJefeBean.getTELFJEFE()+"\",\"AREAJEFE\":\""+objJefeBean.getAREAJEFE()+"\",\"ID\":\""+objJefeBean.getID()+"\",\"PASS\":\""+objJefeBean.getPASS()+"\"},");   
               
          
        
        out.print(json.toString());
       }break;
       
       case 25:{
            String selec=request.getParameter("txtseleccion");
             String contraseña=request.getParameter("txtcontra");
                String usuario=request.getParameter("txtnombre");
                 JefeBean objJefeBean1=new JefeBean();
                objJefeBean1.setID(usuario);
                objJefeBean1.setPASS(contraseña);
                JefeDAO objUsuDAO=new JefeDAO();
                JefeBean objJefe=new JefeBean();
                objJefeBean=objUsuDAO.capturarDatosUsuario(objJefeBean1);
                
                 PersonalBean objJefeBean11=new PersonalBean();
                    PersonalBean  objPersoBean = null;
               objJefeBean11.setID(usuario);
               objJefeBean11.setPASS(contraseña);
               PersonalDAO objUsuDAO1=new PersonalDAO();
               objPersoBean=objUsuDAO1.capturarDatosUsuario1(objJefeBean11);
                if(objJefeBean!=null)
                { 
                     if (selec.equals("ADMINISTRADOR")){
                    request.setAttribute("cargar", objJefeBean);
                   pagina="/inicio/menu2ajax.jsp";
                     }else{
                           request.setAttribute("mensaje","Datos Incorrectos , vuelva Ingresar correctamente");
                       pagina="/index.jsp";
                     }
                }else
                {    if(objPersoBean!=null)
                {
                     if (selec.equals("PERSONAL")){
                    request.setAttribute("cargar", objPersoBean);
                    pagina="/inicio/menu1ajax.jsp";
                }else{
                      request.setAttribute("mensaje","Datos Incorrectos , vuelva Ingresar correctamente");
                       pagina="/index.jsp";
                }
                
                }else{
                       pagina="/index.jsp";
                }
                }
       
}break;
        case 26://Capturar Numero
            {
                String a = null;
                String   numeroCad[] =request.getParameterValues("cod");
                int  numero[]=new  int[numeroCad.length];
                for(int i=0;i<numero.length;i++)
                {
                    numero[i]=Integer.parseInt(numeroCad[i]);
                    
                }
                objJefeDAO = new JefeDAO();
                objJefeBean = new JefeBean();
                objJefeBean.setCODJEFE(numero[0]);
                objJefeBean=objJefeDAO.CapturarCodigo(objJefeBean);
                request.setAttribute("DATOS",  objJefeBean);
                pagina = "/logincontra.jsp";
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
