package Kode.gui;

import Kode.controllers.UserController;
import java.awt.*;
import javax.swing.*;

public class CreateAccountPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private UserController userController;

    public CreateAccountPage() {
        userController = new UserController(); // Inisialisasi UserController

        // Mendapatkan ukuran layar desktop
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Mengatur ukuran jendela agar sesuai dengan ukuran layar desktop
        setSize(screenWidth, screenHeight);
        setLocation((screenWidth - getWidth()), (screenHeight - getHeight()));
        
        // Menghapus border dan menyiapkan frame
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mengatur mode fullscreen dengan GraphicsDevice
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        device.setFullScreenWindow(this); // Mengatur frame menjadi fullscreen

        // Panel utama dengan gambar latar belakang
        JPanel A = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("images/background.jpg");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        A.setSize(screenWidth, screenHeight);
        A.setLayout(null);
        
        JPanel B = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
                // Tambahkan bayangan
                g2d.setColor(new Color(0, 0, 0, 100)); // Warna hitam dengan transparansi untuk bayangan
                g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 20, 20);
        
                // Latar belakang panel transparan
                g2d.setColor(new Color(0, 0, 0, 100)); // Warna hitam dengan transparansi untuk latar belakang
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        
        B.setSize(screenWidth * 7 / 9, screenHeight * 7 / 9);
        B.setLayout(null);
        B.setOpaque(false); // Menjadikan panel transparan
        B.setLocation(
            (getWidth() - B.getWidth()) / 2,
            (getHeight() - B.getHeight()) / 2
        );

        // Panel login dengan efek transparansi dan bayangan
        JPanel C = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Tambahkan bayangan
                g2d.setColor(new Color(0, 0, 0, 200));
                g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 20, 20);

            
            }
        };
        C.setSize(500, 400);
        C.setLayout(null);
        C.setLocation(
            (B.getWidth() - C.getWidth()) * 9 / 10 ,
            (B.getHeight() - C.getHeight()) / 2
        );

        // Tambahkan panel login ke panel utama
        A.add(B);
        B.add(C);

        // Tambahkan tombol keluar di sudut kanan atas
        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(1050, 600, 100, 40); // Ukuran dan posisi tombol
        exitButton.setBackground(new Color(255, 0, 0)); // Warna tombol merah
        exitButton.setForeground(Color.WHITE); // Warna teks putih
        exitButton.setFocusPainted(false);
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Tambahkan aksi untuk keluar program
        exitButton.addActionListener(e -> System.exit(0));
        B.add(exitButton);

        JLabel B1Label = new JLabel("<html>HALO, SELAMAT DATANG DI PET KLINIK KAMI.");
        B1Label.setFont(new Font("Arial", Font.BOLD, 32));
        B1Label.setForeground(Color.WHITE);
        B1Label.setBounds(70, 160, 560, 140);
        B.add(B1Label);

        JLabel B2Label = new JLabel("<html>Pet Klinik adalah layanan yang menyediakan perawatan kesehatan, grooming, dan kebutuhan kesejahteraan hewan peliharaan Anda, memastikan mereka tetap sehat, nyaman, dan bahagia.");
        B2Label.setFont(new Font("Arial", Font.PLAIN, 20));
        B2Label.setForeground(Color.WHITE);
        B2Label.setBounds(70, 280, 540, 140); // Tinggi diperbesar agar muat teks
        B.add(B2Label);

        JLabel B3Label = new JLabel("Whatsapp: +62 853 1157 2582");
        B3Label.setFont(new Font("Arial", Font.PLAIN, 20));
        B3Label.setForeground(Color.WHITE);
        B3Label.setBounds(70, 440, 560, 30);
        B.add(B3Label);

        // Label judul
        JLabel C1Label = new JLabel("CREATE ACCOUNT");
        C1Label.setFont(new Font("Arial", Font.BOLD, 25));
        C1Label.setForeground(Color.WHITE);
        C1Label.setBounds(124, 20, 250, 40);
        C.add(C1Label);

        // Input username
        usernameField = new JTextField();
        usernameField.setBounds(100, 80, 300, 40);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        usernameField.setForeground(Color.GRAY);
        usernameField.setText("Username");
        usernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (usernameField.getText().equals("Username")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setText("Username");
                    usernameField.setForeground(Color.GRAY);
                }
            }
        });
        C.add(usernameField);

        // Input password
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 140, 300, 40);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        passwordField.setForeground(Color.GRAY);
        passwordField.setEchoChar((char) 0);
        passwordField.setText("Password");
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('•');
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0);
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });
        C.add(passwordField);

        // Input konfirmasi password
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(100, 200, 300, 40);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmPasswordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        confirmPasswordField.setForeground(Color.GRAY);
        confirmPasswordField.setEchoChar((char) 0);
        confirmPasswordField.setText("Konfirmasi Password");
        confirmPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (String.valueOf(confirmPasswordField.getPassword()).equals("Konfirmasi Password")) {
                    confirmPasswordField.setText("");
                    confirmPasswordField.setEchoChar('•');
                    confirmPasswordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (confirmPasswordField.getPassword().length == 0) {
                    confirmPasswordField.setText("Konfirmasi Password");
                    confirmPasswordField.setEchoChar((char) 0);
                    confirmPasswordField.setForeground(Color.GRAY);
                }
            }
        });
        C.add(confirmPasswordField);

        // Tombol Buat Akun
        JButton registerButton = new JButton("Buat Akun");
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setBackground(new Color(70, 130, 180));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setBounds(100, 260, 300, 40);
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Password dan konfirmasi tidak cocok!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (userController.registerUser (username, password)) {
                JOptionPane.showMessageDialog(this, "Akun berhasil dibuat!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new LoginPage(); // Kembali ke halaman login
            } else {
                JOptionPane.showMessageDialog(this, "Username sudah digunakan!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        C.add(registerButton);

        // Tombol Kembali
        JButton backButton = new JButton("Kembali");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(220, 20, 60));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBounds(100, 320, 300, 40);
        backButton.addActionListener(e -> {
            dispose();
            new LoginPage(); // Kembali ke halaman login
        });
        C.add(backButton);
        
        // Pastikan tampilan diperbarui
        SwingUtilities.invokeLater(() -> {
            A.revalidate();
            A.repaint();
        });

        // Tambahkan panel utama ke frame
        add(A);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreateAccountPage());
    }
}
