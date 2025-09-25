package library.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    
    // Logger instance
    private static final Logger logger = Logger.getLogger(DBConnect.class.getName());

    public static Connection connect() {
        Connection conn = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection to the MySQL database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            System.out.println("Connection established successfully!");
            
        } catch (ClassNotFoundException e) {
            // Handle error if JDBC driver is not found
            logger.log(Level.SEVERE, "MySQL JDBC Driver not found.", e);
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found.", "Driver Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            // Handle SQL-related errors
            logger.log(Level.SEVERE, "Failed to connect to the database. Check your connection details.", e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Connection Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Catch any other exceptions
            logger.log(Level.SEVERE, "An unexpected error occurred.", e);
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}
