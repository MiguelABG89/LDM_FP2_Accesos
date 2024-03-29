package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;

@Entity
@Table(name = "PROJECT", schema = "LDM_MySQL", catalog = "")
public class ProjectEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "Title", nullable = false, length = 50)
    private String title;
    @Basic
    @Column(name = "Logo", nullable = true)
    private byte[] logo;
    @Basic
    @Column(name = "Web", nullable = true, length = 100)
    private String web;
    @Basic
    @Column(name = "ProjectDescription", nullable = true, length = -1)
    private String projectDescription;
    @Basic
    @Column(name = "State", nullable = false, length = 20)
    private String state;
    @Basic
    @Column(name = "InitDate", nullable = true)
    private Date initDate;
    @Basic
    @Column(name = "EndDate", nullable = true)
    private Date endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectEntity that = (ProjectEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (!Arrays.equals(logo, that.logo)) return false;
        if (web != null ? !web.equals(that.web) : that.web != null) return false;
        if (projectDescription != null ? !projectDescription.equals(that.projectDescription) : that.projectDescription != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (initDate != null ? !initDate.equals(that.initDate) : that.initDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(logo);
        result = 31 * result + (web != null ? web.hashCode() : 0);
        result = 31 * result + (projectDescription != null ? projectDescription.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (initDate != null ? initDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
