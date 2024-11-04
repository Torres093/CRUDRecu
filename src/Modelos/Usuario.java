package Modelos;

public class Usuario {

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public int getTelefono_Cliente() {
        return Telefono_Cliente;
    }

    public void setTelefono_Cliente(int Telefono_Cliente) {
        this.Telefono_Cliente = Telefono_Cliente;
    }

    public String getVehiculo() {
        return Vehiculo;
    }

    public void setVehiculo(String Vehiculo) {
        this.Vehiculo = Vehiculo;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getAño_Vehiculo() {
        return Año_Vehiculo;
    }

    public void setAño_Vehiculo(String Año_Vehiculo) {
        this.Año_Vehiculo = Año_Vehiculo;
    }

    public String getProblema() {
        return Problema;
    }

    public void setProblema(String Problema) {
        this.Problema = Problema;
    }

    public String getEstado_problema() {
        return Estado_problema;
    }

    public void setEstado_problema(String Estado_problema) {
        this.Estado_problema = Estado_problema;
    }
    private String Nombre_Cliente;
    private int Telefono_Cliente;
    private String Vehiculo;
    private String Modelo;
    private String Año_Vehiculo;
    private String Problema; 
    private String Estado_problema; 
}
