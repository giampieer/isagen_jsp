
package DAO;


import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import BEAN.UsuarioBean;


public class UsuarioDAO {
    Connection cn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;
    ArrayList<UsuarioBean> lista = null;
    UsuarioBean objUsuBean = null;
    
    
    
    public boolean  ValidarUsuario(UsuarioBean objUsuarioBean){
        boolean estado=false;
        try 
        {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("SELECT * from usuario where alias=? and contraseña=?");
            pt.setString(1, objUsuarioBean.getAlias());
            pt.setString(2, objUsuarioBean.getContraseña());
            //pt.setString(3, objUsuarioBean.getTipo());
            
            rs=pt.executeQuery();
            while(rs.next()){
                estado=true;
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) 
        {
            estado=false;
        }
        return estado;
    }
    public ArrayList<UsuarioBean> DatosUsuario( UsuarioBean objUsuBean){
        UsuarioBean  obj=null;
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("SELECT * FROM usuario where alias=? and contraseña=?");
            pt.setString(1, objUsuBean.getAlias());
            pt.setString(2, objUsuBean.getContraseña());
            //pt.setString(3, objUsuBean.getTipo());
            rs=pt.executeQuery();
            lista = new ArrayList<UsuarioBean>();
            while(rs.next()){
                obj=new UsuarioBean();
                obj.setNumero(rs.getInt("NUMERO"));
                obj.setNombre(rs.getString("NOMBRE"));
                obj.setCorreo(rs.getString("CORREO"));
                obj.setTelefono(rs.getString("TELEFONO"));
                obj.setAlias(rs.getString("ALIAS"));
                obj.setContraseña(rs.getString("CONTRASEÑA"));
                obj.setTipo(rs.getInt("TIPO"));
                lista.add(obj);
               
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return lista;
    } 
}
