package Kode.controllers;
import Kode.models.penitipanHewan;
import Kode.models.perawatanHewan;
import java.sql.*;

public class UserController {
    private Connection connection;

    public UserController() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
        }
    }

    public boolean registerUser(String username, String password) {
        String checkQuery = "SELECT username FROM users WHERE username = ?";
        String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
        
        try {
            // Cek apakah username sudah ada
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next()) {
                return false; // Username sudah ada
            }
            
            // Insert user baru
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean authenticate(String username, String password) {
        String query = "SELECT password FROM users WHERE username = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                return storedPassword.equals(password);
            }
            return false;
            
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean savePerawatanHewan(perawatanHewan perawatan) {
        String query = "INSERT INTO perawatan_hewan (nama_pemilik, nomor_hp, alamat, " +
                      "nama_hewan, jenis_hewan, kelamin, umur, layanan, keluhan) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, perawatan.getNamaPemilik());
            ps.setString(2, perawatan.getNomorHP());
            ps.setString(3, perawatan.getAlamat());
            ps.setString(4, perawatan.getNamaHewan());
            ps.setString(5, perawatan.getJenisHewan());
            ps.setString(6, perawatan.getKelamin());
            ps.setString(7, perawatan.getUmur());
            ps.setString(8, perawatan.getLayanan());
            ps.setString(9, perawatan.getKeluhan());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean savePenitipanHewan(penitipanHewan penitipan) {
        String query = "INSERT INTO penitipan_hewan (nama_pemilik, nomor_hp, alamat, " +
                      "nama_hewan, jenis_hewan, kelamin, umur, tanggal_penitipan, " +
                      "penginapan, keluhan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, penitipan.getNamaPemilik());
            ps.setString(2, penitipan.getNomorHP());
            ps.setString(3, penitipan.getAlamat());
            ps.setString(4, penitipan.getNamaHewan());
            ps.setString(5, penitipan.getJenisHewan());
            ps.setString(6, penitipan.getKelamin());
            ps.setString(7, penitipan.getUmur());
            ps.setString(8, penitipan.getTanggalPenitipan());
            ps.setString(9, penitipan.getPenginapan());
            ps.setString(10, penitipan.getKeluhan());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
}
}