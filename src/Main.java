import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:zielen.db");
            System.out.println("Opened database connection!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't connect");
        }
        MainFunctions main = new MainFunctions();
    }
}
