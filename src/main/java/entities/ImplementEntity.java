package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "IMPLEMENT", schema = "LDM_MySQL", catalog = "")
public class ImplementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "IdProject", nullable = false)
    private Object idProject;
    @Basic
    @Column(name = "IdTechnology", nullable = false)
    private Object idTechnology;

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

    public Object getIdTechnology() {
        return idTechnology;
    }

    public void setIdTechnology(Object idTechnology) {
        this.idTechnology = idTechnology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImplementEntity that = (ImplementEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idProject != null ? !idProject.equals(that.idProject) : that.idProject != null) return false;
        if (idTechnology != null ? !idTechnology.equals(that.idTechnology) : that.idTechnology != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idProject != null ? idProject.hashCode() : 0);
        result = 31 * result + (idTechnology != null ? idTechnology.hashCode() : 0);
        return result;
    }
}
