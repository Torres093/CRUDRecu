package Controladores;

import Modelos.Usuario; 
import Vistas.frmRegistro; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlRegistro implements MouseListener{
    
    Usuario Modelos; 
    frmRegistro Vistas; 

    public ctrlRegistro(Usuario Modelos, frmRegistro Vistas) {
        this.Modelos = Modelos;
        this.Vistas = Vistas;
        
        Vistas.btnAcceder.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vistas.btnAcceder){
            Modelos.setNombre_Cliente(Vistas.txtNombreReg.getText());
            Modelos.setCorreo_Cliente(Vistas.txtCorreo.getText());
            Modelos.setTelefono_Cliente(Vistas.txtTelefono.getText());
            Modelos.setEdad(Vistas.txtEdad.getText());
            Modelos.setContraseña(Modelos.convertirSHA256(Vistas.txtContraseña1.getText()));
            
            JOptionPane.showMessageDialog(Vistas, "Usuario Guardado");
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
    
}
