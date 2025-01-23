import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;  // Added import statement for ResultSet

public class Connect {

    // Method to establish a connection to the SQLite database
    public static Connection connectToDB() {
        Connection con = null;
        try {
            // Specify the location of the SQLite database file (it will create the file if it doesn't exist)
            String url = "jdbc:sqlite:library.db"; 
            con = DriverManager.getConnection(url); // Get the connection to SQLite
            System.out.println("Connection to SQLite database established.");
        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite: " + e.getMessage());
        }
        return con;
    }

    // Method to create the 'users' table if it doesn't exist
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "userid TEXT NOT NULL, " +
                     "password TEXT NOT NULL)";
        try (Connection con = connectToDB(); 
             Statement stmt = con.createStatement()) {
            stmt.execute(sql); // Execute the SQL query to create the table
            System.out.println("Table 'users' created or already exists.");
            con.close();
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    // Method to insert a new user into the 'users' table if the table is empty
    public static void insertData(String userid, String password) {
        String sql = "SELECT COUNT(*) FROM users WHERE userid = ?"; // Check if the user already exists
        try (Connection con = connectToDB(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, userid); // Set the 'userid' value to check for duplicates
            ResultSet rs = pstmt.executeQuery();  // This will give you the ResultSet

            if (rs.next() && rs.getInt(1) == 0) { // If the user doesn't exist
                String insertSql = "INSERT INTO users(userid, password) VALUES(?, ?)"; // SQL query for insertion
                try (PreparedStatement insertPstmt = con.prepareStatement(insertSql)) {
                    insertPstmt.setString(1, userid); // Set the 'userid' value
                    insertPstmt.setString(2, password); // Set the 'password' value
                    insertPstmt.executeUpdate(); // Insert the new user into the table
                    System.out.println("User added successfully: " + userid);
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error inserting user: " + e.getMessage());
                }
            } else {
                System.out.println("User already exists or invalid check.");
            }
        } catch (SQLException e) {
            System.out.println("Error checking user existence: " + e.getMessage());
        }
    }  
}
