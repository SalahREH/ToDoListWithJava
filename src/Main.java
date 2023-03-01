import Connection.CConnection;
import javax.swing.*;
import java.sql.*;
public class Main{


    public static void main (String [ ] args) {
        CConnection conn = new CConnection();
        Connection connection = null;

        try {
            connection = conn.getConnection();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        JFrame frame = new FormList("My Form", connection);
        frame.setVisible(true);
    }

}