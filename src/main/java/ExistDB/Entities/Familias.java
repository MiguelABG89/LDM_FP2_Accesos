package ExistDB.Entities;

import java.util.ArrayList;

public class Familias {
    private ArrayList<Familia> listFamilias;

    public Familias() {
    }

    public Familias(ArrayList<Familia> listFamilias) {
        this.listFamilias = listFamilias;
    }

    public ArrayList<Familia> getListFamilias() {
        return listFamilias;
    }

    public void setListFamilias(ArrayList<Familia> listFamilias) {
        this.listFamilias = listFamilias;
    }
}
