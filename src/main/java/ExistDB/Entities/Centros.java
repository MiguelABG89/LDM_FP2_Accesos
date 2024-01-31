package ExistDB.Entities;

import java.util.ArrayList;

public class Centros {
    private ArrayList<Centro> listCentros;

    public Centros() {
    }

    public Centros(ArrayList<Centro> listCentros) {
        this.listCentros = listCentros;
    }

    public ArrayList<Centro> getListCentros() {
        return listCentros;
    }

    public void setListCentros(ArrayList<Centro> listCentros) {
        this.listCentros = listCentros;
    }
}
