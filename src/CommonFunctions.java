import javax.swing.*;
import java.awt.*;

public class CommonFunctions {
    public CommonFunctions() {

    }

    public JButton createButton(String text, int x, int y) {
        JButton b = new JButton(text);
        b.setSize(x, y);
        b.setPreferredSize(new Dimension(x, y));
        b.setVisible(true);
        return b;
    }

    public JFrame createFrame(String name, int x, int y) {
        JFrame frame = new JFrame(name);
        frame.setSize(x, y);
        frame.setResizable(false);


        return frame;
    }

    public JPanel createPanel(int x, int y) {
        JPanel Panel = new JPanel();
        Panel.setVisible(true);
        Panel.setLayout(null);
        Panel.setSize(x, y);
        return Panel;
    }

    public JTable createTable(int x, int y) {
        JTable table = new JTable();
        table.setVisible(true);
        table.setLayout(null);
        table.setSize(x, y);
        return table;
    }

    public JLabel addingBackgroundPhoto(String fileLocation, int x, int y) {
        ImageIcon pic = new ImageIcon(fileLocation);
        JLabel l = new JLabel(pic);
        l.setSize(x, y);
        return l;
    }
}