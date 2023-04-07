public class Test {
    public Test() {

    }
    void Test1(){
        Database db = new Database();
        for(int i=0; i<200; i++){
            db.addElementToDB(i+1, "DeadPeople","Antek", "Sawicki",
                    "2137", "siema", "Gdynia", "dzisiaj", "Gdynia",
                    "1", "Dzisiaj", Boolean.TRUE, "01.01.2000", "Polna");
        }
    }
}
