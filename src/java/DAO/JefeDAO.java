

    
package DAO;
import UTIL.ConexionBD;
import BEAN.JefeBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JefeDAO {
    Connection          cn = null;
    PreparedStatement   pt = null;
    ResultSet           rs = null;
    ArrayList<JefeBean> lista = null;
    JefeBean objJefeBean = null;
    
    public ArrayList<JefeBean> ListarJefe() {
        try {
             cn=ConexionBD.getConexionBD();// conexion BD
             pt=cn.prepareStatement("select * from jefe");
             rs=pt.executeQuery();
             lista = new ArrayList<JefeBean>();
             while(rs.next()){
                 objJefeBean = new JefeBean();
                 objJefeBean.setCODJEFE(rs.getInt("codjefe"));
                 objJefeBean.setNOMBJEFE(rs.getString("nombjefe"));
                 objJefeBean.setEMAJEFE(rs.getString("emajefe"));
                 objJefeBean.setTELFJEFE(rs.getString("telfjefe"));
                 objJefeBean.setAREAJEFE(rs.getString("areajefe"));
                 objJefeBean.setID(rs.getString("ID"));
                 objJefeBean.setPASS(rs.getString("PASS"));
                 
                 lista.add(objJefeBean);
             }
             pt.close();
             rs.close();
             cn.close();
        } catch (Exception e) {
             
        }
        return lista;
    }
    
    //combobox en proyecto
   public ArrayList<JefeBean> ListarJefedeProyecto() {
        try {
             cn=ConexionBD.getConexionBD();// conexion BD
             pt=cn.prepareStatement("select * from jefe j  left join proy pr on pr.codjefe=j.codjefe where pr.codjefe is null");
             rs=pt.executeQuery();
             lista = new ArrayList<JefeBean>();
             while(rs.next()){
                 objJefeBean = new JefeBean();
                 objJefeBean.setCODJEFE(rs.getInt("codjefe"));
                 objJefeBean.setNOMBJEFE(rs.getString("nombjefe"));
                 objJefeBean.setEMAJEFE(rs.getString("emajefe"));
                 objJefeBean.setTELFJEFE(rs.getString("telfjefe"));
                 objJefeBean.setAREAJEFE(rs.getString("areajefe"));
                 objJefeBean.setID(rs.getString("ID"));
                 objJefeBean.setPASS(rs.getString("PASS"));
                 
                 lista.add(objJefeBean);
             }
             pt.close();
             rs.close();
             cn.close();
        } catch (Exception e) {
             
        }
        return lista;
    }
    
    public int InsertarJefe(JefeBean obj){
        int estado = 0;
        try {
             cn=ConexionBD.getConexionBD(); 
             pt=cn.prepareStatement("insert into jefe values(?,?,?,?,?,?,?)");
             pt.setInt(1,obj.getCODJEFE());
             pt.setString(2,obj.getNOMBJEFE());
             pt.setString(3,obj.getEMAJEFE()); 
             pt.setString(4,obj.getTELFJEFE());
             pt.setString(5,obj.getAREAJEFE());
             pt.setString(6, obj.getID());
             pt.setString(7, obj.getPASS());
             estado=pt.executeUpdate();
             pt.close();
             cn.close();
        } catch (Exception e) {
             estado=0;
        }
        return estado;
    }
    
    public int EliminarJefe(JefeBean obj){
        int estado = 0;
        try {
             cn=ConexionBD.getConexionBD();
             pt=cn.prepareStatement("delete from jefe where codjefe=?");
             pt.setInt(1,obj.getCODJEFE());
             estado=pt.executeUpdate();
             pt.close();
             cn.close();
        } catch (Exception e) {
             estado=0;
        }
        return estado;
    }
    
    public int ModificarJefe(JefeBean obj){
        int estado = 0;
        try {
             cn=ConexionBD.getConexionBD();
             pt=cn.prepareStatement("update jefe set nombjefe=?,emajefe=?,telfjefe=?,areajefe=?,ID=?,PASS=? where codjefe=?");
             pt.setString(1,obj.getNOMBJEFE());
             pt.setString(2,obj.getEMAJEFE());
             pt.setString(3,obj.getTELFJEFE());
             pt.setString(4,obj.getAREAJEFE());
             pt.setString(5, obj.getID());
             pt.setString(6, obj.getPASS());
             
             pt.setInt(7,obj.getCODJEFE());
             estado=pt.executeUpdate();
             pt.close();
             cn.close();
        } catch (Exception e) {
             estado=0;
        }
        return estado;
    }
    
     public JefeBean CapturarCodigo(JefeBean obj)
    {
        JefeBean objeto=null;
        try 
        {
            cn  =  ConexionBD.getConexionBD();
            pt  = cn.prepareStatement("select * from jefe where codjefe=?;");
            pt.setInt(1, obj.getCODJEFE());
            rs=pt.executeQuery();
            while(rs.next())
            {
                objeto=new JefeBean();
                objeto.setCODJEFE(rs.getInt(1));
                objeto.setNOMBJEFE(rs.getString(2));
                objeto.setEMAJEFE(rs.getString(3));
                objeto.setTELFJEFE(rs.getString(4));
                objeto.setAREAJEFE(rs.getString(5));
                objeto.setID(rs.getString(6));
                objeto.setPASS(rs.getString(7));
                
                
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) 
        {
        }
        return objeto;
    }
     //login json android
     public int ValidarAcceso(JefeBean obj)
    {
        int estado=0;
        try 
        {
            ConexionBD objc=new ConexionBD();
            cn=objc.getConexionBD();
            pt=cn.prepareStatement("select COUNT(*) from jefe where ID=? and PASS=? ");
            pt.setString(1, obj.getID());
            pt.setString(2, obj.getPASS());
            
            rs=pt.executeQuery();
            while(rs.next()){
                estado=rs.getInt(1);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) 
        {
            estado=0;
        }
        return estado;
    }
    //seguridad
      public JefeBean capturarDatosUsuario(JefeBean objUsuBean){
        JefeBean  objeto=null;
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("select * from jefe where ID=? and PASS=?;");
            pt.setString(1, objUsuBean.getID());
            pt.setString(2, objUsuBean.getPASS());
           
            rs=pt.executeQuery();
            while(rs.next()){
               
                objeto=new JefeBean();
                objeto.setCODJEFE(rs.getInt("codjefe"));
                objeto.setNOMBJEFE(rs.getString("nombjefe"));
                objeto.setEMAJEFE(rs.getString("emajefe"));
                objeto.setTELFJEFE(rs.getString("telfjefe"));
                objeto.setAREAJEFE(rs.getString("areajefe"));
                objeto.setID(rs.getString("id"));
                objeto.setPASS(rs.getString("pass"));
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return objeto;
    } 
       public int generarCodigo() {
        int CODIGO = 0;
        try {
              cn  =  ConexionBD.getConexionBD();
              pt  = cn.prepareStatement("SELECT MAX(CODJEFE) FROM jefe ;");  
              rs=pt.executeQuery();
              rs.next();
              int c=Integer.parseInt(rs.getString(1))+1;
              String id="";
              if(c<100000){id=""+c;}
             
              CODIGO=Integer.parseInt(id);
        } catch (Exception e) {
        }
        return CODIGO;
    }   
     
}

