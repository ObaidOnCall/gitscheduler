package ma.obayd.gitscheduler;

import java.sql.DriverManager;
import java.sql.Connection;


public class DataSourceTest {
    
    public static void main(String[] args) {
        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/gitschedulerDB";
            String user = "root";
            String password = "Hour123*/*@@";
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successful!");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
