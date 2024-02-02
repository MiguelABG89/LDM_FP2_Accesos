package ExistDB.Entities;


import jakarta.xml.bind.annotation.XmlElement;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
@XmlRootElement(name="Centros")
@XmlType(propOrder = {"centros"})

public class Centros {
    private ArrayList<Centro> centros;

    public Centros() {
    }

    public Centros(ArrayList<Centro> centros) {
        this.centros = centros;
    }
    @XmlElement(name="Centro")
    public ArrayList<Centro> getCentros() {
        return centros;
    }

    public void setCentros(ArrayList<Centro> centros) {
        this.centros = centros;
    }
}
