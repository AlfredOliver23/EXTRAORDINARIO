package Modelo;

public class Propietario {
    int id_pro;
    private String correo, nombre, appat, apmat, dir, pass;
    
    public Propietario() {
        
    }
    
    public Propietario(String correo, String nombre, String appat, String apmat, String dir, String password) {
        
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
