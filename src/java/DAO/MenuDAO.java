/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.JefeBean;
import BEAN.MenuBean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class MenuDAO {
     Connection          cn = null;
    PreparedStatement   pt = null;
    ResultSet           rs = null;
    ArrayList<MenuBean> lista = null;
    MenuBean objbean = null;
    public ArrayList<MenuBean> ListarMenu(){
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("select * from menu");
            rs=pt.executeQuery();
            lista=new ArrayList<MenuBean>();
            while(rs.next()){
                objbean=new MenuBean();
                objbean.setCodigo(rs.getInt("codigo"));
                objbean.setNombre(rs.getString("nombre"));
                objbean.setDescripcion(rs.getString("Descripcion"));
                objbean.setPrecio(rs.getString("Precio"));
                objbean.setTipo(rs.getString("tipo"));
                objbean.setDia(rs.getString("dia"));
                lista.add(objbean);

            }
            cn.close();
            pt.close();
            rs.close();
            
        } catch (Exception e) {
        }
        return lista;
    }
}
