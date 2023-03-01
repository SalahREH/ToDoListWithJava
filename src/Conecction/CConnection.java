package Conecction;

import java.sql.*;

public class CConnection {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}