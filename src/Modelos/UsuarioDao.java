/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Usuarios login(String user ,String clave){
        String sql ="SELECT* FROM usuarios WHERE user =? AND clave =?";
        Usuarios us = new Usuarios();
        try {
             con = cn.getConexion();
             ps =con.prepareStatement(sql);
             ps.setString(1, user);
             ps.setString(2 ,clave);
             rs= ps.executeQuery();
             if(rs.next()){
                 us.setId(rs.getInt("Id"));
                 us.setUser(rs.getString("user"));
                 us.setNombre(rs.getString("nombre"));
                 us.setCaja(rs.getString("caja"));
                 us.setRol(rs.getString("rol"));
                 us.setEstado(rs.getString("estado"));
             
             
             
             
             }
             
      
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.toString());
        }
        
        
         return us;
    
    
    
    }
    
    
}
