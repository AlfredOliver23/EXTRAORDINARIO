
package Control;

import Modelo.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

/**
 *
 * @author user
 */
public class AccionesPropietario {
    
    /**
     * son todas las acciones o requerimetos funcionales 
     * con los que operarar el sistema
     * 
     * registrar Empleado -> Empleado e
     * Actualizar Empleado -> Empleado e
     * eliminarEmpleado -> int id
     * BuscarEmpleadoporID -> int id
     * buscarTodoslosEmpleados -> arraylist necesitamos su dinamicidad ya que admite dif valores
     * VerifivarUsuario -> String user, pass
     */
    
          private Connection connection;
          
      private PreparedStatement selectLoginStatement;
      
       private final String selectLogin = 
            "SELECT * FROM propietario WHERE correo = ?";
       
      
    
      
        public AccionesPropietario(Connection connection, ServletContext context){
        this.connection = connection;
        
         try{
         this.selectLoginStatement = 
                    this.connection.prepareStatement(this.selectLogin);
   
}catch(Exception e){
            System.out.println("Error en el crud");
            System.out.println("Error " + e.getMessage());
        }
        
        }
    
    
    public static int registrarPropietario(Propietario p) {
         int estatus = 0;

         try {
            Connection con = Conexion.getConnection();
            String q = "insert into propietario(correo ,nombre ,appat ,apmat, dir, password) "
                    + "values(?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter & setters
            
            ps.setString(1, p.getCorreo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getAppat());
            ps.setString(4, p.getApmat());
            ps.setString(5, p.getDir());
            ps.setString(6, p.getPass());
            
            
            estatus = ps.executeUpdate();
             System.out.println("Registro exitoso del propietario");
             con.close();
            
        } catch (Exception ed) {                
             System.out.println("Error al registrar propietario");
             System.out.println(ed.getMessage());
        }
         return estatus;
        }
    
    
    public static int actualizarPropietario(Propietario p) {
         int estatus = 0;
         try {
            Connection con = Conexion.getConnection();
            String q = "update propietario set correo = ? ,nombre = ?,appat = ?,"
                    + "apmat = ?, dir = ?, password = ?"
                    + "where id_propietario = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter & setters
            
            ps.setString(1, p.getCorreo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getAppat());
            ps.setString(4, p.getApmat());
            ps.setString(5, p.getDir());
            ps.setString(6, p.getPass());
            ps.setInt(7, p.getId_pro());
            
            estatus = ps.executeUpdate();
             System.out.println("Actualizacion Exitosa del empleado exitoso del propietario");
             con.close();
            
        } catch (Exception ed) {                
             System.out.println("Error al regisrtra propietarios");
             System.out.println(ed.getMessage());
        }
         return estatus;
        }
    
    
    public static int borrarPropietario(int id_pro) {
         int estatus = 0;
         try {
            Connection con = Conexion.getConnection();
            String q = "detele from propietario where id_propietario =?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter & setters
            
            ps.setInt(1, id_pro);
            
            
            estatus = ps.executeUpdate();
             System.out.println("borrado exitoso del propietario");
             con.close();
            
        } catch (Exception ed) {                
             System.out.println("Error al borrar propietario");
             System.out.println(ed.getMessage());
        }
         return estatus;
        
    
    
}
    
    
    public static Propietario buscarPropietarioById(int id_pro){
        Propietario p = new Propietario();
        try {
            Connection con = Conexion.getConnection();
            String q = "select * from propietario where id_propietario = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id_pro);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setId_pro(rs.getInt(1));
                p.setCorreo(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setApmat(rs.getString(4));
                p.setApmat(rs.getString(5));
                p.setDir(rs.getString(6));
                p.setPass(rs.getString(7));     
            }
            System.out.println("Usuario Encontrado");
            con.close();
        } catch (Exception ed) {
            System.out.println("Error al buscar Propietario");
            System.out.println(ed.getMessage());
        }
        return p;
    }
    
    public static List<Propietario> buscarAllPropietarios() {
        List<Propietario> lista = new ArrayList<Propietario>();
        

         try {
            Connection con = Conexion.getConnection();
            String q = "select * from propietario";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                Propietario p = new Propietario();
 
                 p.setId_pro(rs.getInt(1));
                 p.setCorreo(rs.getString(2));
                 p.setNombre(rs.getString(3));
                 p.setAppat(rs.getString(4));
                 p.setApmat(rs.getString(5));
                 p.setDir(rs.getString(6));
                 p.setPass(rs.getString(7));
                 
                 lista.add(p);
                 
                 
             }
            
             System.out.println("Propietario encontrado");
             con.close();
            
        } catch (Exception ed) {                
             System.out.println("Error al buscar a los Propietario");
             System.out.println(ed.getMessage());
        }
         return lista;

}
    
    public Propietario login(Propietario propietario) throws SQLException{
        this.selectLoginStatement.setString(1, propietario.getCorreo());
        
        ResultSet rs = this.selectLoginStatement.executeQuery();
        
        if(rs.next() && rs.getString("password")!=null){
            propietario.getPass();
            rs.getString("password");
            
            System.out.println("Funciona wiiii");
            
            Propietario propietarioLogin = new Propietario(
                    
                    rs.getString("correo"),
                    rs.getString("nombre"),
                    rs.getString("appat"),
                    rs.getString("apmat"),
                    rs.getString("dir"),
                    rs.getString("password")
            );
            
            return propietarioLogin;
            
        }
        return null;
    }
    
    public static Propietario login(String usuario, String contrasena) {
    Propietario propietario = null;
    try {
        Connection con = Conexion.getConnection();
        String query = "SELECT * FROM empleados WHERE nom_emp = ? AND pass_emp = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, usuario);
        ps.setString(2, contrasena);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            propietario = new Propietario();
            propietario.setId(rs.getInt(1));
            propietario.setNombre(rs.getString(2));
            propietario.setPassword(rs.getString(3));
            propietario.setEmail(rs.getString(4));
            propietario.setPais(rs.getString(5));
        }
        con.close();
    } catch (Exception e) {
        System.out.println("Error al iniciar sesión del empleado");
        System.out.println(e.getMessage());
    }
    return propietario;
}
}