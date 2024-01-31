package ExistDB.Entities;

public class Proyecto {
    private String CENTROCOORDINADOR;
    private String TÍTULODELPROYECTO;
    private String AUTORIZACIÓN;
    private String CONTINUIDAD;
    private String COORDINACIÓN;
    private String CONTACTO;
    private String CENTROSANEXIONADOS;

    public Proyecto(String CENTROCOORDINADOR, String TÍTULODELPROYECTO, String AUTORIZACIÓN, String CONTINUIDAD, String COORDINACIÓN, String CONTACTO, String CENTROSANEXIONADOS) {
        this.CENTROCOORDINADOR = CENTROCOORDINADOR;
        this.TÍTULODELPROYECTO = TÍTULODELPROYECTO;
        this.AUTORIZACIÓN = AUTORIZACIÓN;
        this.CONTINUIDAD = CONTINUIDAD;
        this.COORDINACIÓN = COORDINACIÓN;
        this.CONTACTO = CONTACTO;
        this.CENTROSANEXIONADOS = CENTROSANEXIONADOS;
    }

    public String getCENTROCOORDINADOR() {
        return CENTROCOORDINADOR;
    }

    public void setCENTROCOORDINADOR(String CENTROCOORDINADOR) {
        this.CENTROCOORDINADOR = CENTROCOORDINADOR;
    }

    public String getTÍTULODELPROYECTO() {
        return TÍTULODELPROYECTO;
    }

    public void setTÍTULODELPROYECTO(String TÍTULODELPROYECTO) {
        this.TÍTULODELPROYECTO = TÍTULODELPROYECTO;
    }

    public String getAUTORIZACIÓN() {
        return AUTORIZACIÓN;
    }

    public void setAUTORIZACIÓN(String AUTORIZACIÓN) {
        this.AUTORIZACIÓN = AUTORIZACIÓN;
    }

    public String getCONTINUIDAD() {
        return CONTINUIDAD;
    }

    public void setCONTINUIDAD(String CONTINUIDAD) {
        this.CONTINUIDAD = CONTINUIDAD;
    }

    public String getCOORDINACIÓN() {
        return COORDINACIÓN;
    }

    public void setCOORDINACIÓN(String COORDINACIÓN) {
        this.COORDINACIÓN = COORDINACIÓN;
    }

    public String getCONTACTO() {
        return CONTACTO;
    }

    public void setCONTACTO(String CONTACTO) {
        this.CONTACTO = CONTACTO;
    }

    public String getCENTROSANEXIONADOS() {
        return CENTROSANEXIONADOS;
    }

    public void setCENTROSANEXIONADOS(String CENTROSANEXIONADOS) {
        this.CENTROSANEXIONADOS = CENTROSANEXIONADOS;
    }
}
