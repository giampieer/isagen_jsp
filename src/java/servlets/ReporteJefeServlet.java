
package servlets;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReporteJefeServlet extends HttpServlet {



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
       OutputStream out=response.getOutputStream();    
 String numero=request.getParameter("txtproy");
 int num=Integer.parseInt(numero);
        try {
            
            
            try {
                Connection cn=null;
                Statement st=null;
                ResultSet rs=null;
              
     
                 Class.forName("com.mysql.jdbc.Driver");
cn=DriverManager.getConnection("jdbc:mysql://mysql28519-mariscal2424.jl.serv.net.mx/relacion","root","VKNvyl30585");     // cn=DriverManager.getConnection("jdbc:mysql://localhost/relacion","root","");
            st=cn.createStatement();
            rs=st.executeQuery("select * from jefe where codjefe='"+num+"'");
            
            if(cn!=null){
                
                 
            try {
                
                Document documento=new Document();
                PdfWriter.getInstance(documento, out);
                documento.open();
                
                Paragraph par1=new Paragraph();
                Font fontitulo=new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE);
                 par1.add(new Phrase("GESTION DE PROYECTOS DE LA EMPRESA ISAGEN ",fontitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                                par1.add(new Phrase(Chunk.NEWLINE));
                 documento.add(par1);
                
                 
                 
                 
                   Paragraph par2=new Paragraph();
                Font descripcion=new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLACK);
                par2.add(new Phrase("JEFE DEL PROYECTO ",descripcion));
                par2.setAlignment(Element.ALIGN_CENTER);
                par2.add(new Phrase(Chunk.NEWLINE));
                  par2.add(new Phrase(Chunk.NEWLINE));
                 documento.add(par2);
                 
                 
                 
                 PdfPTable tabla=new PdfPTable(7);
                   tabla.setWidthPercentage(100);
                 PdfPCell celda1=new PdfPCell(new Paragraph("CODIGO",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK )));
                 PdfPCell celda2=new PdfPCell(new Paragraph("NOMBRE",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK )));
                 PdfPCell celda3=new PdfPCell(new Paragraph("EMAIL",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK )));
                 PdfPCell celda4=new PdfPCell(new Paragraph("TELEFONO",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK )));
                 PdfPCell celda5=new PdfPCell(new Paragraph("AREA",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK )));
                 PdfPCell celda6=new PdfPCell(new Paragraph("ID",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK )));
                  PdfPCell celda7=new PdfPCell(new Paragraph("PASS",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK )));

                 tabla.addCell(celda1);               
                 tabla.addCell(celda2);
                 tabla.addCell(celda3);
                 tabla.addCell(celda4);
                 tabla.addCell(celda5);
                 tabla.addCell(celda6);
                 tabla.addCell(celda7);

                 while(rs.next()){
                     tabla.addCell(rs.getString(1));               
           tabla.addCell(rs.getString(2));               
         tabla.addCell(rs.getString(3));               
         tabla.addCell(rs.getString(4));               
        tabla.addCell(rs.getString(5));          
        tabla.addCell(rs.getString(6));                
        tabla.addCell(rs.getString(7));    
                 }
                 documento.add(tabla);
                 
                 
               
                 
            documento.close();
                
                
            } catch (Exception e) {
                e.getMessage();
            }
                
            }
            
            
            } catch (Exception e) {
            }
            
 } finally  {
out.close();

        }

        
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
