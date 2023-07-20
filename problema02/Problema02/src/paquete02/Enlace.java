package paquete02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author santy
 */
public class Enlace {
    private Connection conn;
    private ArrayList<Estudiante> listaEstudiantes;
       
    public void establecerConexion() {
        try {  
            String url = "jdbc:sqlite:bd/base001.base";
            conn = DriverManager.getConnection(url); 
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    }
    
    public Connection obtenerConexion(){
        return conn;
    }
    
    public void insertarEstudiante(Estudiante es) {
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            
            String data = String.format("INSERT INTO estudiante (nombre, "
                    + "apellido, calificacion1, calificacion2, calificacion3) "
                    + "values ('%s', '%s', '%.2f', '%.2f', '%.2f')",
                    es.obtenerNombre(),
                    es.obtenerApellido(),
                    es.obtenerCalificacion1(),
                    es.obtenerCalificacion2(),
                    es.obtenerCalificacion3());
            
            statement.executeUpdate(data);
            obtenerConexion().close();
            
        } catch (SQLException e) {  
             System.out.println("Exception: insertarEstudiante");
             System.out.println(e.getMessage());
        }  
    }
    
    public void establecerListaEstudiantes() {  
        listaEstudiantes = new ArrayList<>();
        
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            
            String data = "Select * from estudiante;";
            ResultSet rs = statement.executeQuery(data);
            
            while(rs.next()){
                Estudiante e = new Estudiante(rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDouble("calificacion1"),
                        rs.getDouble("calificacion2"),
                        rs.getDouble("calificacion3"));
                
                e.calcularPromedio();
                listaEstudiantes.add(e);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarEstudiante");
             System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Estudiante> obtenerListaEstudiantes() {
        return listaEstudiantes;
    }
    
}
