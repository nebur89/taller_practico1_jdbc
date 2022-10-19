package nttdatacenters_jdbc_t1_RJBP;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author Rubén Barragán Pérez
 * */

public class App {
	
	
	
    public static void main( String[] args ) throws SQLException{
    	
    	conexionBdMysql();
    }
    
    
    /**
     * Metodo para la conexiona a base de datos de mysql 
     * */
    
    private static void conexionBdMysql()throws SQLException{
        
    	//Configuracion  conexion base de datos
    	final String host= "localhost";
    	final String port= "3306";
    	final String namedb= "nttdata_jdbc_ex";
    	final String coding= "characterEncoding=UTF-8";
    	final String usu= "root";
        final String pass = "1234";
        Connection conexion = null;
        Statement statement = null;
        
        
        try {
      
            conexion= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+namedb+"?"+coding, usu, pass);
            String slt = "select name from nttdata_mysql_soccer_player";
            statement =conexion.createStatement();
            ResultSet rs = statement.executeQuery(slt);
          
            
            while (rs.next()) {
             
                String nombre = rs.getString("name");
             
                System.out.println("nombre : " + nombre);
            }
       
        
        } 
        
        catch (SQLException e) {
        	
            System.out.println(e.getMessage());
        } 

    
        finally {
          
        	if (statement != null) {
                statement.close();
            }
            if (conexion != null) {
            	conexion.close();
            }
        
        
        
        }
    	
    	
    }
    
    
}
