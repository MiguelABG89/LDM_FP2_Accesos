package dtos;

public class NewUser {

    private String Login;
    private String UserName;
    private String Surname;
    private String Email;
    private String LinkedIn;
    private int IdEntity;


    public NewUser() {
    }

    public NewUser(String login, String userName, String surname, String email, String linkedIn, int idEntity) {
        Login = login;
        UserName = userName;
        Surname = surname;
        Email = email;
        LinkedIn = linkedIn;
        IdEntity = idEntity;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLinkedIn() {
        return LinkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        LinkedIn = linkedIn;
    }

    public int getIdEntity() {
        return IdEntity;
    }

    public void setIdEntity(int idEntity) {
        IdEntity = idEntity;
    }
}
