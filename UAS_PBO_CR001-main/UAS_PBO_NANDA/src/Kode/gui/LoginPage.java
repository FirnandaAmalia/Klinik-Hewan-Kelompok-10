package Kode.gui;

import Kode.controllers.UserController;
import java.awt.*;
import javax.swing.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserController userController;

    public LoginPage() {
        userController = new UserController(); // Inisialisasi UserController

        // Mendapatkan ukuran layar desktop
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

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

        JLabel B3Label = new JLabel("Whatsapp: +62 853 1157 2582 ");
        B3Label.setFont(new Font("Arial", Font.PLAIN, 20));
        B3Label.setForeground(Color.WHITE);
        B3Label.setBounds(70, 440, 560, 30);
        B.add(B3Label);

        // Label judul
        JLabel C1Label = new JLabel("SIGN IN");
        C1Label.setFont(new Font("Arial", Font.BOLD, 25));
        C1Label.setForeground(Color.WHITE);
        C1Label.setBounds(190, 20, 250, 40);
        C.add(C1Label);

        // Label judul
        JLabel C2Label = new JLabel("Belum Punya Akun?");
        C2Label.setFont(new Font("Arial", Font.BOLD, 14));
        C2Label.setForeground(Color.WHITE);
        C2Label.setBounds(174, 284, 250, 40);
        C.add(C2Label);

        // Input username
        usernameField = new JTextField();
        usernameField.setBounds(100, 80, 300, 40);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        usernameField.setForeground(Color.GRAY);
        usernameField.setText("Masukkan Username*");
        usernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (usernameField.getText().equals("Masukkan Username*")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setText("Masukkan Username*");
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
        passwordField.setText("Masukkan Password*");
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Masukkan Password*")) {
                    passwordField .setText("");
                    passwordField.setEchoChar('•');
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    passwordField.setText("Masukkan Password*");
                    passwordField.setEchoChar((char) 0);
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });
        C.add(passwordField);

        // Tombol Login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 200, 300, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(70, 130, 180)); // Warna yang sama dengan tombol Buat Akun
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                loginButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(50, 110, 160), 3),
                    BorderFactory.createEmptyBorder(2, 2, 2, 2)
                ));
                loginButton.setBackground(new Color(90, 150, 200)); // Warna lebih cerah saat hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                loginButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2));
                loginButton.setBackground(new Color(70, 130, 180)); // Kembali ke warna awal
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                loginButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(40, 100, 140), 4),
                    BorderFactory.createEmptyBorder(1, 1, 1, 1)
                ));
                loginButton.setBackground(new Color(60, 120, 180)); // Warna lebih gelap saat ditekan
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                loginButton.setBorder(BorderFactory.createLineBorder(new Color(50, 110, 160), 3));
                loginButton.setBackground(new Color(90, 150, 200)); // Warna hover kembali
            }
        });

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Autentikasi user
            if (userController.authenticate(username, password)) {
                new MainPage();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        C.add(loginButton);

        // Tombol Buat Akun
        JButton signUpButton = new JButton("Buat Akun");
        signUpButton.setBounds(100, 320, 300, 40); // Ditempatkan di bawah tombol Login
        signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(new Color(70, 130, 180)); // Warna yang sama dengan tombol Login
        signUpButton.setFocusPainted(false);
        signUpButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2));
        signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Tambahkan efek shadow saat mouse masuk dan keluar
        signUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                signUpButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(50, 110, 160), 3),
                    BorderFactory.createEmptyBorder(2, 2, 2, 2)
                ));
                signUpButton.setBackground(new Color(90, 150, 200)); // Warna lebih cerah saat hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                signUpButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2));
                signUpButton.setBackground(new Color(70, 130, 180)); // Kembali ke warna awal
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                signUpButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(40, 100, 140), 4),
                    BorderFactory.createEmptyBorder(1, 1, 1, 1)
                ));
                signUpButton.setBackground(new Color(60, 120, 180)); // Warna lebih gelap saat ditekan
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                signUpButton.setBorder(BorderFactory.createLineBorder(new Color(50, 110, 160), 3));
                signUpButton.setBackground(new Color(90, 150, 200)); // Warna hover kembali
            }
        });

        // Tambahkan ActionListener untuk tombol
        signUpButton.addActionListener(e -> {
            new CreateAccountPage(); // Membuka frame Sign Up
            setVisible(false); // Menyembunyikan frame login
        });
        C.add(signUpButton);
        
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
        SwingUtilities.invokeLater(() -> new LoginPage());
    }
}