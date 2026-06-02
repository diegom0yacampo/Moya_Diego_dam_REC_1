package examen.moya.diego.dao;

import examen.moya.diego.beans.CentroForense;
import examen.moya.diego.beans.InformeForense;
import examen.moya.diego.beans.MuestraForense;
import examen.moya.diego.motores.MotorSQL;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MuestraForenseDAOImpl
        extends AbstractDAO<MuestraForense> {

    private static final String SQL_FIND_ALL =
            "SELECT * " +
                    "FROM muestraforense " +
                    "ORDER BY idmuestra";

    private static final String SQL_FIND =
            "SELECT * " +
                    "FROM muestraforense " +
                    "WHERE idmuestra = ?";

    private static final String SQL_INSERT =
            "INSERT INTO muestraforense " +
                    "(" +
                    "codigocaso, " +
                    "tipomuestra, " +
                    "fecharecogida, " +
                    "estadocustodia, " +
                    "centro_id, " +
                    "informe_id, " +
                    "autor_examen" +
                    ") " +
                    "VALUES " +
                    "(" +
                    "?, ?, ?, ?, ?, ?, ?" +
                    ")";

    private static final String SQL_UPDATE =
            "UPDATE muestraforense " +
                    "SET " +
                    "codigocaso = ?, " +
                    "tipomuestra = ?, " +
                    "fecharecogida = ?, " +
                    "estadocustodia = ?, " +
                    "centro_id = ?, " +
                    "informe_id = ? " +
                    "WHERE idmuestra = ?";

    private static final String SQL_DELETE =
            "DELETE FROM muestraforense " +
                    "WHERE idmuestra = ?";

    private static final String SQL_FIND_BY_CENTRO =
            "SELECT * " +
                    "FROM muestraforense " +
                    "WHERE centro_id = ? " +
                    "ORDER BY idmuestra";

    private static final String SQL_MUESTRA_CON_INFORME =
            "SELECT " +
                    "M.idmuestra, " +
                    "M.codigocaso, " +
                    "M.tipomuestra, " +
                    "M.fecharecogida, " +
                    "M.estadocustodia, " +
                    "M.centro_id, " +
                    "I.idinforme, " +
                    "I.adnpositivo, " +
                    "I.nivelriesgo, " +
                    "I.conclusion " +
                    "FROM muestraforense M " +
                    "INNER JOIN informeforense I " +
                    "ON M.informe_id = I.idinforme " +
                    "WHERE M.idmuestra = ?";

    private static final String AUTOR =
            "Moya_Diego_DAM2";

    public MuestraForenseDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    @Override
    public void add(MuestraForense muestraForense) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_INSERT);
            motorSQL.getPs().setInt(1, muestraForense.getCodigoCaso());
            motorSQL.getPs().setString(2, muestraForense.getTipoMuestra());
            motorSQL.getPs().setString(3, muestraForense.getFechaRecogida());
            motorSQL.getPs().setBoolean(4, muestraForense.isEstadoCustodia());
            motorSQL.getPs().setInt(5, muestraForense.getCentro().getIdCentro());
            motorSQL.getPs().setInt(6, muestraForense.getInforme().getIdInforme());
            motorSQL.getPs().setString(7, AUTOR);

            int rows = motorSQL.executeUpdate();
            System.out.println("INSERTADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public void update(int id, MuestraForense muestraForense) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_UPDATE);
            motorSQL.getPs().setInt(1, muestraForense.getCodigoCaso());
            motorSQL.getPs().setString(2, muestraForense.getTipoMuestra());
            motorSQL.getPs().setString(3, muestraForense.getFechaRecogida());
            motorSQL.getPs().setBoolean(4, muestraForense.isEstadoCustodia());
            motorSQL.getPs().setInt(5, muestraForense.getCentro().getIdCentro());
            motorSQL.getPs().setInt(6, muestraForense.getInforme().getIdInforme());
            motorSQL.getPs().setInt(7, id);

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
    public MuestraForense find(int id) {
        MuestraForense muestraForense = null;

        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND);
            motorSQL.getPs().setInt(1, id);
            ResultSet rs = motorSQL.executeQuery();
            if (rs.next()) {
                muestraForense = mapMuestraForense(rs);
            }

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }

        return muestraForense;
    }

    @Override
    public ArrayList<MuestraForense> findAll() {
        ArrayList<MuestraForense> muestraForenses = new ArrayList<>();

        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_ALL);
            ResultSet rs = motorSQL.executeQuery();

            while (rs.next()) {
                muestraForenses.add(mapMuestraForense(rs));
            }

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }

        return muestraForenses;
    }

    public ArrayList<MuestraForense> findByCentro(int centroId) {
        ArrayList<MuestraForense> muestraForenses = new ArrayList<>();

        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_BY_CENTRO);
            motorSQL.getPs().setInt(1, centroId);
            ResultSet rs = motorSQL.executeQuery();

            while (rs.next()) {
                muestraForenses.add(mapMuestraForense(rs));
            }

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }

        return muestraForenses;
    }

    public MuestraForense findMuestraConInforme(int id) {
        MuestraForense muestraForense = null;

        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_MUESTRA_CON_INFORME);
            motorSQL.getPs().setInt(1, id);
            ResultSet rs = motorSQL.executeQuery();

            if (rs.next()) {
                muestraForense = new MuestraForense();
                muestraForense.setIdMuestra(rs.getInt("idmuestra"));
                muestraForense.setCodigoCaso(rs.getInt("codigocaso"));
                muestraForense.setTipoMuestra(rs.getString("tipomuestra"));
                muestraForense.setFechaRecogida(rs.getString("fecharecogida"));
                muestraForense.setEstadoCustodia(rs.getBoolean("estadocustodia"));

                InformeForense informe = new InformeForense();
                informe.setIdInforme(rs.getInt("idinforme"));
                informe.setAdnPositivo(rs.getBoolean("adnpositivo"));
                informe.setNivelRiesgo(rs.getInt("nivelriesgo"));
                informe.setConclusion(rs.getString("conclusion"));

                muestraForense.setInforme(informe);
            }

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }

        return muestraForense;
    }

    private MuestraForense mapMuestraForense(ResultSet rs) throws Exception {
        MuestraForense muestraForense = new MuestraForense();

        muestraForense.setIdMuestra(rs.getInt("idmuestra"));
        muestraForense.setCodigoCaso(rs.getInt("codigocaso"));
        muestraForense.setTipoMuestra(rs.getString("tipomuestra"));
        muestraForense.setFechaRecogida(rs.getString("fecharecogida"));
        muestraForense.setEstadoCustodia(rs.getBoolean("estadocustodia"));

        return muestraForense;
    }
}
