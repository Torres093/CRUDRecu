package Modelos;

import java.sql.*;
import java.beans.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.table.DefaultTableModel;
import java.util.UUID;


public class Usuario {

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }



  
 
    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getCorreo_Cliente() {
        return Correo_Cliente;
    }

    public void setCorreo_Cliente(String Correo_Cliente) {
        this.Correo_Cliente = Correo_Cliente;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getUUID_Usuario() {
        return UUID_Usuario;
    }

    public void setUUID_Usuario(String UUID_Usuario) {
        this.UUID_Usuario = UUID_Usuario;
    }
    
    

    public String getTelefono_Cliente() {
        return Telefono_Cliente;
    }

    public void setTelefono_Cliente(String Telefono_Cliente) {
        this.Telefono_Cliente = Telefono_Cliente;
    }
    
    private String UUID_Usuario;
    private String Nombre_Cliente;
    private String Telefono_Cliente;
    private String Edad;
    private String Correo_Cliente;
    private String Contraseña; 
   
    public void GuardarUsuario () {
    Connection conexion = ClaseConexion.getConexion();
    try {
         PreparedStatement addUsuario = conexion.prepareStatement("INSERT INTO Clientes(cliente_id, nombre, telefono, correo_electronico, edad, contraseña) VALUES (?, ?, ?, ?, ?, ?)"); 
         addUsuario.setString(1, UUID.randomUUID().toString());
         addUsuario.setString(2, getNombre_Cliente());
         addUsuario.setString(3, getTelefono_Cliente()); 
         addUsuario.setString(4, getEdad()); 
         addUsuario.setString(5, getCorreo_Cliente()); 
         addUsuario.setString(6, getContraseña());
         
         addUsuario.executeUpdate(); 

    }  catch(SQLException ex){
        System.out.println("El error es el siguiente: Metodo guardar" + ex); 
    }
    
    
    
    }
    
    
    
    public boolean iniciarSesion(){
    Connection conexion = ClaseConexion.getConexion(); 
    boolean resultado = false;
    try{
        String sql = "SELECT * FROM Clientes WHERE Correo_Cliente = ? AND Contraseña = ?"; 
        PreparedStatement statement = conexion.prepareStatement(sql); 
        statement.setString(1, getCorreo_Cliente());
        statement.setString(2, getContraseña());
        
        ResultSet resultSet = statement.executeQuery(); 
        if(resultSet.next()){
           resultado = true; 
        }
    
    }catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }
     return resultado;
    }
    
    public String convertirSHA256(String password) {
    MessageDigest md = null; 
    try{
       md = MessageDigest.getInstance("SHA-256"); 
       
    }
    catch(NoSuchAlgorithmException e){
        System.out.println(e.toString()); 
        return null; 
    
    }
    byte[] hash = md.digest(password.getBytes()); 
    StringBuffer sb = new StringBuffer(); 
    
    for(byte b : hash){
            sb.append(String.format("%02x", b)); 
    }
    return sb.toString();
    }
    
    
}
    
    


