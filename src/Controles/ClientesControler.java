
package Controles;

import Modelos.Clientes;
import Modelos.ClientesDao;
import Vistas.PanelAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ClientesControler implements ActionListener{
    private Clientes cl;
    private ClientesDao clDao;
    private PanelAdmin views ;

    public ClientesControler(Clientes cl, ClientesDao clDao, PanelAdmin views) {
        this.cl = cl;
        this.clDao = clDao;
        this.views = views;
        this.views.bntRegistrarCle.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()== views.bntRegistrarCle) {
                if (views.txtNombreCle.getText().equals("")
                        ||views.txtTelefonoCle.getText().equals("")
                         || views.txtDireccionCle.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todo los campos son obligatorios");
                    
                }else{
                      cl.setNombre(views.txtNombreCle.getText());
                      cl.setTelefono(views.txtTelefonoCle.getText());
                      cl.setDireccion(views.txtDireccionCle.getText());
                      if (clDao.registrar(cl)) {
                          JOptionPane.showMessageDialog(null, "Cliente registrado con exito");
                        
                    }else{
                          JOptionPane.showMessageDialog(null, "Error al registrar");    
                      }
                }
            
        }
    }
    
}
