package paquete01;

import java.util.Scanner;
import paquete02.*;

/**
 *
 * @author santy
 */
public class Principal {

    public static void main(String[] args) {
        // Variables para utilizar en el programa
        Scanner sc = new Scanner(System.in); 
        boolean flag = true;
        String respuesta;
        String nombre;
        String cedula;
        String correo;
        double sueldo;
        String mesSueldo;
        
        // Creación del objeto de tipo Enlace
        Enlace link = new Enlace();
        
        // Proceso del ingreso de los datos para generar los objetos de tipo
        // Trabajador en un ciclo repetitivo hasta que el usuario quiera
        do {
            System.out.println("---[Ingresar Información de Trabajadores]---");
            System.out.print("Ingrese el nombre del Trabajador: ");
            nombre = sc.nextLine();
            
            System.out.print("Ingrese la cédula del Trabajador: ");
            cedula = sc.nextLine();
            
            System.out.print("Ingrese el correo del Trabajador: ");
            correo = sc.nextLine();
            
            System.out.print("Ingrese el sueldo del Trabajador: ");
            sueldo = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Ingrese el mes en el que fue pagado: ");
            mesSueldo = sc.nextLine();
            
            System.out.print("\nDesea ingresar otro Trabajador.\nDigite N para "
                    + "salir, y cualquier otra letra para continuar: ");
            respuesta = sc.nextLine();
            
            // Creación del objeto de tipo Trabajador con los datos ingresados
            // por teclado
            Trabajador t = new Trabajador(nombre,cedula,correo,sueldo,
                    mesSueldo);

            // Ingresar el Tabajador a la base de datos
            link.insertarTrabajador(t);

            // Crear la lista de trabajadores con los datos ingresados a la base
            // de datos
            link.establecerListaTrabajadores();
            System.out.println();
            
            if(respuesta.toLowerCase().equals("n")) {
                flag = false;
                
                System.out.println("\nLista de Trabajadores:");
                
                for(int i = 0; i < link.obtenerListaTrabajadores().size(); i++) {
                    System.out.printf("Trabajador (%d)\n%s",i+1,
                            link.obtenerListaTrabajadores().get(i));
                }
            }
            
        } while (flag);
    }
    
}
