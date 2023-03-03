import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CUpdateList {

    public DefaultListModel Update(ResultSet rs, DefaultListModel titles){
       titles.clear();
        try{
            while (rs.next()) {
                String title = rs.getString("title");
                titles.addElement(title);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return titles;
    }
}
