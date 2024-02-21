package code.dtos;

import java.sql.Blob;
import java.util.Date;

public class NewUserProject {
    private String titulo;
    private Blob logo;
    private String web;
    private String description;
    private String state;
    private Date initDate;
    private Date endDate;
    private int idUser;
    private int idFamily;
    private boolean isManager;

    public NewUserProject() {
    }

    public NewUserProject(String titulo, Blob logo, String web, String description, String state, Date initDate, Date endDate) {
        this.titulo = titulo;
        this.logo = logo;
        this.web = web;
        this.description = description;
        this.state = state;
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public NewUserProject(int idUser, int idFamily, boolean isManager) {
        this.idUser = idUser;
        this.idFamily = idFamily;
        this.isManager = isManager;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Blob getLogo() {
        return logo;
    }
    public void setLogo(Blob logo) {
        this.logo = logo;
    }

    public String getWeb() {
        return web;
    }
    public void setWeb(String web) {
        this.web = web;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public Date getInitDate() {
        return initDate;
    }
    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(int idFamily) {
        this.idFamily = idFamily;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
}
