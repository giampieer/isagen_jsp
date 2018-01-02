
package UTIL;
import java.sql.*;
public class ConexionBD {

    public static Connection getConexionBD(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

//cn=DriverManager.getConnection("jdbc:mysql://mysql30308-mariscal24.jl.serv.net.mx/relacion","root","KKGxde78611");
cn=DriverManager.getConnection("jdbc:mysql://localhost/relacion","root","");
 
          System.out.println("Se conecto !!");
        } catch (Exception e) {
            System.out.println("No se conecto !!");
        }
        return cn;
    }
    
    public static void main(String[] args) {
      getConexionBD();
    }
    
}
