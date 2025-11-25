import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee {
    public static void main(String args[]) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/organization";
        String username = "root";
        String password = "";

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM employees where gender = ?";

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, username, password);

            pst = con.prepareStatement(sql);

            

            Scanner scan=new Scanner(System.in);

            System.out.println("Enter the Gender (M | F):");

            String gender=scan.next();


            pst.setString(1,gender);

            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("emp_id") + " " + 
                    rs.getString("emp_name") + " " + 
                    rs.getString("gender")
                );
            }

            pst.close();
            con.close();

        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver not found: " + cnfe);
        } catch (SQLException sqle) {
            System.out.println("SQL Error: " + sqle);
        } 
    }
}
