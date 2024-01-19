package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "FAVOURITE", schema = "LDM_MySQL", catalog = "")
public class FavouriteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "IdProject", nullable = false)
    private Object idProject;
    @Basic
    @Column(name = "IdUser", nullable = false)
    private Object idUser;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getIdProject() {
        return idProject;
    }

    public void setIdProject(Object idProject) {
        this.idProject = idProject;
    }

    public Object getIdUser() {
        return idUser;
    }

    public void setIdUser(Object idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavouriteEntity that = (FavouriteEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idProject != null ? !idProject.equals(that.idProject) : that.idProject != null) return false;
        if (idUser != null ? !idUser.equals(that.idUser) : that.idUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idProject != null ? idProject.hashCode() : 0);
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        return result;
    }
}
