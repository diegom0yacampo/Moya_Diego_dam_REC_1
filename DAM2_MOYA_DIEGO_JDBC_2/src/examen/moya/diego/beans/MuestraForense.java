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
}
