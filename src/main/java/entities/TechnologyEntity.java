package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TECHNOLOGY", schema = "LDM_MySQL", catalog = "")
public class TechnologyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "Tag", nullable = false, length = 50)
    private String tag;
    @Basic
    @Column(name = "TechName", nullable = true, length = 70)
    private String techName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TechnologyEntity that = (TechnologyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (techName != null ? !techName.equals(that.techName) : that.techName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (techName != null ? techName.hashCode() : 0);
        return result;
    }
}
