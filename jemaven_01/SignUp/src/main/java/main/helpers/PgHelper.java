package main.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PgHelper {
    public static Connection createConnection() throws SQLException {
        final String URL_STRING = "jdbc:postgresql://localhost:5432/CursoJava";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "brbr109br");
        return DriverManager.getConnection(URL_STRING, props);
    }
}
