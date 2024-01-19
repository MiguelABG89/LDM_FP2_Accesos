package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "IMPLEMENT", schema = "LDM_MySQL", catalog = "")
public class ImplementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "IdProject", nullable = false)
    private Long idProject;
    @Basic
    @Column(name = "IdTechnology", nullable = false)
    private Long idTechnology;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public Long getIdTechnology() {
        return idTechnology;
    }

    public void setIdTechnology(Long idTechnology) {
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
