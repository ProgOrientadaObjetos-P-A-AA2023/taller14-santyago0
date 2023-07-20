package paquete02;

/**
 *
 * @author santy
 */
public class Trabajador {
    
    private String nombres;
    private String cedula;
    private String correo;
    private double sueldo;
    private String mesSueldo;
    
    public Trabajador(String n, String c, String e, double s, String m) {
        nombres = n;
        cedula = c;
        correo = e;
        sueldo = s;
        mesSueldo = m;
    }
    
    public void establecerCedula(String c) {
        cedula = c;
    }
    
    public void establecerNombres(String n) {
        nombres = n;
    }
    
    public void establecerCorreo(String c) {
        correo = c;
    }
    
    public void establecerSueldo(double s) {
        sueldo = s;
    }
    
    public void establecerMesSueldo(String m) {
        mesSueldo = m;
    }
    
    public String obtenerCedula() {
        return cedula;
    }
    
    public String obtenerNombres() {
        return nombres;
    }
    
    public String obtenerCorreo() {
        return correo;
    }
    
    public double obtenerSueldo() {
        return sueldo;
    }
    
    public String obtenerMesSueldo() {
        return mesSueldo;
    }
    
    @Override
    public String toString() {
        String cadena = String.format("\tNombre: %s\n"
                + "\tCédula: %s\n"
                + "\tCorreo: %s\n"
                + "\tSueldo: $%.2f\n"
                + "\tMes del Sueldo: %s\n",
                nombres,
                cedula,
                correo,
                sueldo,
                mesSueldo);
        
        return cadena;
    }
    
}
