package ExistDB.Entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement(name="Centros")

public class Centros {
    private ArrayList<Centro> centros;

    public Centros() {
    }

    public Centros(ArrayList<Centro> centros) {
        this.centros = centros;
    }
    @XmlElementWrapper(name ="centros")
    @XmlElement(name="centro")
    public ArrayList<Centro> getCentros() {
        return centros;
    }

    public void setCentros(ArrayList<Centro> centros) {
        this.centros = centros;
    }
}
