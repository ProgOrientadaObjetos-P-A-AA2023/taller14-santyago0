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
    private ArrayList<Trabajador> listaTrabajadores;
    
    public void establecerConexion() {
        try {  
            String url = "jdbc:sqlite:bd/trabajadores.bd";
            conn = DriverManager.getConnection(url); 
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    }
    
    public Connection obtenerConexion(){
        return conn;
    }
    
    public void insertarTrabajador(Trabajador t) {
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            
            String data = String.format("INSERT INTO Trabajador (nombres, "
                    + "cedula, correo, sueldo, mesSueldo) "
                    + "values ('%s', '%s', '%s', '%.2f', '%s')",
                    t.obtenerNombres(),
                    t.obtenerCedula(),
                    t.obtenerCorreo(),
                    t.obtenerSueldo(),
                    t.obtenerMesSueldo());
            
            statement.executeUpdate(data);
            obtenerConexion().close();
            
        } catch (SQLException e) {  
             System.out.println("Exception: insertarTrabajador");
             System.out.println(e.getMessage());
        }  
    }
    
    public void establecerListaTrabajadores() {  
        listaTrabajadores = new ArrayList<>();
        
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            
            String data = "Select * from Trabajador;";
            ResultSet rs = statement.executeQuery(data);
            
            while(rs.next()){
                Trabajador t = new Trabajador(rs.getString("nombres"),
                        rs.getString("cedula"),
                        rs.getString("correo"),
                        rs.getDouble("sueldo"),
                        rs.getString("mesSueldo"));
                
                listaTrabajadores.add(t);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarTrabajador");
             System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Trabajador> obtenerListaTrabajadores() {
        return listaTrabajadores;
    }
    
}
