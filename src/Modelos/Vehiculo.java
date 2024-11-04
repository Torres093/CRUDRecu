package Modelos;

import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Vehiculo {

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getTelefono_Cliente() {
        return Telefono_Cliente;
    }

    public void setTelefono_Cliente(String Telefono_Cliente) {
        this.Telefono_Cliente = Telefono_Cliente;
    }

    public String getMarca_Vehiculo() {
        return Marca_Vehiculo;
    }

    public void setMarca_Vehiculo(String Marca_Vehiculo) {
        this.Marca_Vehiculo = Marca_Vehiculo;
    }

    public String getModelo_Vehiculo() {
        return Modelo_Vehiculo;
    }

    public void setModelo_Vehiculo(String Modelo_Vehiculo) {
        this.Modelo_Vehiculo = Modelo_Vehiculo;
    }

    public int getAño_vehiculo() {
        return año_vehiculo;
    }

    public void setAño_vehiculo(int año_vehiculo) {
        this.año_vehiculo = año_vehiculo;
    }

    public String getProblema() {
        return Problema;
    }

    public void setProblema(String Problema) {
        this.Problema = Problema;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    private String Nombre_Cliente; 
    private String Telefono_Cliente;
    private String Marca_Vehiculo;
    private String Modelo_Vehiculo; 
    private int año_vehiculo;
    private String Problema;
    private String Estado; 
    
    public void Mostrar(JTable tabla) {
        Connection conexion = (Connection) ClaseConexion.getConexion();
         DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"UUID_codigo", "Nombre_Estudiante", "Tipo_codigo", "carnet_estudiante"});
        try {
            Statement statement = conexion.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM tbCodigos");
             while (rs.next()) {
                modeloDeDatos.addRow(new Object[]{rs.getString("UUID_codigo"),
                    rs.getString("Nombre_Estudiante"),
                    rs.getString("Tipo_codigo"),
                    rs.getInt("carnet_estudiante")});
            }
 
            tabla.setModel(modeloDeDatos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    
    
    
    
}
