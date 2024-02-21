package code.dtos;

public class NewFamily {
    private String FamillyCode;
    private String FamilyName;

    public NewFamily() {
    }

    public NewFamily(String famillyCode, String familyName) {
        FamillyCode = famillyCode;
        FamilyName = familyName;
    }

    public String getFamillyCode() {
        return FamillyCode;
    }

    public void setFamillyCode(String famillyCode) {
        FamillyCode = famillyCode;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }
}
