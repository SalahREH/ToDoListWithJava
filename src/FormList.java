import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormList extends JFrame {
    private JButton button1;
    private JTextField textField1;
    private JPanel mainPanel;
    private JButton button2;
    private JTextArea textArea1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;


    public FormList(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hola");
        }
    });

}
}
