package Entidades;

public class Usuario {

    private int Id;

    private String Nombre;

    private String User;
    private String Clave;

    public Usuario(){

    }

    public Usuario(int id, String nombre,  String usuario, String clave) {
        Id = id;

        Nombre = nombre;

        User = usuario;
        Clave = clave;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }



    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }



    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

}
