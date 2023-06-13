/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlMascota;

import Control.Conexion;
import Modelo.Mascota;
import Modelo.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class AccionesMascota {
    
    
    public static int registrarMascota(Mascota m) {
         int estatus = 0;
         try {
            Connection con = Conexion.getConnection();
            String q = "insert into perro(propietario_id ,raza_id ,nacimiento, nombre, imagen"
                    + ", tamano, peso, sexo) "
                    + "values(?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter & setters
            
            ps.setInt(1, m.getPropietario_id());
            ps.setInt(2, m.getRaza());
            ps.setTimestamp(3, m.getNacimiento());
            ps.setString(4, m.getNombre_mas());
            ps.setBlob(5, m.getImagen_per());
            ps.setInt(6, m.getTamano());
            ps.setInt(7, m.getPeso());            
            ps.setString(8, m.getSexo());
            
           
            
            
            estatus = ps.executeUpdate();
             System.out.println("Registro exitoso del perro");
             con.close();
            
        } catch (Exception ed) {                
             System.out.println("Error al regisrtra perro");
             System.out.println(ed.getMessage());
        }
         return estatus;
        }
    
    
    public static int actualizarPerrp(Mascota m) {
         int estatus = 0;
         try {
            Connection con = Conexion.getConnection();
            String q = "update perro set propietario_id = ?,raza_id = ?,nacimiento = ?, nombre = ?, imagen = ?"
                    + ", tamano = ?, peso = ?, sexo = ?"
                    + "where mascota_id = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter & setters
            
            ps.setInt(1, m.getPropietario_id());
            ps.setInt(2, m.getRaza());
            ps.setTimestamp(3, m.getNacimiento());
            ps.setString(4, m.getNombre_mas());
            ps.setBlob(5, m.getImagen_per());
            ps.setInt(6, m.getTamano());
            ps.setInt(7, m.getPeso());            
            ps.setString(8, m.getSexo());
            ps.setInt(9, m.getMascota_id());
            
            estatus = ps.executeUpdate();
             System.out.println("Actualizacion Exitosa del empleado exitoso del perro");
             con.close();
            
        } catch (Exception ed) {                
             System.out.println("Error al regisrtra perro");
             System.out.println(ed.getMessage());
        }
         return estatus;
        }
    
    
    public static int borrarMascota(int mascota_id) {
         int estatus = 0;
         try {
            Connection con = Conexion.getConnection();
            String q = "detele from perro where mascota_id =?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter & setters
            
            ps.setInt(1, mascota_id);
            
            
            estatus = ps.executeUpdate();
             System.out.println("borrado exitoso de la masctoa");
             con.close();
            
        } catch (Exception ed) {                
             System.out.println("Error al borrar mascota");
             System.out.println(ed.getMessage());
        }
         return estatus;
        
    
    
}
    
    
    public static Mascota buscarMascotaById(int mascota_id) {
    Mascota m = new Mascota();
    try {
        Connection con = Conexion.getConnection();
        String query = "SELECT * FROM perro WHERE mascota_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, mascota_id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            m.setMascota_id(rs.getInt("mascota_id"));
            m.setPropietario_id(rs.getInt("propietario_id"));
            m.setRaza(rs.getInt("raza"));
            m.setNacimiento(rs.getTimestamp("nacimiento"));
            m.setNombre_mas(rs.getString("nombre_mas"));
            m.setImagen_per(rs.getBlob("imagen_per"));
            m.setTamano(rs.getInt("tamano"));
            m.setPeso(rs.getInt("peso"));
            m.setSexo(rs.getString("sexo"));
            System.out.println("Mascota encontrada");
        } else {
            System.out.println("No se encontró ninguna mascota con el ID especificado");
        }

        con.close();
    } catch (Exception e) {
        System.out.println("Error al buscar mascota");
        System.out.println(e.getMessage());
    }
    return m;
}

    
    public static List<Mascota> buscarAllPerros() {
        List<Mascota> lista = new ArrayList<Mascota>();
        
        
         
         try {
            Connection con = Conexion.getConnection();
            String q = "select * from perro";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                Mascota m = new Mascota();
 
                 m.setMascota_id(rs.getInt(1));
                 m.setPropietario_id(rs.getInt(2));
                 m.setRaza(rs.getInt(3));
                 m.setNacimiento(rs.getTimestamp(4));
                 m.setNombre_mas(rs.getString(5));
                 m.setImagen_per(rs.getBlob(6));
                 m.setTamano(rs.getInt(7));
                 m.setPeso(rs.getInt(8));
                 m.setSexo(rs.getString(9));
                 
                 lista.add(m);
                 
                 
             }
            
             System.out.println("Perro encontrado");
             con.close();
            
        } catch (Exception ed) {                
             System.out.println("Error al buscar a los perro");
             System.out.println(ed.getMessage());
        }
         return lista;
    /*
    public Propietario verificarCredenciales(String correo, String pass){
        try {
            Connection con = Conexion.getConnection();
            String q = "select * from propietarios where correo = ? and password = ?";
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, correo);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            
             if (rs.next()) {
            int id = rs.getInt("id_propietario");
            String correo = rs.getString("correo");
            String nombre = rs.getString("nombre");
            String appat = rs.getString("appat");
            String apmat = rs.getString("apmat");
            String dir = rs.getString("dir");
            String password = rs.getString("password");
            
            Propietario propietario = new Propietario(id, correo, nombre, appat, apmat, dir, password);
            con.close();
            return propietario;
            
        } catch (Exception e) {
                System.out.println("Error al verificar Credenciales");
                System.out.println(e.getMessage());
                }
        }
        return null; */
    }
            
    
    
}

