import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FormList extends JFrame {
    private JButton AddButton;
    private JTextField taskInput;
    private JPanel mainPanel;
    private JTextArea tasksList;


    public FormList(String title, Connection connection) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        try {
            Statement stmt  = connection.createStatement();
            String sql = "SELECT * " + "FROM lists";

            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
                String titles = rs.getString("title");
                System.out.println(titles);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // INSERT INTO `lists` (`id`, `Title`) VALUES ('1', 'Comprar lejía'), ('2', 'Envenenar a todos con la lejía')
                //Statement state=conn.createStatement();
                //String s="insert into test values('male',100,'HHH')";
                //state.executeUpdate(s);
            }
        });

    }
}
