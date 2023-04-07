import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class MainPanel {
    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;
    private CommonFunctions funct = new CommonFunctions();
    private List <String> Columns = new ArrayList<>(Arrays.asList("id", "Imie", "NrSwiadectwa", "Nazwisko", "Data Urodzenia", "Miejsce Urodzenia", "Data Śmierci", "Miejsce Śmierci", "Nr Aktu Zgonu", "Wydanego", "Płeć", "Data", "Adres"));
    public MainPanel(){

        this.createPanel();


    }
    private void createPanel(){
        JFrame frame = funct.createFrame("PDF creator", WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel Panel = funct.createPanel(WIDTH, HEIGHT);
        JTable dbTable = funct.createTable(1200, 1000);
        dbTable = this.configureTable(dbTable);
        dbTable.setRowHeight(32);
        dbTable.getTableHeader().setReorderingAllowed(false);
        dbTable.getColumnModel().getColumn(5).setMinWidth(100);
        dbTable.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        dbTable.setDefaultRenderer(Object.class, centerRenderer);
            // Create a LineBorder and apply it to the selected row
            dbTable.getSelectionModel().setSelectionInterval(0, 0);
            dbTable.setBorder(new CompoundBorder(new LineBorder(Color.BLACK, 2), dbTable.getBorder()));
        //dbTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        dbTable = dbTableUpdate(dbTable, frame);
        Panel.add(dbTable);
        frame.add(Panel);
        frame.setVisible(true);
    }
    private JTable configureTable(JTable table){
        DefaultTableModel model = new DefaultTableModel();
        List<String> columns = this.Columns;
        for(int i = 0; i<columns.size(); i++)
        {
            model.addColumn(columns.get(i));
        }
        Object[] row = new Object[Columns.size()];
        for (int i = 0; i < Columns.size(); i++) {
            row[i] = Columns.get(i);
        }
        model.addRow(row);
        table.setModel(model);
        return table;

    }
    private List<String> getcolumns(){
        String url = "jdbc:sqlite:zielen.db";
        List<String> columnNames = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("PRAGMA table_info(DeadPeople)")) {

            while (rs.next()) {
                String columnName = rs.getString("name");
                columnNames.add(columnName);
            }
            System.out.println("Column names: " + columnNames);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnNames;
    }
    private JTable dbTableUpdate(JTable table, JFrame frame){
        frame.add(new JScrollPane(table));
        String JDBC_URL = "jdbc:sqlite:zielen.db";
        String SELECT_QUERY = "SELECT * FROM DeadPeople";
        // Load data from the SQLite database into the JTable
        try {
            Connection conn = DriverManager.getConnection(JDBC_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_QUERY);

            // Get the column names and add them to the table model
            int columnCount = rs.getMetaData().getColumnCount();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

            // Add rows to the table model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }

            // Clean up resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }
}
