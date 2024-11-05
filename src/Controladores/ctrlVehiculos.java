
package Controladores;

import Modelos.Vehiculo;
import Vistas.frmVehiculos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlVehiculos implements MouseListener{
    
    private Vehiculo Modelos;
    private frmVehiculos Vistas; 
    
    

    public ctrlVehiculos() {
        this.Modelos = Modelos;
        this.Vistas = Vistas;
        
        Vistas.btnAgregar.addMouseListener(this);
        Modelos.Mostrar(Vistas.jtVehiculo);
        Vistas.btnEliminar.addMouseListener(this);
        Vistas.jtVehiculo.addMouseListener(this);
        Vistas.btnActualizar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vistas.btnAgregar){
            Modelos.setNombre_Cliente(Vistas.txtNombre.getText());
            Modelos.setTelefono_Cliente(Vistas.txtTelefono.getText());
            Modelos.setMarca_Vehiculo(Vistas.txtMarca);
            Modelos.setAño_vehiculo(Vistas.txtAño);
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
