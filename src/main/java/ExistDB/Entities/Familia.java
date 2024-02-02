package ExistDB.Entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name="Familia")
@XmlType(propOrder = {"nombre"})
public class Familia {
    private String nombre;
    private int codigo;

    public Familia() {
    }

    public Familia(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    @XmlElement(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlAttribute(name="value")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
