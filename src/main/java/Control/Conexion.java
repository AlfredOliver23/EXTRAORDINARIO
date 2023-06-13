
package Control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class Conexion {
    
    public static Connection getConnection(){
        String url, username, password;
        
        url = "jdbc:mysql://localhost:3306/mascotas";
        username = "root";
        password = "batiziano2023";
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Se pudo conectar a la base de datos mascotil");
        } catch (Exception e) {
            
            System.out.println("Error al conectar a la bd");
            System.out.println(e.getMessage());
        }
        return con;
        }
}
