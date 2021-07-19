import java.sql.*;

public class JDBCExample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl"; //sid la final nu dbname

    // Database credentials
    static final String USER = "maria";
    static final String PASS = "maria";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            String sql = "UPDATE Users set password=? WHERE username=?";
            stmt = conn.prepareStatement(sql);

            //Bind values into the parameters.
            stmt.setString(1, "mra77");  // This would set password
            stmt.setString(2, "mariap78"); // This would set username

            // Let us update password of the record with username = mariap78;
            int rows = stmt.executeUpdate();
            System.out.println("Rows impacted : " + rows );

            // Let us select all the records and display them.
            sql = "SELECT username, password, email FROM Users";
            ResultSet rs = stmt.executeQuery(sql);

//            String sql = "SELECT username, password, email FROM Users";
//            stmt = conn.prepareStatement(sql);
//
//            ResultSet rs = stmt.executeQuery(sql);
//
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                //Display values
                System.out.print("username: " + username);
                System.out.print(", password: " + password);
                System.out.print(", email: " + email);
                System.out.println("\n");
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
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Bye Bye!");
    }//end main
}//end JDBCExample