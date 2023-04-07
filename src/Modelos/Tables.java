
package Modelos;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class Tables extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(
            JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         super.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
         
       if (jtable.getValueAt(row, column).toString().equals("Inactivo")){
               setBackground(Color.red);
            
        }else{
           setBackground(Color.white);
         }
           return this;
    }
    }
