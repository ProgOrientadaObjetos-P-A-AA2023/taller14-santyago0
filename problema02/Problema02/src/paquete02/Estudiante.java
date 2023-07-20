package paquete02;

/**
 *
 * @author santy
 */
public class Estudiante {
    
    private String nombre;
    private String apellido;
    private double calificacion1;
    private double calificacion2;
    private double calificacion3;
    private double promedio;
    
    public Estudiante(String n, String a, double c1, double c2, double c3) {
        nombre = n;
        apellido = a;
        calificacion1 = c1;
        calificacion2 = c2;
        calificacion3 = c3;
    }
    
    public void establecerNombre(String n) {
        nombre = n;
    }
    
    public void establecerApellido(String a) {
        apellido = a;
    }
    
    public void establecerCalificacion1(double c) {
        calificacion1 = c;
    }
    
    public void establecerCalificacion2(double c) {
        calificacion2 = c;
    }
    
    public void establecerCalificacion3(double c) {
        calificacion3 = c;
    }
    
    public void calcularPromedio() {
        promedio = (calificacion1 + calificacion2 + calificacion3)/3;
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public String obtenerApellido() {
        return apellido;
    }
    
    public double obtenerCalificacion1() {
        return calificacion1;
    }
    
    public double obtenerCalificacion2() {
        return calificacion2;
    }
    
    public double obtenerCalificacion3() {
        return calificacion3;
    }
    
    public double obtenerPromedio() {
        return promedio;
    }
    
    @Override
    public String toString() {
        String cadena = String.format("%s %s\n"
                + "\tCalificaciones:\n"
                + "\t- %.2f\n"
                + "\t- %.2f\n"
                + "\t- %.2f\n"
                + "\tPromedio: %.2f\n\n",
                nombre,
                apellido,
                calificacion1,
                calificacion2,
                calificacion3,
                promedio);
        return cadena;
    }
    
}
