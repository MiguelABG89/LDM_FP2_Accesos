package ExistDB.Entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement(name="Proyectos")
public class Proyectos {
    private ArrayList<Proyecto> proyectos;

    public Proyectos() {
    }

    public Proyectos(ArrayList<Proyecto> listProyectos) {
        this.proyectos = listProyectos;
    }
    @XmlElementWrapper(name ="proyectos")
    @XmlElement(name="proyecto")
    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

}
