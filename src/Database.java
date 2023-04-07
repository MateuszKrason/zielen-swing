import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class Database {
    public Database() {
    }

    void addColumn(String url, String columnName, String dataFormat) {
        if (url == null) {
            url = "jdbc:sqlite:zielen.db";
        }
        String sql = "ALTER TABLE DeadPeople ADD COLUMN " + columnName + " " + dataFormat;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // add the new column to the table
            stmt.execute(sql);
            System.out.println("New column added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
    void createTable(String url, String tableName){
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE " + tableName + " ("
                    + "id INTEGER PRIMARY KEY"
                    + ")";
            stmt.execute(sql);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    void addElementToDB(Integer Id, String DeadPeople, String Imie, String NrSwiadectwa, String Nazwisko, String DataUrodzenia, String MiejsceUrodzenia,
                        String DataSmierci, String MiejsceSmierci, String NrAktuZgonu, String Wydanego,Boolean Plec,String Data,String Adres){
        String sql = "INSERT INTO " + "DeadPeople" + " (Id, Imie, NrSwiadectwa, Nazwisko, DataUrodzenia, MiejsceUrodzenia, DataSmierci, MiejsceSmierci, NrAktuZgonu, Wydanego, Plec, Data, Adres) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:zielen.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Id);
            pstmt.setString(2, Imie);
            pstmt.setString(3, NrSwiadectwa);
            pstmt.setString(4, Nazwisko);
            pstmt.setString(5, DataUrodzenia);
            pstmt.setString(6, MiejsceUrodzenia);
            pstmt.setString(7, DataSmierci);
            pstmt.setString(8, MiejsceSmierci);
            pstmt.setString(9, NrAktuZgonu);
            pstmt.setString(10, Wydanego);
            pstmt.setBoolean(11, Plec);
            pstmt.setString(12, Data);
            pstmt.setString(13, Adres);
            pstmt.executeUpdate();
            System.out.println("Record added to " + DeadPeople + " successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
