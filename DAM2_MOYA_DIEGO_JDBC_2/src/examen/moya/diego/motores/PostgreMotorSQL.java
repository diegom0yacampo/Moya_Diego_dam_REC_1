package examen.moya.diego.motores;

import java.sql.DriverManager;

public class PostgreMotorSQL extends MotorSQL {
    private static final String URL =
            "jdbc:postgresql://database-1.coraqr44sxin.us-east-1.rds.amazonaws.com:5432/moya_diego_dam";
    private static final String USER =
            "postgres";
    private static final String PASSWORD =
            "12345678";
    private static final String DRIVER =
            "org.postgresql.Driver";

    public PostgreMotorSQL() {
        super(
                URL,
                USER,
                PASSWORD,
                DRIVER
        );
    }

    @Override
    public void connect() {
        try {
            Class.forName(driver);
            conn =
                    DriverManager.getConnection(
                            url,
                            user,
                            password
                    );
            System.out.println(
                    "CONEXION OK");
        } catch (Exception e) {
            System.out.println(
                    e.getMessage());
        }
    }
}
