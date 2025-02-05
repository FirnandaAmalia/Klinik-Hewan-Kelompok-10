package Kode.Aplikasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/petcare";
        String username = "root";
        String password = "";

        // Establishing database connection (optional for your GUI application)
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to database established.");

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }

        // Launch the LoginPage GUI
        // SwingUtilities.invokeLater(() -> {
        //     LoginPage loginPage = new LoginPage();
        //     loginPage.setVisible(true);  // Ensure the LoginPage is visible
        });
    }
}