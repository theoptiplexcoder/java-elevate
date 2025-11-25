import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CheckConnections {

    public static void main(String args[]) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/organization";
        String username = "root";
        String password = "";

        Connection con = null;
        try {
            // load the jdbc driver to JVM
            Class.forName(driver);
            // get the connection
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful ...");
            con.close();
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }
}