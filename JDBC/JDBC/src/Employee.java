import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Employee {
    public static void main(String args[]) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/organization";
        String username = "root";
        String password = "";

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM employees";

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, username, password);

            st = con.createStatement();

            rs = st.executeQuery(sql);

            // Iterate result set
            while (rs.next()) {
                System.out.println(
                    rs.getInt("emp_id") + " " + 
                    rs.getString("emp_name") + " " + 
                    rs.getString("gender")
                );
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver not found: " + cnfe);
        } catch (SQLException sqle) {
            System.out.println("SQL Error: " + sqle);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
