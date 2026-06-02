package examen.moya.diego.dao;

import examen.moya.diego.beans.CentroForense;

import java.sql.ResultSet;
import java.util.ArrayList;
public class CentroForenseDAOImpl
            extends AbstractDAO<CentroForense> {

        private static final String SQL_FIND_ALL =
                "SELECT * " +
                        "FROM centroforense " +
                        "ORDER BY id";

        private static final String SQL_FIND =
                "SELECT * " +
                        "FROM centroforense " +
                        "WHERE id = ?";

        private static final String SQL_INSERT =
                "INSERT INTO centroforense " +
                        "(" +
                        "id, " +
                        "nombre, " +
                        "pais, " +
                        "nivelseguridad, " +
                        "autor_examen" +
                        ") " +
                        "VALUES " +
                        "(" +
                        "?, ?, ?, ?, ?" +
                        ")";

        private static final String SQL_UPDATE =
                "UPDATE \"nombre, \" + " +
                        "SET " +
                        "nombre = ?, " +
                        "pais = ?, " +
                        "nivelseguridad = ?, " +
                        "WHERE id = ?";

        private static final String SQL_DELETE =
                "DELETE FROM centroforense " +
                        "WHERE id = ?";

        private static final String AUTOR =
                "Moya_Diego_DAM2";

        public CentroForenseDAOImpl(
                MotorSQL motorSQL) {
            super(motorSQL);
        }


        @Override
        public void add(CentroForense centroforense) {
            try {
                motorSQL.connect();
                motorSQL.prepare(SQL_INSERT);
                motorSQL.getPs().setString(1, centroforense.getNombre());
                motorSQL.getPs().setString(2, centroforense.getPais());
                motorSQL.getPs().setString(3, centroforense.getnivelseguridad());
                motorSQL.getPs().setString(4, AUTOR);

                int rows = motorSQL.executeUpdate();
                System.out.println(
                        "INSERTADOS: " + rows);

            } catch (Exception e) {

                printError(e);

            } finally {

                motorSQL.close();
            }
        }

        @Override
        public void update(
                int id,
                CentroForense centroforense) {
            try {
                motorSQL.connect();
                motorSQL.prepare(SQL_UPDATE);
                motorSQL.getPs().setString(
                        1,
                        centroforense.getNombre());
                motorSQL.getPs().setString(
                        2,
                        centroforense.getPais());
                motorSQL.getPs().setString(
                        3,
                        centroforense.getnivelseguridad());
                motorSQL.getPs().setInt(
                        4,
                        id);
                int rows =
                        motorSQL.executeUpdate();
                System.out.println(
                        "ACTUALIZADOS: " + rows);
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

                motorSQL.getPs().setInt(
                        1,
                        id);

                int rows =
                        motorSQL.executeUpdate();

                System.out.println(
                        "BORRADOS: " + rows);

            } catch (Exception e) {

                printError(e);

            } finally {

                motorSQL.close();
            }
        }

        @Override
        public CentroForense find(int id) {

            CentroForense centroforense = null;

            try {
                motorSQL.connect();
                motorSQL.prepare(SQL_FIND);
                motorSQL.getPs().setInt(
                        1,
                        id);
                ResultSet rs =
                        motorSQL.executeQuery();
                if (rs.next()) {

                    centroforense =
                            mapCentroForense(rs);
                }

            } catch (Exception e) {

                printError(e);

            } finally {

                motorSQL.close();
            }

            return CentroForense;
        }

        @Override
        public ArrayList<CentroForense> findAll() {

            ArrayList<CentroForense> centroforensees =
                    new ArrayList<>();

            try {

                motorSQL.connect();

                motorSQL.prepare(SQL_FIND_ALL);

                ResultSet rs =
                        motorSQL.executeQuery();

                while (rs.next()) {

                    centroforensees.add(
                            mapCentroForense(rs));
                }

            } catch (Exception e) {

                printError(e);

            } finally {

                motorSQL.close();
            }

            return centroforensees;
        }

        /*
         MAPPING
         */

        private CentroForense mapCentroForense(
                ResultSet rs)
                throws Exception {

            CentroForense centroforense = new CentroForense();

            centroforense.setId(
                    rs.getInt("id"));

            centroforense.setNombre(
                    rs.getString("nombre"));

            centroforense.setPais(
                    rs.getString("pais"));

            centroforense.setnivelseguridad(
                    rs.getString("nivel_seguridad"));

            return centroforense;
        }
    }
}
