
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClientesDao {
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrar (Clientes cl)
    {
        String sql ="INSERT INTO clientes (nombre,telefono,direccion)VALUES(?,?,?)";
        try {
            con=cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getTelefono());
            ps.setString(3, cl.getDireccion());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
            
        }
 
    }
    public List ListaClientes(String valor ){
        List<Clientes> listaCli = new ArrayList();
        String sql ="SELECT * FROM clientes ORDER by estado ASC  ";
        String buscar ="SELECT * FROM clientes WHERE nombre LIKE ' % "+valor +"%' OR telefono LIKE '% "+valor +"%'";
         try {
              con = cn.getConexion();
              if (valor.equalsIgnoreCase("")) {
                  ps = con.prepareStatement(sql);
                  rs = ps.executeQuery();
                
             }else{
                     ps = con.prepareStatement(buscar);
                     rs = ps.executeQuery();   
              }
              
             while(rs.next()){
                 Clientes cl = new Clientes();
                 cl.setId(rs.getInt("id"));
                 cl.setNombre(rs.getString("nombre"));
                 cl.setTelefono(rs.getString("telefono"));
                 cl.setDireccion(rs.getString("direccion"));
                 cl.setEstado(rs.getString("estado"));
                 listaCli.add(cl);
                         
             
             }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
         return listaCli;
                
    
    
    }
    
     public boolean modificar (Usuarios us)
    {
        String sql ="UPDATE usuarios SET user=?,nombre=?,caja=?,rol=?WHERE id =?";
        try {
            con=cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getUser());
            ps.setString(2, us.getNombre());
            ps.setString(3, us.getCaja());
            ps.setString(4, us.getRol());
            ps.setInt(5, us.getId());
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
            
        }
 
    }
     public boolean accion(String estado,int id){
     
       String sql ="UPDATE usuarios SET estado =? WHERE id =?";
         try {
             con =cn.getConexion();
             ps = con.prepareStatement(sql);
             ps.setString(1, estado);
             ps.setInt(2, id);
             ps.execute();
             return true;
                    
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.toString());
             return false;
         }
     }
}
