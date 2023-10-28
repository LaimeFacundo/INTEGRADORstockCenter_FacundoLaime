package Util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author estudiante
 */
public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/IntegradorCersoStock?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("............. Conectado .......... ");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        return connection;

    }
}
