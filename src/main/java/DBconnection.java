//STEP 1. Import required packages

import java.sql.*;

public class DBconnection {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    //jdbc:oracle:thin:@hostname:port Number:databaseName
    // Database credentials
    static final String USER = "RARES";
    static final String PASS = "RARES";

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
            String sql = "SELECT * FROM userData";

            ResultSet rs = stmt.executeQuery(sql);
//STEP 5: Extract data from result set
            //System.out.println("GG");
            while (rs.next()) {
                System.out.println("GG");
                //Retrieve by column name
                String username = rs.getString("user_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
//Display values
                System.out.print("UserName: " + username);
                System.out.print(", email: " + email);
                System.out.print(", password: " + password);
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
        System.out.println("\nGoodbye!");
    }//end main
}//end JDBCExample
