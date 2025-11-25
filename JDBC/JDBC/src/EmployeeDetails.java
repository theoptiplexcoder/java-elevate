import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDetails {
    public static void main(String args[]) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/organization";
        String username = "root";
        String password = "";

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM employees where emp_id = ?";

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, username, password);

            pst = con.prepareStatement(sql);

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter Employee id:");

            int id=scan.nextInt();

            pst.setInt(1, id);

            rs=pst.executeQuery();
            
            if (rs.next()) {
                System.out.println(
                    rs.getInt("emp_id") + " " + 
                    rs.getString("emp_name") + " " + 
                    rs.getString("gender")
                );
            }
            else{
                System.out.println("Employee not found!! 404");
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver not found: " + cnfe);
        } catch (SQLException sqle) {
            System.out.println("SQL Error: " + sqle);
        } 
    }
}
