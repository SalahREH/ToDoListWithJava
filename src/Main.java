import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;

import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;

public class Main{

    public static void main (String [ ] args) {
        JFrame frame = new FormList("My Form");
        frame.setVisible(true);
    }

}