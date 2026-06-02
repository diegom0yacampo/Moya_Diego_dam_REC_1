package examen.moya.diego.beans;

import java.util.ArrayList;

public class CentroForense {
    private int idCentro;
    private String nombre;
    private String pais;
    private int nivelSeguridad;

    ArrayList<MuestraForense> lstMuestraForense;

    public CentroForense() {
    }

    public CentroForense(String nombre, String pais, int nivelSeguridad) {
        this.nombre = nombre;
        this.pais = pais;
        this.nivelSeguridad = nivelSeguridad;
    }

    public CentroForense(int idCentro, String nombre, String pais, int nivelSeguridad) {
        this.idCentro = idCentro;
        this.nombre = nombre;
        this.pais = pais;
        this.nivelSeguridad = nivelSeguridad;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNivelSeguridad() {
        return nivelSeguridad;
    }

    public void setNivelSeguridad(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }

    @Override
    public String toString() {
        return "CentroForense{" +
                "idCentro=" + idCentro +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", nivelSeguridad=" + nivelSeguridad +
                ", lstMuestraForense=" + lstMuestraForense +
                '}';
    }
}
