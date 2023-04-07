
package Controles;

import Modelos.Tables;
import Modelos.UsuarioDao;
import Modelos.Usuarios;
import Vistas.PanelAdmin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class UsuariosControler implements ActionListener,MouseListener,KeyListener{
    
    private Usuarios us;
    private UsuarioDao usDao;
    private PanelAdmin views;
    DefaultTableModel modelo = new DefaultTableModel();

    public UsuariosControler(Usuarios us, UsuarioDao usDao, PanelAdmin views) {
        this.us = us;
        this.usDao = usDao;
        this.views = views;
        this.views.bntRegistrarUser.addActionListener(this);
        this.views.btnModificarUser.addActionListener(this);
        this.views.JMenuEliminarUser.addActionListener(this);
        this.views.JMenuReingresarUser.addActionListener(this);
        this.views.btnNuevoUser.addActionListener(this);
        this.views.txtBuscarUser.addKeyListener(this);
        this.views.tableUser.addMouseListener(this);
        listarUsuarios();
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== views.bntRegistrarUser) {
            if (views.txtUsuarioUser.getText().equals("")
                    || views.txtNombreUser.getText().equals("")
                    ||String.valueOf(views.txtClaveUser.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(null, "Todo los campos son obligatorios");
            }else{
                us.setUser(views.txtUsuarioUser.getText());
                us.setNombre(views.txtNombreUser.getText());
                us.setClave(String.valueOf(views.txtClaveUser.getPassword()));
                us.setCaja(views.cbxCajaUser.getSelectedItem().toString());
                us.setRol(views.cbxRolUser.getSelectedItem().toString());
                if (usDao.registrar(us)) {
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
                }else{
                        JOptionPane.showMessageDialog(null, "Error al registrar el usuario");
                }
                
                
            }
            
        }else  if (e.getSource()== views.btnModificarUser) {
            if (views.txtUsuarioUser.getText().equals("")
                    || views.txtNombreUser.getText().equals(""))
                     {
                JOptionPane.showMessageDialog(null, "Todo los campos son obligatorios");
            }else{
                us.setUser(views.txtUsuarioUser.getText());
                us.setNombre(views.txtNombreUser.getText());               
                us.setCaja(views.cbxCajaUser.getSelectedItem().toString());
                us.setRol(views.cbxRolUser.getSelectedItem().toString());
                us.setId(Integer.parseInt(views.txtIdUser.getText()));
                
                if (usDao.modificar(us)) {
                    limpiarTable();
                     listarUsuarios();
                     limpiar();
                    JOptionPane.showMessageDialog(null, "Usuario modificado con exito");
                }else{
                        JOptionPane.showMessageDialog(null, "Error al modificar el usuario");
                }
                
                
            }
            
        }else if(e.getSource()==views.JMenuEliminarUser){
            if (views.txtIdUser.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila para eliminar");
                
            }else{
                  int id = Integer.parseInt(views.txtIdUser.getText());
                  if (usDao.accion("Inactivo", id)) {
                      limpiarTable();
                      listarUsuarios();
                      limpiar();
                      JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar usuario");
                  }
                
            }
             
        }else if(e.getSource()==views.JMenuReingresarUser){
            if (views.txtIdUser.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila para reingresar");
                
            }else{
                  int id = Integer.parseInt(views.txtIdUser.getText());
                  if (usDao.accion("Activo", id)) {
                      limpiarTable();
                      listarUsuarios();
                      limpiar();
                      JOptionPane.showMessageDialog(null, "Usuario reingresado con exito");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error al reingresar usuario");
                  }
                
            }
             
        }else{
            limpiar();
          
    }
            
        
    }
    
         public void listarUsuarios(){
            
             List<Usuarios> lista = usDao.ListaUsuarios(views.txtBuscarUser.getText());
             modelo = (DefaultTableModel) views.tableUser.getModel();
             Object[] ob = new Object[6];
             for (int i = 0; i < lista.size(); i++) {
                 ob[0] = lista.get(i).getId();
                 ob[1] = lista.get(i).getUser();
                 ob[2] = lista.get(i).getNombre();
                 ob[3] = lista.get(i).getCaja();
                 ob[4] = lista.get(i).getRol();
                 ob[5] = lista.get(i).getEstado();
                 modelo.addRow(ob);
                 
             }
             views.tableUser.setModel(modelo);
             JTableHeader header = views.tableUser.getTableHeader();
             header.setOpaque(false);
             header.setBackground(Color.blue);
             header.setForeground(Color.white);
          }
     public void limpiarTable(){
         for (int i = 0; i < modelo.getRowCount(); i++) {
             modelo.removeRow(i);
              i= i-1;
             
         }
     
     }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== views.tableUser) {
          int fila =views.tableUser.rowAtPoint(e.getPoint());
          views.txtIdUser.setText(views.tableUser.getValueAt(fila, 0).toString());
          views.txtUsuarioUser.setText(views.tableUser.getValueAt(fila,1).toString());
          views.txtNombreUser.setText(views.tableUser.getValueAt(fila, 2).toString());
          views.cbxCajaUser.setSelectedItem(views.tableUser.getValueAt(fila, 3).toString());
          views.cbxRolUser.setSelectedItem(views.tableUser.getValueAt(fila, 4).toString());
          views.txtClaveUser.setEnabled(false);
          views.bntRegistrarUser.setEnabled(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
     }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
   }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource()== views.txtBuscarUser) {
            limpiarTable();
            listarUsuarios();
            

        }
        
    }
        private void limpiar(){
                 views.txtIdUser.setText("");
                 views.txtUsuarioUser.setText("");
                 views.txtNombreUser.setText("");
                 views.txtClaveUser.setText("");
        
            }
    
        }

