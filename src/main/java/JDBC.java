//STEP 1. Import required packages

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";

    // Database credentials
    static final String USER = "vlad";
    static final String PASS = "vlad";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT name, pass, email FROM Useri";

            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String name = rs.getString("name");
                String pass = rs.getString("pass");
                String email = rs.getString("email");

                //Display values
                System.out.print("Name: " + name);
                System.out.print(", Pass: " + pass);
                System.out.print(", Email: " + email);
                System.out.print("\n");
            }
            rs.close();
        } catch (SQLException se) { //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) { //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }//end main
}//end JDBCExample

