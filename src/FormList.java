import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FormList extends JFrame {
    private JButton AddButton;
    private JTextField taskInput;
    private JPanel mainPanel;

    private JButton deleteButton;
    private JList tasksList;
    private JButton EditButton;
//    private JTextPane tasksList;

    public FormList(String formTitle, Connection connection) {
        super(formTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        CData CData = new CData();
        CUpdateList update = new CUpdateList();
        DefaultListModel titles = new DefaultListModel();


        ResultSet rs = CData.getData(connection);
        tasksList.setModel(update.Update(rs, titles));


        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskText = taskInput.getText();
                String sql = "INSERT INTO `lists` (`id`, `Title`) VALUES (?, ?)";
                try {
                    PreparedStatement preparedStmt = connection.prepareStatement(sql);

                    int lastId = CData.getLastId(connection);
                    preparedStmt.setInt(1, lastId + 1);
                    preparedStmt.setString(2, taskText);
                    preparedStmt.execute();
                    ResultSet rs = CData.getData(connection);
                    tasksList.setModel(update.Update(rs, titles));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                // INSERT INTO `lists` (`id`, `Title`) VALUES ('1', 'Comprar lejía'), ('2', 'Envenenar a todos con la lejía')
                //Statement state=conn.createStatement();
                //String s="insert into test values('male',100,'HHH')";
                //state.executeUpdate(s);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(tasksList.getSelectedValue());
                String sql = "DELETE FROM lists WHERE title = ?";
                try {
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    String selectedTitle = (String) tasksList.getSelectedValue();
                    stmt.setString(1, selectedTitle);
                    stmt.executeUpdate();

                    ResultSet rs = CData.getData(connection);
                    tasksList.setModel(update.Update(rs, titles));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        EditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "UPDATE lists SET title = ? WHERE title = ?";
                String selectedTitle = (String) tasksList.getSelectedValue();
                String taskText = taskInput.getText();
                try {
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1, taskText);
                    stmt.setString(2, selectedTitle);
                    stmt.executeUpdate();

                    ResultSet rs = CData.getData(connection);
                    tasksList.setModel(update.Update(rs, titles));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }


}
