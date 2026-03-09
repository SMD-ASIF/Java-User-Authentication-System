import java.sql.Connection;
import database.DBConnection;
import ui.createaccount;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            Connection con = DBConnection.getConnection();
            System.out.println("Database Connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new createaccount();
    }
}
