/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Modelos.UsuarioDao;
import Modelos.Usuarios;
import Vistas.FramLogin;
import Vistas.PanelAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class LoginControler implements ActionListener{
    private Usuarios us ;
    private UsuarioDao usDao;
    private FramLogin views;

    public LoginControler(Usuarios us, UsuarioDao usDao, FramLogin views) {
        this.us = us;
        this.usDao = usDao;
        this.views = views;
        this.views.btnLogin.addActionListener(this);
        this.views.btnSalir.addActionListener(this);
        this.views.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== views.btnLogin){
            if(views.txtUsuario.getText().equals("")
               ||String.valueOf(views.txtClave.getPassword()) .equals("")){
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            
            }else{
                String user = views.txtUsuario.getText();
                String clave =String.valueOf(views.txtClave.getPassword());
                us = usDao.login(user, clave);
                if (us.getUser()!= null) {
                    PanelAdmin admin = new PanelAdmin();
                    admin.setVisible(true);
                    this.views.dispose();
                    
                }else{
                    
                JOptionPane.showMessageDialog(null, "usuario o la contraseña incorrecta");
                }
            }
        
        }else{
            
               int pregunta =JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir","Pregunta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
               if (pregunta== 0) {
                   System.exit(0);
                
            }
        }
       
    }
    
    
}
