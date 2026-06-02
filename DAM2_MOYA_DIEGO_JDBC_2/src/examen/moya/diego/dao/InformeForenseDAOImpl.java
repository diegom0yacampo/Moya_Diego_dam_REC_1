package examen.moya.diego.dao;

import examen.moya.diego.beans.InformeForense;
import examen.moya.diego.motores.MotorSQL;

import java.sql.ResultSet;
import java.util.ArrayList;

public class InformeForenseDAOImpl
        extends AbstractDAO<InformeForense> {

    private static final String SQL_FIND_ALL =
            "SELECT * " +
                    "FROM informeforense " +
                    "ORDER BY idinforme";

    private static final String SQL_FIND =
            "SELECT * " +
                    "FROM informeforense " +
                    "WHERE idinforme = ?";

    private static final String SQL_INSERT =
            "INSERT INTO informeforense " +
                    "(" +
                    "adnpositivo, " +
                    "nivelriesgo, " +
                    "conclusion, " +
                    "autor_examen" +
                    ") " +
                    "VALUES " +
                    "(" +
                    "?, ?, ?, ?" +
                    ")";

    private static final String SQL_UPDATE =
            "UPDATE informeforense " +
                    "SET " +
                    "adnpositivo = ?, " +
                    "nivelriesgo = ?, " +
                    "conclusion = ? " +
                    "WHERE idinforme = ?";

    private static final String SQL_DELETE =
            "DELETE FROM informeforense " +
                    "WHERE idinforme = ?";

    private static final String AUTOR =
            "Moya_Diego_DAM2";

    public InformeForenseDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    @Override
    public void add(InformeForense informeForense) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_INSERT);
            motorSQL.getPs().setBoolean(1, informeForense.isAdnPositivo());
            motorSQL.getPs().setInt(2, informeForense.getNivelRiesgo());
            motorSQL.getPs().setString(3, informeForense.getConclusion());
            motorSQL.getPs().setString(4, AUTOR);

            int rows = motorSQL.executeUpdate();
            System.out.println("INSERTADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public void update(int id, InformeForense informeForense) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_UPDATE);
            motorSQL.getPs().setBoolean(1, informeForense.isAdnPositivo());
            motorSQL.getPs().setInt(2, informeForense.getNivelRiesgo());
            motorSQL.getPs().setString(3, informeForense.getConclusion());
            motorSQL.getPs().setInt(4, id);

            int rows = motorSQL.executeUpdate();
            System.out.println("ACTUALIZADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public void delete(int id) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_DELETE);
            motorSQL.getPs().setInt(1, id);

            int rows = motorSQL.executeUpdate();
            System.out.println("BORRADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public InformeForense find(int id) {
        InformeForense informeForense = null;

        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND);
            motorSQL.getPs().setInt(1, id);
            ResultSet rs = motorSQL.executeQuery();
            if (rs.next()) {
                informeForense = mapInformeForense(rs);
            }

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }

        return informeForense;
    }

    @Override
    public ArrayList<InformeForense> findAll() {
        ArrayList<InformeForense> informeForenses = new ArrayList<>();

        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_ALL);
            ResultSet rs = motorSQL.executeQuery();

            while (rs.next()) {
                informeForenses.add(mapInformeForense(rs));
            }

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }

        return informeForenses;
    }

    private InformeForense mapInformeForense(ResultSet rs) throws Exception {
        InformeForense informeForense = new InformeForense();

        informeForense.setIdInforme(rs.getInt("idinforme"));
        informeForense.setAdnPositivo(rs.getBoolean("adnpositivo"));
        informeForense.setNivelRiesgo(rs.getInt("nivelriesgo"));
        informeForense.setConclusion(rs.getString("conclusion"));

        return informeForense;
    }
}
