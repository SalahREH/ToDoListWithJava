import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CData {

    public ResultSet getData(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT title " + "FROM lists";
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int getLastId(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            String sqlId = "SELECT id " + "FROM lists";
            ResultSet rsIds = stmt.executeQuery(sqlId);
            int lastId = 0;
            while (rsIds.next()) {
                lastId = rsIds.getInt("id");
            }
            return lastId;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
