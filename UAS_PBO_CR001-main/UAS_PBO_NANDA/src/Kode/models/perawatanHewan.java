// PerawatanHewan.java
package Kode.models;

public class perawatanHewan {
    private String namaPemilik;
    private String nomorHP;
    private String alamat;
    private String namaHewan;
    private String jenisHewan;
    private String kelamin;
    private String umur;
    private String layanan;
    private String keluhan;

    // Constructor
    public perawatanHewan(String namaPemilik, String nomorHP, String alamat, 
            String namaHewan, String jenisHewan, String kelamin, 
            String umur, String layanan, String keluhan) {
        this.namaPemilik = namaPemilik;
        this.nomorHP = nomorHP;
        this.alamat = alamat;
        this.namaHewan = namaHewan;
        this.jenisHewan = jenisHewan;
        this.kelamin = kelamin;
        this.umur = umur;
        this.layanan = layanan;
        this.keluhan = keluhan;
    }

    // Getters
    public String getNamaPemilik() {
        return namaPemilik;
    }

    public String getNomorHP() {
        return nomorHP;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNamaHewan() {
        return namaHewan;
    }

    public String getJenisHewan() {
        return jenisHewan;
    }

    public String getKelamin() {
        return kelamin;
    }

    public String getUmur() {
        return umur;
    }

    public String getLayanan() {
        return layanan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    // Setters
    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public void setNomorHP(String nomorHP) {
        this.nomorHP = nomorHP;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNamaHewan(String namaHewan) {
        this.namaHewan = namaHewan;
    }

    public void setJenisHewan(String jenisHewan) {
        this.jenisHewan = jenisHewan;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public void setLayanan(String layanan) {
        this.layanan = layanan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
}