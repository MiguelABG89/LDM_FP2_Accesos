package ExistDB.Entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Centro")
@XmlType(propOrder = {"Nombre", "Codigo","Web", "Correo"})
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
    @XmlAttribute(name="Web")
    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }
    @XmlAttribute(name="Correo")
    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
