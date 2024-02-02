package ExistDB.Entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement(name="Familias")

public class Familias {
    private ArrayList<Familia> familias;

    public Familias() {
    }

    public Familias(ArrayList<Familia> listFamilias) {
        this.familias = listFamilias;
    }
    @XmlElementWrapper(name ="familias")
    @XmlElement(name="familia")
    public ArrayList<Familia> getFamilias() {
        return familias;
    }

    public void setFamilias(ArrayList<Familia> familias) {
        this.familias = familias;
    }
}
