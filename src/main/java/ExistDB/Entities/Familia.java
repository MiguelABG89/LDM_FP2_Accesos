package ExistDB.Entities;

public class Familia {
    private String Nombre;
    private int Codigo;

    public Familia(String nombre, int codigo) {
        Nombre = nombre;
        Codigo = codigo;
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
}
