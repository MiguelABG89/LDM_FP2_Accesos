package ExistDB.Entities;

public class Centro {
    private String Nombre;
    private int Codigo;
    private String Web;
    private String Correo;

    public Centro(String nombre, int codigo, String web, String correo) {
        Nombre = nombre;
        Codigo = codigo;
        Web = web;
        Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
