package examen.moya.diego.beans;

public class InformeForense {
    private int idInforme;
    private boolean adnPositivo;
    private int nivelRiesgo;
    private String conclusion;

    public InformeForense() {
    }

    public InformeForense(boolean adnPositivo, int nivelRiesgo, String conclusion) {
        this.adnPositivo = adnPositivo;
        this.nivelRiesgo = nivelRiesgo;
        this.conclusion = conclusion;
    }

    public InformeForense(int idInforme, boolean adnPositivo, int nivelRiesgo, String conclusion) {
        this.idInforme = idInforme;
        this.adnPositivo = adnPositivo;
        this.nivelRiesgo = nivelRiesgo;
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        return "InformeForense{" +
                "idInforme=" + idInforme +
                ", adnPositivo=" + adnPositivo +
                ", nivelRiesgo=" + nivelRiesgo +
                ", conclusion='" + conclusion + '\'' +
                '}';
    }

    public int getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(int idInforme) {
        this.idInforme = idInforme;
    }

    public boolean isAdnPositivo() {
        return adnPositivo;
    }

    public void setAdnPositivo(boolean adnPositivo) {
        this.adnPositivo = adnPositivo;
    }

    public int getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(int nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
