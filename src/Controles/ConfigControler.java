/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Vistas.PanelAdmin;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author M
 */
public class ConfigControler implements MouseListener{
    private PanelAdmin views;

    public ConfigControler(PanelAdmin views) {
        this.views = views;
        this.views.jLabelCategorias.addMouseListener(this);
        this.views.jLabelClientes.addMouseListener(this);
        this.views.jLabelConfiguracion.addMouseListener(this);
        this.views.jLabelMedidas.addMouseListener(this);
        this.views.jLabelNuevaCompra.addMouseListener(this);
        this.views.jLabelNuevaVenta.addMouseListener(this);
        this.views.jLabelProductos.addMouseListener(this);
        this.views.jLabelProvedores.addMouseListener(this);
        this.views.jLabelUsuarios.addMouseListener(this);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
         
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()== views.jLabelCategorias) {
          views.jPanelCategorias.setBackground(new Color(255,51,51));
        }else if (e.getSource()== views.jLabelClientes) {
          views.jPanelClientes.setBackground(new Color(255,51,51));
        }else if (e.getSource()== views.jLabelConfiguracion) {
          views.jPanelConfig.setBackground(new Color(255,51,51));
        }else if (e.getSource()== views.jLabelMedidas) {
          views.jPanelMedidas.setBackground(new Color(255,51,51));
        }else if (e.getSource()== views.jLabelNuevaCompra) {
          views.jPanelNuevaCompra.setBackground(new Color(255,51,51));
        }else if (e.getSource()== views.jLabelNuevaVenta) {
          views.jpanelNuevaVenta.setBackground(new Color(255,51,51));
        }else if (e.getSource()== views.jLabelProductos) {
          views.jPanelProductos.setBackground(new Color(255,51,51));
        }else if (e.getSource()== views.jLabelProvedores) {
          views.jPanelProvedor.setBackground(new Color(255,51,51));
        }else if (e.getSource()== views.jLabelUsuarios) {
          views.jpanelUsers.setBackground(new Color(255,51,51));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()== views.jLabelCategorias) {
          views.jPanelCategorias.setBackground(new Color(51,51,51));
        }else if (e.getSource()== views.jLabelClientes) {
          views.jPanelClientes.setBackground(new Color(51,51,51));
        }else if (e.getSource()== views.jLabelConfiguracion) {
          views.jPanelConfig.setBackground(new Color(51,51,51));
        }else if (e.getSource()== views.jLabelMedidas) {
          views.jPanelMedidas.setBackground(new Color(51,51,51));
        }else if (e.getSource()== views.jLabelNuevaCompra) {
          views.jPanelNuevaCompra.setBackground(new Color(51,51,51));
        }else if (e.getSource()== views.jLabelNuevaVenta) {
          views.jpanelNuevaVenta.setBackground(new Color(51,51,51));
        }else if (e.getSource()== views.jLabelProductos) {
          views.jPanelProductos.setBackground(new Color(51,51,51));
        }else if (e.getSource()== views.jLabelProvedores) {
          views.jPanelProvedor.setBackground(new Color(51,51,51));
        }else if (e.getSource()== views.jLabelUsuarios) {
          views.jpanelUsers.setBackground(new Color(51,51,51));
        }
        
        
    }
    
}
         
