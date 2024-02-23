package ExistDB.Entities;

import jakarta.xml.bind.annotation.XmlElement;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
@XmlRootElement(name="Proyectos")
@XmlType(propOrder = {"proyectos"})
public class Proyectos {
    private ArrayList<Proyecto> proyectos;

    public Proyectos() {
    }

    public Proyectos(ArrayList<Proyecto> listProyectos) {
        this.proyectos = listProyectos;
    }
    @XmlElement(name="Proyecto")
    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

}
