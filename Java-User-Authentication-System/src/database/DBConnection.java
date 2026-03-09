package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
      static String url ="jdbc:mysql://localhost:3306/user_system";
      static String user = "root";
      static String password="Asifsmd@1975";
      public static Connection getConnection() throws Exception {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
      }

}
