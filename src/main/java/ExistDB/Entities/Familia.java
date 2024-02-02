package ExistDB.Entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Familia")
@XmlType(propOrder = {"Nombre", "Codigo"})
public class Familia {
    private String Nombre;
    private int Codigo;

    public Familia(String nombre, int codigo) {
        Nombre = nombre;
        Codigo = codigo;
    }
    @XmlAttribute(name="Nombre")
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    @XmlAttribute(name="Codigo")
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }
}
