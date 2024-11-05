package Modelos;

import Vistas.frmVehiculos;
import javax.swing.JTable;
import java.sql.*;
import java.util.UUID;
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

    public String getUUID_Vehiculo() {
        return UUID_Vehiculo;
    }

    public void setUUID_Vehiculo(String UUID_Vehiculo) {
        this.UUID_Vehiculo = UUID_Vehiculo;
    }
    private String UUID_Vehiculo; 
    private String Nombre_Cliente; 
    private String Telefono_Cliente;
    private String Marca_Vehiculo;
    private String Modelo_Vehiculo; 
    private int año_vehiculo;
    private String Problema;
    private String Estado; 
    
    
    public void Guardar() {
    Connection conexion = ClaseConexion.getConexion(); 
   
    try{
        PreparedStatement addVehiculo = conexion.prepareStatement("INSERT INTO vehiculo (Nombre_Cliente, Telefono_Cliente, marca, modelo, año, estado, problema) VALUES (?, ?, ?, ?, ?, ?, ?)");
    addVehiculo.setString(1,UUID.randomUUID().toString());
    addVehiculo.setString(2, getNombre_Cliente());
    addVehiculo.setString(3, getTelefono_Cliente());
    addVehiculo.setString(4, getMarca_Vehiculo());
    addVehiculo.setString(5, getModelo_Vehiculo());
    addVehiculo.setString(6, getEstado());
    addVehiculo.setString(7, getProblema());
    
    addVehiculo.executeUpdate(); 
    
    
    }catch(SQLException ex){
         System.out.println("Este es el error: Guardar"+ ex);   
    }
   
            
    }
    
    public void Mostrar(JTable tabla){
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[] {"UUID_Vehiculo", "Nombre_Cliente", "Telefono_Cliente", "Marca_Vehiculo", "Modelo_Vehiculo", "año_vehiculo", "Problema", "Estado"});
        try{
            Statement statement = (Statement) conexion.createStatement();
           ResultSet rs = statement.executeQuery("SELECT * FROM vehiculo"); 
           while(rs.next()){
           modeloDeDatos.addRow(new Object[]{rs.getString(UUID_Vehiculo), 
           rs.getString("Nombre_Cliente"), 
           rs.getString("Telefono_Cliente"), 
           rs.getString("Marca_Vehiculo"),
           rs.getString("Estado"), 
           rs.getString("Problema")}); 
           }
           tabla.setModel(modeloDeDatos);
        } catch (Exception e){
            System.out.println("Este es el error" + e);
        }
    
    }
    
 
    public void Eliminar(JTable tabla){
    Connection conexion = ClaseConexion.getConexion();
    int filaSeleccionada = tabla.getSelectedRow();
    String miId = tabla.getValueAt(filaSeleccionada, 0). toString(); 
    
    
    try{
        PreparedStatement deleteVehiculo = conexion.prepareStatement("delete from vehiculos where UUID_Vehiculo");
        deleteVehiculo.setString(1, miId);
        deleteVehiculo.executeUpdate(); 
    }catch(Exception e){
          System.out.println("este es el error metodo de eliminar" + e);
    }
    }
    
    public void cargarDatostabla(frmVehiculos Vistas){
    int filaSeleccionada = Vistas.jtVehiculo.getSelectedRow(); 
    if (filaSeleccionada != -1){
    String UUID_Vehiculo = Vistas.jtVehiculo.getValueAt(filaSeleccionada, 0). toString();
    String Nombre_Cliente = Vistas.jtVehiculo.getValueAt(filaSeleccionada, 1). toString();
    String Telefono_Cliente = Vistas.jtVehiculo.getValueAt(filaSeleccionada, 2). toString();
    String Marca_Vehiculo = Vistas.jtVehiculo.getValueAt(filaSeleccionada, 3). toString();
    String Modelo_Vehiculo = Vistas.jtVehiculo.getValueAt(filaSeleccionada, 4). toString();
    String año_vehiculo = Vistas.jtVehiculo.getValueAt(filaSeleccionada, 5). toString();
    String Problema = Vistas.jtVehiculo.getValueAt(filaSeleccionada, 6). toString();
    String Estado = Vistas.jtVehiculo.getValueAt(filaSeleccionada, 7). toString(); 
    
    Vistas.txtNombre.setText(Nombre_Cliente);
    Vistas.txtTelefono.setText(Telefono_Cliente);
    Vistas.txtMarca.setText(Marca_Vehiculo);
    Vistas.txtModelo.setText(Modelo_Vehiculo);
    Vistas.txtProblema.setText(Problema);
    Vistas.txtProblema.setText(Estado);
        }
    }
    
    
    public void Actualizar(JTable tabla){
    Connection conexion = ClaseConexion.getConexion();
    
     int filaSeleccionada = tabla.getSelectedRow();
     if(filaSeleccionada != -1){
     String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();
     
     try{
     PreparedStatement updateUser = conexion.prepareStatement("update vehiculo set Nombre_Cliente = ?, Telefono_Cliente = ?, marca = ?, modelo = ?, año = ?, estado = ?, problema = ?" ); 
      updateUser.setString(1,getNombre_Cliente());
      updateUser.setString(2,getTelefono_Cliente());
      updateUser.setString(3,getMarca_Vehiculo());
      updateUser.setString(4,getModelo_Vehiculo());
      updateUser.setString(5,getProblema());
      updateUser.setString(6,getEstado());
      updateUser.executeUpdate(); 

     }catch(Exception e){
      System.out.println("este es el error en el metodo de actualizar" + e);
     }

     
     } else {
  System.out.println("no");
     }

    }
    
}
    
    
    
    
    

