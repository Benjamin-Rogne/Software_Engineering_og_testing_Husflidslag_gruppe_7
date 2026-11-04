package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://itstud.hiof.no:3306/se26_G7";

    private static final String USER = "gruppe7";
    private static final String PASSWORD = "Summer27";

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL, USER, PASSWORD
        );
    }
}