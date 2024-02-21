package code.dtos;

public class NewEntity {
    private String EntityName;
    private String EntityCode;
    private String Web;
    private String Email;

    public NewEntity() {
    }

    public NewEntity(String entityName, String entityCode, String web, String email) {
        EntityName = entityName;
        EntityCode = entityCode;
        Web = web;
        Email = email;
    }

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String entityName) {
        EntityName = entityName;
    }

    public String getEntityCode() {
        return EntityCode;
    }

    public void setEntityCode(String entityCode) {
        EntityCode = entityCode;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
