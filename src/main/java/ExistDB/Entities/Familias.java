package ExistDB.Entities;


import jakarta.xml.bind.annotation.XmlElement;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
@XmlRootElement(name="familias")
@XmlType(propOrder = {"familias"})
public class Familias {
    private ArrayList<Familia> familias;

    public Familias() {
    }

    public Familias(ArrayList<Familia> listFamilias) {
        this.familias = listFamilias;
    }
    @XmlElement(name="familia")
    public ArrayList<Familia> getFamilias() {
        return familias;
    }

    public void setFamilias(ArrayList<Familia> familias) {
        this.familias = familias;
    }
}
