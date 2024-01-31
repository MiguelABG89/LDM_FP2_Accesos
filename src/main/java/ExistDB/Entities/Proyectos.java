package ExistDB.Entities;

import java.util.ArrayList;

public class Proyectos {
    private ArrayList<Proyecto> listProyectos;

    public Proyectos() {
    }

    public Proyectos(ArrayList<Proyecto> listProyectos) {
        this.listProyectos = listProyectos;
    }

    public ArrayList<Proyecto> getListProyectos() {
        return listProyectos;
    }

    public void setListProyectos(ArrayList<Proyecto> listProyectos) {
        this.listProyectos = listProyectos;
    }

}
