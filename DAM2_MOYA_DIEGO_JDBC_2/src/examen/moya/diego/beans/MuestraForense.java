package examen.moya.diego.beans;

public class MuestraForense {
    private int idMuestra;
    private int codigoCaso;
    private String tipoMuestra;
    private String fechaRecogida;
    private boolean estadoCustodia;
    private CentroForense centro;
    private InformeForense informe;

    public MuestraForense() {
    }

    public MuestraForense(int codigoCaso, String tipoMuestra, String fechaRecogida, boolean estadoCustodia, CentroForense centro, InformeForense informe) {
        this.codigoCaso = codigoCaso;
        this.tipoMuestra = tipoMuestra;
        this.fechaRecogida = fechaRecogida;
        this.estadoCustodia = estadoCustodia;
        this.centro = centro;
        this.informe = informe;
    }

    public MuestraForense(int idMuestra, int codigoCaso, String tipoMuestra, String fechaRecogida, boolean estadoCustodia, CentroForense centro, InformeForense informe) {
        this.idMuestra = idMuestra;
        this.codigoCaso = codigoCaso;
        this.tipoMuestra = tipoMuestra;
        this.fechaRecogida = fechaRecogida;
        this.estadoCustodia = estadoCustodia;
        this.centro = centro;
        this.informe = informe;
    }

    @Override
    public String toString() {
        return "MuestraForense{" +
                "idMuestra=" + idMuestra +
                ", codigoCaso=" + codigoCaso +
                ", tipoMuestra='" + tipoMuestra + '\'' +
                ", fechaRecogida='" + fechaRecogida + '\'' +
                ", estadoCustodia=" + estadoCustodia +
                ", centro=" + centro +
                ", informe=" + informe +
                '}';
    }

    public int getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(int idMuestra) {
        this.idMuestra = idMuestra;
    }

    public int getCodigoCaso() {
        return codigoCaso;
    }

    public void setCodigoCaso(int codigoCaso) {
        this.codigoCaso = codigoCaso;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }

    public String getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(String fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public boolean isEstadoCustodia() {
        return estadoCustodia;
    }

    public void setEstadoCustodia(boolean estadoCustodia) {
        this.estadoCustodia = estadoCustodia;
    }

    public CentroForense getCentro() {
        return centro;
    }

    public void setCentro(CentroForense centro) {
        this.centro = centro;
    }

    public InformeForense getInforme() {
        return informe;
    }

    public void setInforme(InformeForense informe) {
        this.informe = informe;
    }
}
