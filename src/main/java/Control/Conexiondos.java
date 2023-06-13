/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;

/**
 *
 * @author user
 */
public class Conexiondos {
    
    
    private static Connection connection;
    
    //definimos el constructor de la clase
    private Conexiondos(){
    
    }
    
    public static Connection getConnection(ServletContext context){
        if(connection == null){
            try{
                String url = context.getInitParameter("http://localhost:3306/mascotas");
                String user = context.getInitParameter("root");
                String password = context.getInitParameter("n0m3l0");
                //definimos el driver de mysql
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                connection = DriverManager.getConnection(url, user, password);
                
                
            }catch(SQLException | ClassNotFoundException e){
                System.out.println("No conecto a la BD");
                System.out.println("Error : " + e.getMessage());
                
            }
        }
        return connection;
    }
}
