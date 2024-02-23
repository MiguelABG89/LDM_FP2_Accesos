package ExistDB.Entities;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
@XmlRootElement(name="Centro")
@XmlType(propOrder = {"nombre", "codigo","web", "correoElectronico"})
public class Centro {
    private String nombre;
    private int codigo;
    private String web;
    private String correoElectronico;

    public Centro() {
    }

    public Centro(String nombre, int codigo, String web, String correo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.web = web;
        correoElectronico = correo;
    }
    @XmlElement(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement(name="codigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    @XmlElement(name="web")
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    @XmlElement(name="correoElectronico")
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
