package paquete01;

import paquete02.*;

/**
 *
 * @author santy
 */
public class Principal {

    public static void main(String[] args) {
        // Creación del objeto de tipo Enlace
        Enlace link = new Enlace();
        link.establecerListaEstudiantes();
        
        // Ciclo for para recorrer la lista obtenida de la base de datos
        for(int i = 0; i < link.obtenerListaEstudiantes().size(); i++) {
            System.out.printf("%s",link.obtenerListaEstudiantes().
                    get(i));
        }
    }
    
}
