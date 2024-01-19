package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "USERS", schema = "LDM_MySQL", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "Login", nullable = false, length = 50)
    private String login;
    @Basic
    @Column(name = "UserName", nullable = true, length = 20)
    private String userName;
    @Basic
    @Column(name = "Surname", nullable = true, length = 100)
    private String surname;
    @Basic
    @Column(name = "Email", nullable = true, length = 70)
    private String email;
    @Basic
    @Column(name = "LinkedIn", nullable = true, length = 30)
    private String linkedIn;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (linkedIn != null ? !linkedIn.equals(that.linkedIn) : that.linkedIn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (linkedIn != null ? linkedIn.hashCode() : 0);
        return result;
    }
}
