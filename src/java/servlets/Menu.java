
package servlets;

import BEAN.MenuBean;
import DAO.MenuDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Menu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         response.setContentType("application/json");
       String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        StringBuilder json=null;
        String pagina="";
        MenuBean objbean=null;
        ArrayList lista=null;
        MenuDAO objdao=null;
        switch(op){
            case 1:{
                     objbean=new MenuBean();
                     objdao=new MenuDAO();
      lista=objdao.ListarMenu();
        
      
        PrintWriter out = response.getWriter();
         json=new StringBuilder();
        
        json.append("{\"menu\":[");
          for(int i=0;i<lista.size();i++)
          {
           MenuBean  obj=(MenuBean) lista.get(i);
               if(i==lista.size())
               {  
               json.append("{\"codigo\":\""+obj.getCodigo()+"\",\"nombre\":\""+obj.getNombre()+"\",\"Descripcion\":\""+obj.getDescripcion()+"\",\"Precio\":\""+obj.getPrecio()+"\",\"tipo\":\""+obj.getTipo()+"\",\"dia\":\""+obj.getDia()+"\"}");   
               }
               else
               {
               json.append("{\"codigo\":\""+obj.getCodigo()+"\",\"nombre\":\""+obj.getNombre()+"\",\"Descripcion\":\""+obj.getDescripcion()+"\",\"Precio\":\""+obj.getPrecio()+"\",\"tipo\":\""+obj.getTipo()+"\",\"dia\":\""+obj.getDia()+"\"},");   
               }
          }
        json.append("]}");
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
