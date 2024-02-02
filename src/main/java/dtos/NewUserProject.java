package dtos;

import java.sql.Blob;
import java.util.Date;

public class NewUserProject {

    private String Title;
    private Blob Logo;
    private String Web;
    private String Description;
    private String State;
    private Date InitDate;
    private Date EndDate;
    private int IdUser;
    private int IdFamily;
    private boolean IsManager;

    public NewUserProject() {
    }

    public NewUserProject(String title, Blob logo, String web, String description, String state, Date initDate, Date endDate) {
        Title = title;
        Logo = logo;
        Web = web;
        Description = description;
        State = state;
        InitDate = initDate;
        EndDate = endDate;
    }

    public NewUserProject(int idUser, int idFamily, boolean isManager) {
        IdUser = idUser;
        IdFamily = idFamily;
        IsManager = isManager;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Blob getLogo() {
        return Logo;
    }

    public void setLogo(Blob logo) {
        Logo = logo;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public Date getInitDate() {
        return InitDate;
    }

    public void setInitDate(Date initDate) {
        InitDate = initDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public int getIdFamily() {
        return IdFamily;
    }

    public void setIdFamily(int idFamily) {
        IdFamily = idFamily;
    }

    public boolean isManager() {
        return IsManager;
    }

    public void setManager(boolean manager) {
        IsManager = manager;
    }
}
