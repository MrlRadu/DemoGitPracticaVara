import java.sql.*;

public class Users {
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";

    static final String USER = "alex";
    static final String PASS = "alex";

    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting...");
            conn=DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT Username,Password,Email FROM Users";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String Name = rs.getString("Username");
                String Password = rs.getString("Password");
                String Email = rs.getString("Email");
                System.out.println();
                System.out.println("Username: " + Name);
                System.out.println("Password: " + Password);
                System.out.println("Email: " + Email);
            }

            rs.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("\nGoodbye!");
    }
}
