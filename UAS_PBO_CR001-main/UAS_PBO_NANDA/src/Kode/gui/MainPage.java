package Kode.gui;

import javax.swing.*;

import Kode.controllers.UserController;
import Kode.models.perawatanHewan;
import Kode.models.penitipanHewan;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame { //Inheritance
    private UserController userController;// Enkapsulasi
    private CardLayout cardLayout; //Enkapsulasi
    private JPanel contentPanel; //Enkapsulasi

    public MainPage() {
        userController = new UserController(); // Inisialisasi UserController

        // Mendapatkan ukuran layar desktop
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Menghapus border dan menyiapkan frame
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenWidth, screenHeight);
        setLayout(null);

        // Panel dasar (Panel A) dengan gambar latar belakang
        JPanel A = new JPanel() {
            @Override //Polymorphism
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("images/background.jpg");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        A.setBounds(0, 0, screenWidth, screenHeight);
        A.setLayout(null);

        // Panel utama (Panel B)
        JPanel B = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Tambahkan bayangan
                g2d.setColor(new Color(0, 0, 0, 100)); // Bayangan transparan
                g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 20, 20);

                // Latar belakang panel transparan
                g2d.setColor(new Color(0, 0, 0, 100));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        B.setBounds((screenWidth - (screenWidth * 4 / 5)) / 2, (screenHeight - (screenHeight * 4 / 5)) / 2, screenWidth * 4 / 5, screenHeight * 4 / 5);
        B.setLayout(null);
        B.setOpaque(false);

        // Panel C (sebelah kiri)
        JPanel C = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        C.setBounds(0, 0, B.getWidth() / 6, B.getHeight());
        C.setLayout(null);

        // Panel D (sebelah kanan)
        JPanel D = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        D.setBounds(C.getWidth(), 0, B.getWidth() - C.getWidth(), B.getHeight());
        D.setLayout(new CardLayout()); // Jika menggunakan CardLayout

        // Panel E (Profile user di dalam Panel C)
        JPanel E = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("images/image.jpg");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Tambahkan bayangan
                g2d.setColor(new Color(0, 0, 0, 0));
                g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 20, 20);
            }
        };
        E.setBounds((C.getWidth() - 100) / 2, (C.getHeight() - 100) / 16, 100, 100);
        E.setLayout(null);

        JLabel C1Label = new JLabel("USER");
        C1Label.setFont(new Font("Arial", Font.BOLD, 20));
        C1Label.setForeground(Color.WHITE);
        C1Label.setBounds((C.getWidth() - C1Label.getPreferredSize().width) / 2, (C.getHeight() - C1Label.getPreferredSize().height) / 5, 130, 30);
        C.add(C1Label);

        // Sidebar panel
        JPanel F = new JPanel();
        F.setLayout(new BoxLayout(F, BoxLayout.Y_AXIS));
        F.setBackground(Color.DARK_GRAY);
        F.setBounds((C.getWidth() - (C.getWidth() * 2 / 3)) / 2 - 25, (C.getHeight() - 100) / 3, C.getWidth() - 20, C.getHeight() / 2);

        // Tambahkan tombol sidebar
        JButton btnHome = createSidebarButton("Home");
        JButton btnPerawatanHewan = createSidebarButton("Perawatan Hewan");
        JButton btnPenitipanHewan = createSidebarButton("Penitipan Hewan");
        JButton btnStatusPelayanan = createSidebarButton("Status Pelayanan");
        JButton btnStatusPembayaran = createSidebarButton("Status Pembayaran");
        JButton btnHistory = createSidebarButton("History");

        // Tambahkan tombol dan sub-menu ke sidebar
        F.add(btnHome);
        F.add(btnPerawatanHewan);
        F.add(btnPenitipanHewan);
        F.add(btnStatusPelayanan);
        F.add(btnStatusPembayaran);
        F.add(btnHistory);

        // Tambahkan sidebar ke panel A
        C.add(F);

        // Panel konten
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.setPreferredSize(new Dimension(D.getWidth() - 100, D.getHeight() - 100));
        D.add(contentPanel);

        // Tambahkan halaman konten
        contentPanel.add(createHomePage(), "Home");
        contentPanel.add(createPerawatanHewanPage(), "Perawatan Hewan");
        contentPanel.add(createPenitipanHewanPage(), "Penitipan Hewan");
        contentPanel.add(createStatusPelayananPage(), "StatusPelayanan");
        contentPanel.add(createStatusPembayaranPage(), "StatusPembayaran");
        contentPanel.add(createHistoryPage(), "History");

        JButton exitButton = new JButton("LOGOUT");
        exitButton.setBounds((C.getWidth() - 100) / 2, (C.getHeight() - 80), 100, 40); // Ukuran dan posisi tombol
        exitButton.setBackground(new Color(255, 0, 0)); // Warna tombol merah
        exitButton.setForeground(Color.WHITE); // Warna teks putih
        exitButton.setFocusPainted(false);
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Tambahkan aksi untuk keluar program
        exitButton.addActionListener(e -> {
            dispose();
            new LoginPage().setVisible(true);
        });
        C.add(exitButton);

        contentPanel.add(createHomePage(), "Home");
        contentPanel.add(createPerawatanHewanPage(), "Perawatan Hewan");
        contentPanel.add(createPenitipanHewanPage(), "Penitipan Hewan");
        contentPanel.add(createStatusPelayananPage(), "Status Pelayanan");
        contentPanel.add(createStatusPembayaranPage(), "Status Pembayaran");
        contentPanel.add(createHistoryPage(), "History");

        btnHome.addActionListener(e -> cardLayout.show(contentPanel, "Home"));
        btnPerawatanHewan.addActionListener(e -> cardLayout.show(contentPanel, "Perawatan Hewan"));
        btnPenitipanHewan.addActionListener(e -> cardLayout.show(contentPanel, "Penitipan Hewan"));
        btnStatusPelayanan.addActionListener(e -> cardLayout.show(contentPanel, "Status Pelayanan"));
        btnStatusPembayaran.addActionListener(e -> cardLayout.show(contentPanel, "Status Pembayaran"));
        btnHistory.addActionListener(e -> cardLayout.show(contentPanel, "History"));

        // Menambahkan komponen ke masing-masing panel
        C.add(E);
        B.add(D);
        B.add(C);
        A.add(B);

        // Menambahkan panel A ke frame
        add(A);

        setVisible(true);
    }

    private JButton createSidebarButton(String text) { //Abstraksi, digunakan untuk menyembunyikan detail implementasi dalam metode
        JButton button = new JButton(text);
        button.setAlignmentX(Component.LEFT_ALIGNMENT); // Rata kiri untuk tombol dalam BoxLayout
        button.setPreferredSize(new Dimension(100, 40));
        button.setMaximumSize(new Dimension(200, 40)); // Ukuran tombol
        button.setFocusPainted(false);                // Hilangkan fokus saat dipilih
        button.setBackground(new Color(70, 70, 70));  // Warna tombol
        button.setForeground(Color.WHITE);            // Warna teks
        button.setFont(new Font("Arial", Font.PLAIN, 16)); // Font teks
        button.setHorizontalAlignment(SwingConstants.LEFT); // Teks berada di kiri tombol
        return button;
    }

    // Halaman konten untuk "Home"
    private JPanel createHomePage() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("HOME", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel content = new JPanel(new GridLayout(1, 2, 20, 20));
        content.setBackground(Color.WHITE);
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel jamPanel = new JPanel(new BorderLayout());
        jamPanel.setBorder(BorderFactory.createTitledBorder("JAM LAYANAN"));
        JTextArea jamText = new JTextArea("""
            SENIN : 09:00 - 20:00
            SELASA : 09:00 - 20:00
            RABU : 09:00 - 20:00
            KAMIS : 09:00 - 20:00
            JUMAT : 09:00 - 20:00
            SABTU : 09:00 - 20:00
            """);
        jamText.setEditable(false);
        jamText.setFont(new Font("Arial", Font.PLAIN, 14));
        jamPanel.add(new JScrollPane(jamText), BorderLayout.CENTER);

        JPanel jadwalPanel = new JPanel(new BorderLayout());
        jadwalPanel.setBorder(BorderFactory.createTitledBorder("JADWAL DOKTER"));
        JTextArea jadwalText = new JTextArea("""
            Dokter 1 : 09:00 - 12:00
            Dokter 2 : 13:00 - 17:00
            """);
        jadwalText.setEditable(false);
        jadwalText.setFont(new Font("Arial", Font.PLAIN, 14));
        jadwalPanel.add(new JScrollPane(jadwalText), BorderLayout.CENTER);

        content.add(jamPanel);
        content.add(jadwalPanel);

        panel.add(content, BorderLayout.CENTER);

        JLabel footer = new JLabel("PET KLINIK", SwingConstants.CENTER);
        footer.setFont(new Font("Arial", Font.PLAIN, 14));
        footer.setForeground(Color.GRAY);
        panel.add(footer, BorderLayout.SOUTH);

        return panel;
    }    

    // Halaman konten untuk "Perawatan Hewan"
    private JPanel createPerawatanHewanPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("FORMULIR PERAWATAN HEWAN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);
    
        JPanel formContainer = new JPanel(new BorderLayout());
        formContainer.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20),
                BorderFactory.createLineBorder(Color.GRAY, 2)));
        formContainer.setBackground(Color.LIGHT_GRAY);
    
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
    
        // Nama Pemilik
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Nama Pemilik:"), gbc);
        gbc.gridx = 1;
        JTextField namaPemilikField = new JTextField(20);
        formPanel.add(namaPemilikField, gbc);
    
        // Nomor HP
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Nomor HP:"), gbc);
        gbc.gridx = 1;
        JTextField nomorHPField = new JTextField(20);
        formPanel.add(nomorHPField, gbc);
    
        // Alamat
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1;
        JTextField alamatField = new JTextField(20);
        formPanel.add(alamatField, gbc);
    
        // Nama Hewan
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Nama Hewan:"), gbc);
        gbc.gridx = 1;
        JTextField namaHewanField = new JTextField(20);
        formPanel.add(namaHewanField, gbc);
    
        // Pilihan Hewan
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Pilihan Hewan:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> pilihanHewanBox = new JComboBox<>(new String[]{"Anjing", "Kucing", "Hamster", "Kelinci", "Lainnya"});
        formPanel.add(pilihanHewanBox, gbc);
    
        // Kelamin
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Kelamin:"), gbc);
        gbc.gridx = 1;
        JPanel kelaminPanel = new JPanel();
        kelaminPanel.setOpaque(false);
        JRadioButton jantanButton = new JRadioButton("Jantan");
        JRadioButton betinaButton = new JRadioButton("Betina");
        ButtonGroup kelaminGroup = new ButtonGroup();
        kelaminGroup.add(jantanButton);
        kelaminGroup.add(betinaButton);
        kelaminPanel.add(jantanButton);
        kelaminPanel.add(betinaButton);
        formPanel.add(kelaminPanel, gbc);
    
        // Umur Hewan
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Umur Hewan:"), gbc);
        gbc.gridx = 1;
        JTextField umurField = new JTextField(20);
        formPanel.add(umurField, gbc);
    
        // Layanan
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Layanan:"), gbc);
        gbc.gridx = 1;
        JPanel layananPanel = new JPanel();
        layananPanel.setOpaque(false);
        JCheckBox cekKesehatanCheckBox = new JCheckBox("Cek Kesehatan");
        JCheckBox vaksinasiCheckBox = new JCheckBox("Vaksinasi");
        JCheckBox groomingCheckBox = new JCheckBox("Grooming");
        JCheckBox emergencyCareCheckBox = new JCheckBox("Perawatan Darurat");
        JCheckBox sterilizationCheckBox = new JCheckBox("Sterilisasi");
        layananPanel.add(cekKesehatanCheckBox);
        layananPanel.add(vaksinasiCheckBox);
        layananPanel.add(groomingCheckBox);
        layananPanel.add(emergencyCareCheckBox);
        layananPanel.add(sterilizationCheckBox);
        formPanel.add(layananPanel, gbc);
    
        // Catatan Keluhan
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Catatan Keluhan:"), gbc);
        gbc.gridx = 1;
        JTextField keluhanField = new JTextField(20);
        formPanel.add(keluhanField, gbc);
    
        // Submit Button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(46, 204, 113));
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namaPemilik = namaPemilikField.getText();
                String nomorHP = nomorHPField.getText();
                String alamat = alamatField.getText();
                String namaHewan = namaHewanField.getText();
                String pilihanHewan = pilihanHewanBox.getSelectedItem().toString();
                String kelamin = jantanButton.isSelected() ? "Jantan" : "Betina";
                String umurHewan = umurField.getText();
                
                StringBuilder layananBuilder = new StringBuilder();
                if (cekKesehatanCheckBox.isSelected()) layananBuilder.append("Cek Kesehatan, ");
                if (vaksinasiCheckBox.isSelected()) layananBuilder.append("Vaksinasi, ");
                if (groomingCheckBox.isSelected()) layananBuilder.append("Grooming, ");
                if (emergencyCareCheckBox.isSelected()) layananBuilder.append("Perawatan Darurat, ");
                if (sterilizationCheckBox.isSelected()) layananBuilder.append("Sterilisasi, ");
                String layanan = layananBuilder.length() > 0 ?
                        layananBuilder.substring(0, layananBuilder.length() - 2) :
                        "Tidak ada layanan";
                
                String keluhan = keluhanField.getText();
                
                // Validasi input
                if (namaPemilik.isEmpty() || nomorHP.isEmpty() || alamat.isEmpty() ||
                        namaHewan.isEmpty() || umurHewan.isEmpty()) {
                    JOptionPane.showMessageDialog(panel,
                            "Harap isi semua kolom yang wajib diisi!",
                            "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                // Buat objek PerawatanHewan
                perawatanHewan perawatan = new perawatanHewan(
                        namaPemilik, nomorHP, alamat, namaHewan,
                        pilihanHewan, kelamin, umurHewan, layanan, keluhan);
                
                // Simpan ke database
                if (userController.savePerawatanHewan(perawatan)) {
                    JOptionPane.showMessageDialog(panel,
                            "Data perawatan hewan berhasil disimpan!",
                            "Sukses",
                            JOptionPane.INFORMATION_MESSAGE);
                    // Clear form fields
                    clearPerawatanForm();
                } else {
                    JOptionPane.showMessageDialog(panel,
                            "Gagal menyimpan data perawatan hewan!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        formPanel.add(submitButton, gbc);
    
        formContainer.add(formPanel, BorderLayout.CENTER);
        panel.add(formContainer, BorderLayout.CENTER);
        return panel;
    }

    // Halaman konten untuk "Penitipan Hewan"
    private JPanel createPenitipanHewanPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("FORMULIR PENITIPAN HEWAN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);
    
        JPanel formContainer = new JPanel(new BorderLayout());
        formContainer.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20),
                BorderFactory.createLineBorder(Color.GRAY, 2)));
        formContainer.setBackground(Color.LIGHT_GRAY);
    
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
    
        // Menambahkan komponen ke dalam form
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Nama Pemilik:"), gbc);
        gbc.gridx = 1;
        JTextField namaPemilikField = new JTextField(20);
        formPanel.add(namaPemilikField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Nomor HP:"), gbc);
        gbc.gridx = 1;
        JTextField nomorHPField = new JTextField(20);
        formPanel.add(nomorHPField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1;
        JTextField alamatField = new JTextField(20);
        formPanel.add(alamatField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Nama Hewan:"), gbc);
        gbc.gridx = 1;
        JTextField namaHewanField = new JTextField(20);
        formPanel.add(namaHewanField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Pilihan Hewan:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> jenisHewanBox = new JComboBox<>(new String[]{"Anjing", "Kucing", "Hamster", "Kelinci", "Lainnya"});
        formPanel.add(jenisHewanBox, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Kelamin:"), gbc);
        gbc.gridx = 1;
        JPanel kelaminPanel = new JPanel();
        kelaminPanel.setOpaque(false); // Transparan agar mengikuti warna background
        JRadioButton jantanButton = new JRadioButton("Jantan");
        JRadioButton betinaButton = new JRadioButton("Betina");
        ButtonGroup kelaminGroup = new ButtonGroup();
        kelaminGroup.add(jantanButton);
        kelaminGroup.add(betinaButton);
        kelaminPanel.add(jantanButton);
        kelaminPanel.add(betinaButton);
        formPanel.add(kelaminPanel, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Jenis Hewan:"), gbc);
        gbc.gridx = 1;
        JTextField jenisField = new JTextField(20);
        formPanel.add(jenisField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Umur Hewan:"), gbc);
        gbc.gridx = 1;
        JTextField umurField = new JTextField(20);
        formPanel.add(umurField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Tanggal Penitipan (DD/MM/YYYY):"), gbc);
        gbc.gridx = 1;
        JTextField tanggalField = new JTextField(20);
        formPanel.add(tanggalField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Penginapan:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> penginapanBox = new JComboBox<>(new String[]{"Harian", "Mingguan", "Bulanan"});
        formPanel.add(penginapanBox, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Catatan Keluhan:"), gbc);
        gbc.gridx = 1;
        JTextField keluhanField = new JTextField(20);
        formPanel.add(keluhanField, gbc);
    
        // Submit Button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(46, 204, 113));
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namaPemilik = namaPemilikField.getText().trim();
                String nomorHP = nomorHPField.getText().trim();
                String alamat = alamatField.getText().trim();
                String namaHewan = namaHewanField.getText().trim();
                String jenisHewan = jenisHewanBox.getSelectedItem().toString(); // Mengambil dari ComboBox
                String kelamin = jantanButton.isSelected() ? "Jantan" : "Betina";
                String umurHewan = umurField.getText().trim();
                String tanggalPenitipan = tanggalField.getText().trim();
                String penginapan = penginapanBox.getSelectedItem().toString();
                String keluhan = keluhanField.getText().trim();
                
                // Validasi input yang lebih lengkap
                if (namaPemilik.isEmpty() || nomorHP.isEmpty() || alamat.isEmpty() ||
                    namaHewan.isEmpty() || jenisHewan.isEmpty() || umurHewan.isEmpty() || 
                    tanggalPenitipan.isEmpty() || !kelaminGroup.getSelection().isSelected()) {
                    
                    JOptionPane.showMessageDialog(panel,
                            "Harap isi semua kolom yang wajib diisi!\n" +
                            "- Nama Pemilik\n" +
                            "- Nomor HP\n" +
                            "- Alamat\n" +
                            "- Nama Hewan\n" +
                            "- Jenis Hewan\n" +
                            "- Kelamin Hewan\n" +
                            "- Umur Hewan\n" +
                            "- Tanggal Penitipan",
                            "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                // Validasi format nomor HP
                if (!nomorHP.matches("\\d+")) {
                    JOptionPane.showMessageDialog(panel,
                            "Nomor HP hanya boleh berisi angka!",
                            "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                // Validasi format tanggal
                if (!tanggalPenitipan.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    JOptionPane.showMessageDialog(panel,
                            "Format tanggal harus DD/MM/YYYY!",
                            "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                try {
                    // Buat objek PenitipanHewan
                    penitipanHewan penitipan = new penitipanHewan(
                            namaPemilik, nomorHP, alamat, namaHewan,
                            jenisHewan, kelamin, umurHewan, tanggalPenitipan,
                            penginapan, keluhan);
                    
                    // Simpan ke database
                    if (userController.savePenitipanHewan(penitipan)) {
                        JOptionPane.showMessageDialog(panel,
                                "Data penitipan hewan berhasil disimpan!",
                                "Sukses",
                                JOptionPane.INFORMATION_MESSAGE);
                        clearPenitipanForm(); // Clear form setelah berhasil
                    } else {
                        JOptionPane.showMessageDialog(panel,
                                "Gagal menyimpan data penitipan hewan!\nSilakan cek koneksi database.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel,
                            "Terjadi kesalahan: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
            
            // Implementasi method clearPenitipanForm
            private void clearPenitipanForm() {
                namaPemilikField.setText("");
                nomorHPField.setText("");
                alamatField.setText("");
                namaHewanField.setText("");
                jenisHewanBox.setSelectedIndex(0);
                kelaminGroup.clearSelection();
                umurField.setText("");
                tanggalField.setText("");
                penginapanBox.setSelectedIndex(0);
                keluhanField.setText("");
            }
        });
        formPanel.add(submitButton, gbc);
    
        formContainer.add(formPanel, BorderLayout.CENTER);
        panel.add(formContainer, BorderLayout.CENTER);
        return panel;
    }

    // Halaman konten untuk "Status Pelayanan"
    private JPanel createStatusPelayananPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("STATUS PELAYANAN", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // Halaman konten untuk "Pembayaran"
    private JPanel createStatusPembayaranPage() {
        // Panel utama dengan layout BorderLayout untuk membagi dua bagian kiri dan kanan
        JPanel panelB = new JPanel(new BorderLayout());
    
        JPanel B1 = new JPanel();
        B1.setBackground(Color.LIGHT_GRAY);
        JLabel label1 = new JLabel("STATUS PEMBAYARAN");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setForeground(Color.BLACK);
        B1.add(label1, BorderLayout.CENTER);
    
        JPanel B2 = new JPanel();
        B2.setBackground(Color.LIGHT_GRAY);
        JLabel label2 = new JLabel("PET KLINIK");
        label2.setFont(new Font("Arial", Font.BOLD, 24));
        label2.setForeground(Color.BLACK);
        B2.add(label2, BorderLayout.CENTER);

        panelB.add(B1, BorderLayout.NORTH);
        panelB.add(B2, BorderLayout.SOUTH);

        return panelB;
    }

    // Halaman konten untuk "History"
    private JPanel createHistoryPage() {
        // Panel utama dengan layout BorderLayout untuk membagi dua bagian kiri dan kanan
        JPanel panelB = new JPanel(new BorderLayout());
    
        JPanel B1 = new JPanel();
        B1.setBackground(Color.LIGHT_GRAY);
        JLabel label1 = new JLabel("HISTORY");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setForeground(Color.BLACK);
        B1.add(label1, BorderLayout.CENTER);
    
        JPanel B2 = new JPanel();
        B2.setBackground(Color.LIGHT_GRAY);
        JLabel label2 = new JLabel("PET KLINIK");
        label2.setFont(new Font("Arial", Font.BOLD, 24));
        label2.setForeground(Color.BLACK);
        B2.add(label2, BorderLayout.CENTER);

        panelB.add(B1, BorderLayout.NORTH);
        panelB.add(B2, BorderLayout.SOUTH);

        return panelB;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainPage::new);
    }

    private void clearPerawatanForm() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
