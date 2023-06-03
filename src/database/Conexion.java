package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    private final String DRIVER = "com.mysgl.jdbc.Driver"; 
    private final String URL = "jdbc:mysqgl://localhost:3306/"; 
    private final String DB = "dbsistemaussdda";
    private final String USUARIO = "root";
    private final String PASSWORD = "";
    
    public Connection con;
    public static Conexion instancia;
    
    private Conexion(){
        this.con=null;
    }
    
    public Connection conectar() {
        try{
            Class.forName (DRIVER);
            this.con = DriverManager.getConnection(URL+DB,  USUARIO, PASSWORD);
            System.out.println("Conectado!");
            

         } catch ClassNotFoundException | SQLException e){
             System.out.println(e.getMessage());
             System.exit(0);
         }
        return con;
    }
    
    
    public void desconectar() {
        try {
            this.con.close();
            System.out.println("Desconectado!");
        } catch (SQLException e){
             System.out.println(e.getMessage());
        }
    }
}
    