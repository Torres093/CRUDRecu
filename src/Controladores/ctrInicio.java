package Controladores;

import Modelos.Usuario;
import Vistas.frmInicio;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrInicio implements MouseListener{
    
    Usuario Modelos; 
    frmInicio Vistas;

    public ctrInicio(Usuario Modelo, frmInicio Vista ) {
        this.Modelos = Modelo; 
        this.Vistas = Vista; 
        
        Vistas.btnLog.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Modelos.setCorreo_Cliente(Vistas.txtCorreo.getText());
        Modelos.setContraseña(Modelos.convertirSHA256(Vistas.txtContraseña.getText()));
        
       boolean comprobar = Modelos.iniciarSesion(); 
       if(comprobar == true ) {
           JOptionPane.showMessageDialog(Vistas,"El Usuario existe, Bienvenido");
           
       }else {
       JOptionPane.showMessageDialog(Vistas, "Usuario no encontrado");
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
