package Connection;

import java.sql.*;

public class CConnection {
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");
        System.out.println("Conexión exitosa");
        return connection;
    }
}