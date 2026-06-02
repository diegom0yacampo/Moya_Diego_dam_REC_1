package examen.moya.diego;

import examen.moya.diego.beans.MuestraForense;
import examen.moya.diego.beans.CentroForense;
import examen.moya.diego.beans.InformeForense;
import examen.moya.diego.dao.CentroForenseDAOImpl;
import examen.moya.diego.dao.MuestraForenseDAOImpl;
import examen.moya.diego.dao.InformeForenseDAOImpl;
import examen.moya.diego.motores.PostgreMotorSQL;

public class Main {
    public static void main(String[] args) {

        PostgreMotorSQL motorSQL = new PostgreMotorSQL();

        CentroForenseDAOImpl centroDAO = new CentroForenseDAOImpl(motorSQL);
        InformeForenseDAOImpl informeDAO = new InformeForenseDAOImpl(motorSQL);
        MuestraForenseDAOImpl muestraDAO = new MuestraForenseDAOImpl(motorSQL);


        System.out.println("TEST 1");
        CentroForense centro = centroDAO.find(1);
        InformeForense informe = informeDAO.find(1);

        MuestraForense muestra = new MuestraForense();
        muestra.setCodigoCaso(101);
        muestra.setTipoMuestra("Sangre");
        muestra.setFechaRecogida("2025-06-10");
        muestra.setEstadoCustodia(true);
        muestra.setCentro(centro);
        muestra.setInforme(informe);
        muestraDAO.add(muestra);


        System.out.println("TEST 2");
        MuestraForense muestraUpd = new MuestraForense();
        muestraUpd.setCodigoCaso(101);
        muestraUpd.setTipoMuestra("Sangre (Actualizada)");
        muestraUpd.setFechaRecogida("2025-06-10");
        muestraUpd.setEstadoCustodia(true);
        muestraUpd.setCentro(centro);
        muestraUpd.setInforme(informe);
        muestraDAO.update(1, muestraUpd);


        System.out.println("TEST 3");
        MuestraForense muestraBuscada = muestraDAO.find(1);
        System.out.println(muestraBuscada);


        System.out.println("TEST 4");
        for (MuestraForense m : muestraDAO.findAll()) {
            System.out.println(m);
        }


        System.out.println("TEST 5");
        for (MuestraForense m : muestraDAO.findByCentro(1)) {
            System.out.println(m);
        }


        System.out.println("TEST 6");
        MuestraForense conInforme = muestraDAO.findMuestraConInforme(1);
        System.out.println(conInforme);
        System.out.println(
                "INFORME: " +
                        conInforme.getInforme().getConclusion() +
                        " / ADN Positivo: " +
                        conInforme.getInforme().isAdnPositivo());

    }
}
