package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ENTITY", schema = "LDM_MySQL", catalog = "")
public class EntityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "EntityName", nullable = false, length = 50)
    private String entityName;
    @Basic
    @Column(name = "EntityCode", nullable = true, length = 20)
    private String entityCode;
    @Basic
    @Column(name = "Web", nullable = true, length = 100)
    private String web;
    @Basic
    @Column(name = "Email", nullable = true, length = 70)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityEntity that = (EntityEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (entityName != null ? !entityName.equals(that.entityName) : that.entityName != null) return false;
        if (entityCode != null ? !entityCode.equals(that.entityCode) : that.entityCode != null) return false;
        if (web != null ? !web.equals(that.web) : that.web != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (entityName != null ? entityName.hashCode() : 0);
        result = 31 * result + (entityCode != null ? entityCode.hashCode() : 0);
        result = 31 * result + (web != null ? web.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
