package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "FAMILY", schema = "LDM_MySQL", catalog = "")
public class FamilyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "FamilyCode", nullable = true, length = 20)
    private String familyCode;
    @Basic
    @Column(name = "FamilyName", nullable = false, length = 50)
    private String familyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyEntity that = (FamilyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (familyCode != null ? !familyCode.equals(that.familyCode) : that.familyCode != null) return false;
        if (familyName != null ? !familyName.equals(that.familyName) : that.familyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (familyCode != null ? familyCode.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        return result;
    }
}
