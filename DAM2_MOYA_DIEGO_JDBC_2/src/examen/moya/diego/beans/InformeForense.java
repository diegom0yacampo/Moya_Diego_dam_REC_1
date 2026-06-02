package examen.moya.diego.beans;

public class InformeForense {
    private int idInforme;
    private boolean adnPositivo;
    private int nivelRiesgo;
    private String conclusion;

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
