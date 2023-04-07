import org.w3c.dom.Text;

public class MainFunctions {
    public MainFunctions(){
        Database db = new Database();
        db.createTable("jdbc:sqlite:zielen.db", "DeadPeople");
        db.addColumn("jdbc:sqlite:zielen.db", "Id", "INTEGER");
        db.addColumn("jdbc:sqlite:zielen.db", "Imie", "TEXT");
        db.addColumn("jdbc:sqlite:zielen.db", "NrSwiadectwa", "TEXT");
        db.addColumn("jdbc:sqlite:zielen.db", "Nazwisko", "TEXT");
        db.addColumn("jdbc:sqlite:zielen.db", "DataUrodzenia", "TEXT");
        db.addColumn("jdbc:sqlite:zielen.db", "MiejsceUrodzenia", "TEXT");
        db.addColumn("jdbc:sqlite:zielen.db", "DataSmierci", "TEXT");
        db.addColumn("jdbc:sqlite:zielen.db", "MiejsceSmierci", "TEXT");
        db.addColumn("jdbc:sqlite:zielen.db", "NrAktuZgonu", "TEXT");
        db.addColumn("jdbc:sqlite:zielen.db", "Wydanego", "TEXT");
        db.addColumn("jdbc:sqlite:zielen.db", "Plec", "BOOLEAN");
        db.addColumn("jdbc:sqlite:zielen.db", "Data", "TEXT");
        db.addColumn("jdbc:sqlite:zielen.db", "Adres", "TEXT");

        Test t1 = new Test();
        t1.Test1();
        MainPanel app = new MainPanel();
    }
}
